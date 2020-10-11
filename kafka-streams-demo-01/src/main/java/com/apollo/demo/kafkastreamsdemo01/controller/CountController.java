package com.apollo.demo.kafkastreamsdemo01.controller;

import com.apollo.demo.kafkastreamsdemo01.binding.AnalyticsBinding;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.cloud.stream.binder.kafka.streams.InteractiveQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CountController {

    private final InteractiveQueryService interactiveQueryService;

    @GetMapping("/count")
    Map<String, Long> counts() {
        ReadOnlyKeyValueStore<String, Long> store = interactiveQueryService.getQueryableStore(AnalyticsBinding.PAGE_COUNTS_MV , QueryableStoreTypes.keyValueStore());
        KeyValueIterator<String, Long> iterator = store.all();
        Map<String, Long> counts = new HashMap<>();
        while (iterator.hasNext()) {
            KeyValue<String, Long> event = iterator.next();
            counts.put(event.key , event.value);
        }
        return counts;
    }

}
