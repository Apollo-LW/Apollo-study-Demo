package com.apollo.demo.controller;

import com.apollo.demo.model.Person;
import com.apollo.demo.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/id/{personId}")
    public ResponseEntity<Person> getPersonById(@PathVariable("personId") String personId) {
        return ResponseEntity.ok(this.personService.getPersonById(personId));
    }

    @GetMapping("/name/{personName}")
    public ResponseEntity<Person> getPersonByName(@PathVariable("personName") String personName) {
        return ResponseEntity.ok(this.personService.getPersonByName(personName));
    }

    @GetMapping("/match/{personName}")
    public ResponseEntity<List<Person>> getPersonByNameLike(@PathVariable("personName") String personName) {
        List<Person> people = new ArrayList<>();
        this.personService.getPersonByNameLike(personName).forEach(people::add);
        return ResponseEntity.ok(people);
    }

    @PostMapping("/")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        return ResponseEntity.ok(this.personService.save(person));
    }

    @PutMapping("/")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person) {
        return ResponseEntity.ok(this.personService.update(person));
    }

    @DeleteMapping("/{personId}")
    public ResponseEntity<Boolean> deletePerson(@PathVariable("personId") String peronId) {
        return ResponseEntity.ok(this.personService.delete(peronId));
    }
}
