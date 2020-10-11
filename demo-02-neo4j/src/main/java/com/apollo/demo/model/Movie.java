package com.apollo.demo.model;

import com.apollo.demo.relations.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@NodeEntity
@Data
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private short released;
    private String description;

    @Relationship(type = "ACTED_IN", direction = Relationship.INCOMING)
    private List<Role> actors = new ArrayList<>();

    @Relationship(type = "DIRECTED", direction = Relationship.INCOMING)
    private List<Person> directors = new ArrayList<>();

}
