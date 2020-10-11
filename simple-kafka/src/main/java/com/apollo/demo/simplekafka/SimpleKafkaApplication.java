package com.apollo.demo.simplekafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SimpleKafkaApplication {

    @Value("${topic.name}")
    private String topicName;

    @Value("${topic.partition-num}")
    private Integer partitionNumber;

    @Value("${topic.replication-factor}")
    private short replicationFactor;

    public static void main(String[] args) {
        SpringApplication.run(SimpleKafkaApplication.class , args);
    }

    @Bean
    NewTopic pageEventTopic() {
        return new NewTopic(this.topicName , this.partitionNumber , this.replicationFactor);
    }
}
