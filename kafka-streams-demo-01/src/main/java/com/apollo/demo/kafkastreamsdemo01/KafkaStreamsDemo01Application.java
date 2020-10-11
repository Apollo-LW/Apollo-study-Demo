package com.apollo.demo.kafkastreamsdemo01;

import com.apollo.demo.kafkastreamsdemo01.binding.AnalyticsBinding;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
@EnableBinding(AnalyticsBinding.class)
public class KafkaStreamsDemo01Application {

    public static void main(String[] args) {
        SpringApplication.run(KafkaStreamsDemo01Application.class , args);
    }
}
