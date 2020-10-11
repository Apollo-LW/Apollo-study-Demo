package com.apollo.demo.graph.service;

import com.apollo.demo.graph.model.Person;
import com.apollo.demo.graph.relation.Role;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    Optional<Person> getPersonById(Long personId);
    Person save(Person person);
    Person update(Person person);
    boolean delete(Long personId);
    List<Role> actRelation(String personName , String movieName);

}
