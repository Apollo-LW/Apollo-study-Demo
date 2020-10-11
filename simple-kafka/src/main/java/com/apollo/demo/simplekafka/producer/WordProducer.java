package com.apollo.demo.simplekafka.producer;

import com.apollo.demo.simplekafka.model.Word;
import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@CommonsLog(topic = "Word Producer Logger")
public class WordProducer {

    private final KafkaTemplate<String, Word> wordProducer;

    public void publishWord(String key , Word word) {
        this.wordProducer.send("word-in" , key , word);
        log.info(String.format("Produced Word -> %s" , word));
    }


}
