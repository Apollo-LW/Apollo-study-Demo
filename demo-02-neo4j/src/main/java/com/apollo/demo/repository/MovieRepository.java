package com.apollo.demo.repository;

import com.apollo.demo.model.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "movies", path = "movies")
public interface MovieRepository extends Neo4jRepository<Movie, Long> {

    Movie getMovieById(Long id);

    Movie getMovieByTitle(String title);

    Iterable<Movie> findMovieByTitleLike(String title);
}
