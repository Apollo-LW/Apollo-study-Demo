package com.apollo.demo.graph.controller;

import com.apollo.demo.graph.model.Person;
import com.apollo.demo.graph.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping("")
    public ResponseEntity<? extends Person> createPerson(@RequestBody Person person) {
        return ResponseEntity.ok(this.personService.save(person));
    }

    @PutMapping("/connect/{personName}/{movieName}")
    public ResponseEntity<? extends List<?>> createRelation(@PathVariable("personName") String personName , @PathVariable("movieName") String movieName) {
        return ResponseEntity.ok(this.personService.actRelation(personName , movieName));
    }

}
