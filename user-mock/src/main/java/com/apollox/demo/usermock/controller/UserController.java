package com.apollox.demo.usermock.controller;

import com.apollox.demo.usermock.model.User;
import com.apollox.demo.usermock.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public Mono<User> getUser(@PathVariable("userId") String userId) {
        return this.userService.getById(userId);
    }

    @GetMapping("/")
    public Mono<User> createRandomUser() {
        User user = new User();
        user.setName("Mohammad");
        user.setEmail("abua@gmail.com");
        user.setAge(10);
        return this.userService.createUser(user);
    }

}
