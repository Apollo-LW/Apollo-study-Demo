package com.apollo.model;

public class Student implements Talk {

    public String name;

    @Override
    public String talk() {
        return name + "Student";
    }



}
