package com.apollo.demo.graph.repository;

import com.apollo.demo.graph.model.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface MovieRepository extends Neo4jRepository<Movie , Long> {

}
