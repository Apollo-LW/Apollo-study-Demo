package com.apollo.demo.service;

import com.apollo.demo.model.Person;
import com.apollo.demo.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person update(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person getPersonById(String personId) {
        return personRepository.getPersonById(Long.parseLong(personId));
    }

    @Override
    public Person getPersonByName(String personName) {
        return personRepository.getPersonByName(personName);
    }

    @Override
    public Iterable<Person> getPersonByNameLike(String name) {
        return personRepository.findPersonByNameLike(name);
    }

    @Override
    public boolean delete(String personId) {
        Person person = this.getPersonById(personId);
        if (person == null) return false;
        personRepository.delete(person);
        return true;
    }
}
