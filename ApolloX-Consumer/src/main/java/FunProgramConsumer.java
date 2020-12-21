import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;

public class FunProgramConsumer {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.CLIENT_ID_CONFIG , "apollox-number");
        properties.put(ConsumerConfig.GROUP_ID_CONFIG , "apolloX");
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG , "localhost:9092");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG , StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG , StringDeserializer.class);
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG , "latest");
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG , false);

        Consumer<String , String> consumer = new KafkaConsumer<String, String>(properties);
        ArrayList<String> topicNames = new ArrayList<>();
        topicNames.add("numbers");
        topicNames.add("squares");
        consumer.subscribe(topicNames);

        while(true) {
            ConsumerRecords<String , String> records = consumer.poll(Duration.ofMillis(10));
            records.forEach(record -> {
                System.out.println("========================================");
                System.out.println(record.key());
                System.out.println(record.value());
                System.out.println("========================================");
            });
            consumer.commitAsync();
        }
    }

}
