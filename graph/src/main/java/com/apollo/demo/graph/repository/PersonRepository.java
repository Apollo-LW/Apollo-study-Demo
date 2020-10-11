package com.apollo.demo.graph.repository;

import com.apollo.demo.graph.model.Person;
import com.apollo.demo.graph.relation.Role;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PersonRepository extends Neo4jRepository<Person , Long> {

    @Query(value = "MATCH (p:Person),(m:Movie) " +
            "WHERE p.name = $personName AND m.title = $movieTitle " +
            "CREATE (p)-[r:ACTED_IN]->(m)")
    @Transactional
    List<Role> createActRelationship(@Param("personName") String personName, @Param("movieTitle") String movieTitle);
}
