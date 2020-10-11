package com.apollo.demo.graph.service;

import com.apollo.demo.graph.model.Person;
import com.apollo.demo.graph.relation.Role;
import com.apollo.demo.graph.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public Optional<Person> getPersonById(Long personId) {
        return this.personRepository.findById(personId);
    }

    @Override
    public Person save(Person person) {
        return this.personRepository.save(person);
    }

    @Override
    public Person update(Person person) {
        return this.personRepository.save(person);
    }

    @Override
    public boolean delete(Long personId) {
        Optional<Person> person = this.getPersonById(personId);
        if(person.isEmpty()) return false;
        this.personRepository.delete(person.get());
        return true;
    }

    @Override
    public List<Role> actRelation(String personName , String movieName) {
        return this.personRepository.createActRelationship(personName , movieName);
    }
}
