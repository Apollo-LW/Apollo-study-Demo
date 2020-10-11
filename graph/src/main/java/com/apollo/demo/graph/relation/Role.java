package com.apollo.demo.graph.relation;

import com.apollo.demo.graph.model.Movie;
import com.apollo.demo.graph.model.Person;
import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RelationshipEntity
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
