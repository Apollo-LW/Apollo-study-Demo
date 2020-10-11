package com.apollo.demo.kafkastreamsdemo01.binding;

import com.apollo.demo.kafkastreamsdemo01.model.PageViewEvent;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface AnalyticsBinding {

    String PAGE_VIEW_OUT = "pveo";
    String PAGE_VIEW_IN = "pvei";

    String PAGE_COUNTS_OUT = "pco";
    String PAGE_COUNTS_IN = "pci";
    String PAGE_COUNTS_MV = "pcmview";

    @Input(PAGE_COUNTS_IN)
    KTable<String, Long> pageCountsIn();

    @Output(PAGE_COUNTS_OUT)
    KStream<String, Long> pageCountOut();

    @Output(PAGE_VIEW_OUT)
    MessageChannel pageViewEventsOut();

    @Input(PAGE_VIEW_IN)
    KStream<String, PageViewEvent> pageViewEventsIn();

}
