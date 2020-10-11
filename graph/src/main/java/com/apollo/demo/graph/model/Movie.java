package com.apollo.demo.graph.model;

import com.apollo.demo.graph.relation.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@NodeEntity
@Data
public class Movie {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private short releasedYear;

    @JsonIgnoreProperties("movie")
    @Relationship(type = "ACTED_IN" , direction = Relationship.INCOMING)
    private List<Role> actor = new ArrayList<>();

    @Relationship(type = "DIRECTED" , direction = Relationship.INCOMING)
    private List<Person> people = new ArrayList<>();
}
