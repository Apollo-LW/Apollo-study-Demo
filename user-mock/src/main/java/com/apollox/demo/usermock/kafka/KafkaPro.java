package com.apollox.demo.usermock.kafka;

import com.apollox.demo.usermock.model.User;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class KafkaPro {

    @Bean
    public Function<KStream<String , User> , KTable<String , User>> userPro() {
        return userRecords -> userRecords.groupByKey().reduce((user , updatedUser) -> updatedUser
                , Materialized.as("user-store"));
    }

}
