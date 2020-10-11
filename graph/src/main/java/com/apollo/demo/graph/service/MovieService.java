package com.apollo.demo.graph.service;

import com.apollo.demo.graph.model.Movie;

import java.util.Optional;

public interface MovieService {

    Optional<Movie> getMovieById(Long MovieId);
    Movie save(Movie Movie);
    Movie update(Movie Movie);
    boolean delete(Long MovieId);


}
