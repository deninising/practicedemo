package kafka.produce;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * 描述：
 *
 * @author Dennis
 * @version 1.0
 * @date 2020/1/30 21:07
 */
public class Producer {
    public static void main(String[] args) {
        Properties props = new Properties();
        // kafka服务端的主机名与端口号
        props.put("bootstrap.servers", "master:9092");
        // 确认策略:等待左右的副本节点答应
        props.put("acks", "all");
        // 消息发送失败时最大尝试次数
        props.put("retries", 0);
        // 一批消息处理的大小(当消息达到该大小时者进行发送)
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
            ProducerRecord<String, String> record = new ProducerRecord<>("second", "msg:" + "hi" + i);
            producer.send(record);
        }
        producer.close();
    }
}
