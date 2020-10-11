package com.apollo.demo.service;

import com.apollo.demo.model.Movie;

public interface MovieService {

    Movie save(Movie movie);

    Movie getMovieById(String movieId);

    Movie getMovieByName(String movieName);

    Iterable<Movie> getMovieByNameLike(String movieName);

    Movie update(Movie movie);

    boolean deleteMovie(String movieId);

}
