import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;

import java.util.Properties;

public class FunProgram {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG , "localhost:9092");
        properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG , Serdes.String().getClass().getName());
        properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG , Serdes.String().getClass().getName());
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG , "apolloX-stream");
        final StreamsBuilder streamsBuilder = new StreamsBuilder();
        final KStream<String , String> source = streamsBuilder.stream("numbers");
        source.map((key , value) -> new KeyValue<>(key , Integer.valueOf(value)))
                .filter((key , value) -> ( value & 1 ) == 0)
                .map((key , value) -> new KeyValue<>(key , Integer.toString(value * value)))
                .to("squares" , Produced.with(Serdes.String() , Serdes.String()));
        KafkaStreams kafkaStreams = new KafkaStreams(streamsBuilder.build() , properties);

        try {
            kafkaStreams.start();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

}
