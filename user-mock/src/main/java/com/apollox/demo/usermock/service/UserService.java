package com.apollox.demo.usermock.service;

import com.apollox.demo.usermock.model.User;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<User> getById(String id);
    Mono<User> createUser(User user);

}
