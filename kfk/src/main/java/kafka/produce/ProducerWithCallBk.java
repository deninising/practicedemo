package kafka.produce;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * 描述：带回调方法的生产者
 *
 * @author Dennis
 * @version 1.0
 * @date 2020/2/1 12:00
 */
public class ProducerWithCallBk {
    public static void main(String[] args) {
        Properties props = new Properties();
        // kafka服务端的主机名与端口号
        props.put("bootstrap.servers", "master:9092");
        // 确认策略:等待左右的副本节点答应
        props.put("acks", "all");
        // 消息发送失败时最大尝试次数
        props.put("retries", 0);
        // 一批消息处理的大小(当消息达到该大小时则进行发送,发送到统一分区)
        props.put("batch.size", 16384);
        // 增加服务端请求延迟
        props.put("linger.ms", 1);
        // 发送缓存区内存大小
        props.put("buffer.memory", 33554432);
        // key序列化
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        // value序列化
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        // 创建生产者对象
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        // 消息发送 v
        for (int i = 0; i < 50; i++) {
            ProducerRecord<String, String> record = new ProducerRecord<>("second", "message:" + "hi" + i);
            int finalI = i;
            producer.send(record, (m, v) -> {
                System.out.println(m.partition() + "+++" + finalI + "+++" + m.offset());
            });
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        producer.close();
    }
}
