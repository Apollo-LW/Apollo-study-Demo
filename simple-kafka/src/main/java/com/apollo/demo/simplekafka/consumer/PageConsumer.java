package com.apollo.demo.simplekafka.consumer;

import com.apollo.demo.simplekafka.model.Page;
import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.jetbrains.annotations.NotNull;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@CommonsLog(topic = "Page Consumer Logger")
public class PageConsumer {

    @KafkaListener(topics = "page-events", groupId = "page-consumers")
    public void consumePageEvent(@NotNull ConsumerRecord<String, Page> pageConsumerRecord) {
        log.info(String.format("Consumed a Page Event, Key = %s, Value = %s" , pageConsumerRecord.key() , pageConsumerRecord.value()));
    }

}
