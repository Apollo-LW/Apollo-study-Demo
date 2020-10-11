package com.apollo.demo.relations;

import com.apollo.demo.model.Movie;
import com.apollo.demo.model.Person;
import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RelationshipEntity(type = "ACTED_IN")
public class Role {

    @Id
    @GeneratedValue
    private Long id;
    private List<String> roles = new ArrayList<>();

    @StartNode
    private Person person;

    @EndNode
    private Movie movie;

}
