package com.apollox.demo.usermock.model;

import lombok.Data;

import java.util.UUID;

@Data
public class User {

    private String id = UUID.randomUUID().toString();
    private String name , username , email;
    private Integer age;

}
