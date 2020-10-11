package com.apollo.demo.controller;

import com.apollo.demo.model.Movie;
import com.apollo.demo.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/id/{movieId}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("movieId") String movieId) {
        return ResponseEntity.ok(this.movieService.getMovieById(movieId));
    }

    @GetMapping("/name/{movieName}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("movieName") String movieName) {
        return ResponseEntity.ok(this.movieService.getMovieByName(movieName));
    }

    @GetMapping("/match/{movieName}")
    public ResponseEntity<List<Movie>> getMovieByNameLike(@PathVariable("movieName") String movieName) {
        List<Movie> movies = new ArrayList<>();
        this.movieService.getMovieByNameLike(movieName).forEach(movies::add);
        return ResponseEntity.ok(movies);
    }

    @PostMapping("/")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(this.movieService.save(movie));
    }

    @PutMapping("/")
    public ResponseEntity<Movie> deleteMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(this.movieService.update(movie));
    }

    @DeleteMapping("/{movieId}")
    public ResponseEntity<Boolean> delete(@PathVariable("movieId") String movieId) {
        return ResponseEntity.ok(this.movieService.deleteMovie(movieId));
    }

}
