package com.apollo.demo.graph.model;

import com.apollo.demo.graph.relation.Edges;
import com.apollo.demo.graph.relation.Role;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

@NodeEntity
@Data
public class Person {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private short birthYear;

    @Relationship(type = Edges.ACTED_IN)
    private List<Role> atcedIn = new ArrayList<>();

    @Relationship(type = Edges.DIRECTED)
    private List<Movie> directed = new ArrayList<>();

}
