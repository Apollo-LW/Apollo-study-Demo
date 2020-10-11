package com.apollo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class User {

    private int age;
    private String name;
    private String school;

    public abstract void go();

}
