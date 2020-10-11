package com.apollo.demo.model;

import com.apollo.demo.relations.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@NodeEntity
@Data
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private short birthYear;

    @Relationship(type = "ACTED_IN")
    private List<Role> actedIn = new ArrayList<>();

    @Relationship(type = "DIRECTED")
    private List<Movie> directed = new ArrayList<>();

}
