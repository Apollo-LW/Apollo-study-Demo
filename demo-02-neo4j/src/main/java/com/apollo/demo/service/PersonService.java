package com.apollo.demo.service;

import com.apollo.demo.model.Person;

public interface PersonService {

    Person save(Person person);

    Person update(Person person);

    Person getPersonById(String personId);

    Person getPersonByName(String personName);

    Iterable<Person> getPersonByNameLike(String name);

    boolean delete(String personId);

}
