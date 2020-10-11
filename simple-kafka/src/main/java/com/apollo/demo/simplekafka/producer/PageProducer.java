package com.apollo.demo.simplekafka.producer;

import com.apollo.demo.simplekafka.model.Page;
import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@CommonsLog(topic = "Page Producer Logger")
public class PageProducer {

    @Value("${topic.name}")
    private String topicName;

    private final KafkaTemplate<String, Page> pageProducer;

    public void publishPageEvent(String key , Page value) {
        this.pageProducer.send(this.topicName , key , value);
        log.info(String.format("Produced Page Event -> %s" , value));
    }
}
