package com.example.demo.source;

import com.example.demo.model.PageViewEvent;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

@Service
@CommonsLog(topic = "Page View Event Store")
public class PageViewEventSource {

    private final static Random RANDOM = new Random();
    private final static List<String> names = Arrays.asList("Mohammad","Ahmad","Ali","Laith","Hend","Hind");
    private final static List<String> pages = Arrays.asList("Google","Facebook","Youtube","Github","LinkedIn","Instagram","Twitter");

    private static int getRandomIndex(int bound) {
        return RANDOM.nextInt(bound);
    }

    private static PageViewEvent getRandomPageViewEvent() {
        PageViewEvent pageViewEvent = new PageViewEvent();
        pageViewEvent.setPageName(pages.get(getRandomIndex(pages.size())));
        pageViewEvent.setPersonName(names.get(getRandomIndex(names.size())));
        pageViewEvent.setDuration(Math.random() > .5 ? 10 : 1000);
        return pageViewEvent;
    }

    private static Message<PageViewEvent> get() {
        PageViewEvent pageViewEvent = getRandomPageViewEvent();
        log.info(pageViewEvent);
        return MessageBuilder
                .withPayload(pageViewEvent)
                .setHeader(KafkaHeaders.MESSAGE_KEY , pageViewEvent.getPersonName().toString().getBytes())
                .build();
    }

    @Bean
    Supplier<Message<PageViewEvent>> pageViewEventSupplier() {
        return PageViewEventSource::get;
    }

}
