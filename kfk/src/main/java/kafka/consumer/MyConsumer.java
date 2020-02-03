package kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * 描述：自动提交offset
 *
 * @author Dennis
 * @version 1.0
 * @date 2020/2/3 12:59
 */
public class MyConsumer {
    public static void main(String[] args) {
        Properties props = new Properties();
        // 定义 kakfa 服务的地址，不需要将所有 broker 指定上
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "master:9092");
        // 是否自动确认 offset
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        // 自动确认 offset 的时间间隔
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
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
            }
        } finally {
            // 关闭资源
            consumer.close();
        }
    }
}
