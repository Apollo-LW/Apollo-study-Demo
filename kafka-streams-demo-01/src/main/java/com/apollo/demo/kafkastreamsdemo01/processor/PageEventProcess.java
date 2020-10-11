package com.apollo.demo.kafkastreamsdemo01.processor;

import com.apollo.demo.kafkastreamsdemo01.binding.AnalyticsBinding;
import com.apollo.demo.kafkastreamsdemo01.model.PageViewEvent;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class PageEventProcess {

    @StreamListener
    @SendTo(AnalyticsBinding.PAGE_COUNTS_OUT)
    public KStream<String, Long> process(@Input(AnalyticsBinding.PAGE_VIEW_IN) KStream<String, PageViewEvent> events) {
        return events
                .filter((key , value) -> value.getDuration() > 10)
                .map((key , value) -> new KeyValue<>(value.getPageName() , "0"))
                .groupByKey()
                .count(Materialized.as(AnalyticsBinding.PAGE_COUNTS_MV))
                .toStream();
    }
}
