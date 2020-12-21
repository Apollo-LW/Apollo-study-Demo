package com.apollox.demo.usermock.kafka;

import com.apollox.demo.usermock.model.User;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverOptions;
import reactor.kafka.receiver.internals.ConsumerFactory;
import reactor.kafka.receiver.internals.DefaultKafkaReceiver;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderOptions;
import reactor.kafka.sender.internals.DefaultKafkaSender;
import reactor.kafka.sender.internals.ProducerFactory;

import java.util.Collections;
import java.util.Properties;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic newTopic() {
        return TopicBuilder.name("user").partitions(3).replicas(1).build();
    }


    @Bean
    KafkaSender<String , User> userKafkaSender() {
        final Properties properties = new Properties();
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG , StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG , JsonSerializer.class);
        properties.put(ProducerConfig.ACKS_CONFIG , "all");

        return new DefaultKafkaSender<String , User>(ProducerFactory.INSTANCE , SenderOptions.create(properties));
    }

    @Bean
    KafkaReceiver<String , User> userKafkaReceiver() {
        final Properties properties = new Properties();
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG , StringSerializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG , JsonDeserializer.class);

        ReceiverOptions<String , User> userReceiverOptions = ReceiverOptions.create(properties);
        return new DefaultKafkaReceiver<String , User>(ConsumerFactory.INSTANCE
                , userReceiverOptions.subscription(Collections.singleton("user")));
    }

}
