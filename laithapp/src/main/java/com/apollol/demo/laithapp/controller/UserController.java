package com.apollol.demo.laithapp.controller;

import com.apollol.demo.laithapp.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{name}")
    public User hello(@PathVariable("name") String name) {
        User user = new User();
        user.setName(name);
        user.setX(66);
        return user;
    }

}
