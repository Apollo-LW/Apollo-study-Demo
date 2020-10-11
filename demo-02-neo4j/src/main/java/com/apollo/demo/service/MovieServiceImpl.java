package com.apollo.demo.service;

import com.apollo.demo.model.Movie;
import com.apollo.demo.repository.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie getMovieById(String movieId) {
        return movieRepository.getMovieById(Long.parseLong(movieId));
    }

    @Override
    public Movie getMovieByName(String movieName) {
        return movieRepository.getMovieByTitle(movieName);
    }

    @Override
    public Iterable<Movie> getMovieByNameLike(String movieName) {
        return movieRepository.findMovieByTitleLike(movieName);
    }

    @Override
    public Movie update(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public boolean deleteMovie(String movieId) {
        Movie movie = this.getMovieById(movieId);
        if (movie == null) return false;
        movieRepository.delete(movie);
        return true;
    }
}
