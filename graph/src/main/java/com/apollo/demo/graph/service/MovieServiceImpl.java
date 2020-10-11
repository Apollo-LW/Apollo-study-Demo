package com.apollo.demo.graph.service;

import com.apollo.demo.graph.model.Movie;
import com.apollo.demo.graph.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public Optional<Movie> getMovieById(Long movieId) {
        return this.movieRepository.findById(movieId);
    }

    @Override
    public Movie save(Movie movie) {
        return this.movieRepository.save(movie);
    }

    @Override
    public Movie update(Movie movie) {
        return this.movieRepository.save(movie);
    }

    @Override
    public boolean delete(Long movieId) {
        Optional<Movie> movie = this.getMovieById(movieId);
        if(movie.isEmpty()) return false;
        this.movieRepository.delete(movie.get());
        return true;
    }
}
