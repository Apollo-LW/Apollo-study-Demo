package com.apollo.demo.spring.controller;

import com.apollo.demo.spring.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/info/{name}/{username}")
    public User getUser(@PathVariable("name") String name ,@PathVariable("username") String username) {
        User user = new User();
        user.setUsername(username);
        user.setName(name);
        user.setAge(20);
        return user;
    }

}
