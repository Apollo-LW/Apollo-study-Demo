package com.apollo.demo.kafkastreamsdemo01.sink;

import com.apollo.demo.kafkastreamsdemo01.binding.AnalyticsBinding;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.kafka.streams.kstream.KTable;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@CommonsLog(topic = "Counts")
public class PageViewCountSink {

    @StreamListener
    public void process(@Input(AnalyticsBinding.PAGE_COUNTS_IN) KTable<String, Long> count) {
        count.toStream().foreach((key , value) -> log.info("key = " + key + ", value = " + value));
    }
}
