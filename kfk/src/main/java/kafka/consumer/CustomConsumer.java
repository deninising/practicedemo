package kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * 描述：手动提交offset
 *
 * @author Dennis
 * @version 1.0
 * @date 2020/2/3 14:43
 */
public class CustomConsumer {
    public static void main(String[] args) {
        Properties props = new Properties();
        // 定义 kakfa 服务的地址，不需要将所有 broker 指定上
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "master:9092");
        // 是否自动确认 offset
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        // 自动提交 offset 的时间间隔,手动提交时该设置无意义
//        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        // key 的序列化类
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        // value 的序列化类
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        // 制定 consumer group
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "test1");
        // 定义 consumer
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        // 消费者订阅的 topic, 可同时订阅多个
        List<String> topics = Arrays.asList("first", "second", "third");
        consumer.subscribe(topics);
        try {
            while (true) {
                // 拉取数据，读取超时时间为100ms(没拉取到数据时生效)
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
                records.forEach(item -> {
                    System.out.printf("offset = %d, key = %s, value = %s%n", item.offset(), item.key(), item.value());
                });


                //*********************************************************************************//
                // 无论是同步提交还是异步提交都可能会造成数据的漏消费或重复消费：先提交offset后消费，会造成数据的漏  //
                // 消费；而后提交offset先消费会造成数据的重复消费                                          //
                // 因此，生成环境中会同过事务控制实现自定义的储存offset策略 key:topic+partition+group, offset//
                //*********************************************************************************//

                // 异步提交,多与回调方法同时使用
                consumer.commitAsync((offset, exception) -> {
                    if (exception != null) {
                        System.out.println("offset本次提交失败!");
                    }
                });

                // 同步提交,当前线程会阻塞到提交完成才继续向下执行
                // consumer.commitSync();
            }
        } finally {
            // 关闭资源
            consumer.close();
        }
    }
}
