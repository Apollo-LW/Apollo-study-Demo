package com.apollox.demo.usermock.service;

import com.apollox.demo.usermock.kafka.KafkaService;
import com.apollox.demo.usermock.model.User;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.cloud.stream.binder.kafka.streams.InteractiveQueryService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final KafkaService kafkaService;
    private InteractiveQueryService userQuery;
    private ReadOnlyKeyValueStore<String , User> userStore;

    private ReadOnlyKeyValueStore<String , User> getUserStore() {
        if(userStore == null)
            this.userStore = this.userQuery.getQueryableStore("user-store" , QueryableStoreTypes.keyValueStore());
        return userStore;
    }

    @Override
    public Mono<User> getById(String id) {
        return Mono.just(this.userStore.get(id));
    }

    @Override
    public Mono<User> createUser(User user) {
        return this.kafkaService.sendUserEvent(user).map(Optional::get);
    }
}
