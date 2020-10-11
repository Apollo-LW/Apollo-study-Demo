package com.apollo.demo.kafkastreamsdemo01.source;

import com.apollo.demo.kafkastreamsdemo01.binding.AnalyticsBinding;
import com.apollo.demo.kafkastreamsdemo01.model.PageViewEvent;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.kafka.common.serialization.Serdes;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
@CommonsLog(topic = "Page View Event Source")
@EnableBinding(AnalyticsBinding.class)
public class PageViewEventSource implements ApplicationRunner {

    private final List<String> pages = Arrays.asList("Google" , "Youtube" , "LinkedIn" , "Facebook" , "Twitter");
    private final List<String> names = Arrays.asList("Mohammad9" , "Hend" , "Maen" , "Laith" , "Mohammad11");
    private final MessageChannel out;

    public PageViewEventSource(@NotNull AnalyticsBinding analyticsBinding) {
        this.out = analyticsBinding.pageViewEventsOut();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Runnable runnable = () -> {
            PageViewEvent pageViewEvent = new PageViewEvent(random(names) , random(pages) , Math.random() > 0.5 ? 10 : 100);
            Message<PageViewEvent> message = MessageBuilder
                    .withPayload(pageViewEvent)
                    .setHeader(KafkaHeaders.MESSAGE_KEY , pageViewEvent.getUserName().getBytes())
                    .build();
            try {
                this.out.send(message);
                log.info("Sent " + pageViewEvent.toString());
            } catch (Exception e) {
                log.error(e);
            }
        };
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(runnable , 1 , 1 , TimeUnit.SECONDS);
    }

    private static <T> T random(List<T> list) {
        return list.get(new Random().nextInt(list.size()));
    }
}
