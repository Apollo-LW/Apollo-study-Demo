package com.apollo.demo.simplekafka.controller;

import com.apollo.demo.simplekafka.model.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/page")
@RequiredArgsConstructor
public class PageController {

    
    @PostMapping("/")
    public ResponseEntity<String> createPage(@RequestBody Page page) {
        return ResponseEntity.ok(this.pageService.save(page).toString());
    }
}
