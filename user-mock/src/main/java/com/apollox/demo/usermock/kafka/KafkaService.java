package com.apollox.demo.usermock.kafka;

import com.apollox.demo.usermock.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderRecord;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@CommonsLog
public class KafkaService {

    private final KafkaSender<String , User> userKafkaSender;
    private final KafkaReceiver<String , User> userKafkaReceiver;

    public Mono<Optional<User>> sendUserEvent(User user) {
        return this
                .userKafkaSender
                .send(Mono.just(SenderRecord.create(new ProducerRecord<>("user" , user.getId() , user) , 1)))
                .next()
                .doOnNext(log::info)
                .map(tSenderResult -> tSenderResult.exception() == null ? Optional.of(user) : Optional.empty());
    }
}
