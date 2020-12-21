package com.apollol.demo.laithapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Random;

@SpringBootApplication
public class LaithappApplication {

    public static void main(String[] args) {
        SpringApplication.run(LaithappApplication.class , args);
    }


}
