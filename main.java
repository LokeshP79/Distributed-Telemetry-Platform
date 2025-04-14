import org.apache.kafka.clients.producer.*;
import java.util.Properties;

public class TelemetryProducer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 10; i++) {
            ProducerRecord<String, String> record = new ProducerRecord<>("telemetry", "vehicle-" + i, "speed=60,temp=75");
            producer.send(record);
        }
        producer.close();
    }
}
