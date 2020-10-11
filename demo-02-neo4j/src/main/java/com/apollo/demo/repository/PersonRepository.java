package com.apollo.demo.repository;

import com.apollo.demo.model.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface PersonRepository extends Neo4jRepository<Person, Long> {

    Person getPersonByName(String name);

    Person getPersonById(Long id);

    Iterable<Person> findPersonByNameLike(String name);

    @Query("MATCH (am:Movie)<-[ai:ACTED_IN]-(p:Person)-[d:DIRECTED]->(dm:Movie) return p , collect(ai) , collect(d) , collect(am) , collect(dm)")
    List<Person> getPersonWhoActAndDirect();
}
