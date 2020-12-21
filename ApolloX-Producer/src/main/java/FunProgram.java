import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class FunProgram {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG , "localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG , StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG , StringSerializer.class);

        Producer<String , String> producer = new KafkaProducer<String , String>(properties);
        for(int i = 0 ; i < 100 ; ++i) {
            ProducerRecord<String , String> record = new ProducerRecord<>("numbers" , Integer.toString(i) , Integer.toString(i) );
            int finalI = i;
            producer.send(record , (metadata , exception) -> {
                if(exception == null) {
                    System.out.println("=============================" + finalI + "=============================");
                    System.out.println(metadata.partition());
                    System.out.println(metadata.offset());
                    System.out.println("===========================================================");
                }
            });
            producer.flush();
        }
        producer.close();
    }

}
