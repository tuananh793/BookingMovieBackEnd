package com.example.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.booking.entity.Movie;
import com.example.booking.service.MovieService;

@CrossOrigin
@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/movie")
    public List<Movie> getAllMovie() {
        return movieService.getAllMovie();
    }

    @GetMapping("/movie/{id}")
    public Movie getMovie(@PathVariable int id) {
        return movieService.getMovie(id);
    }

    @PostMapping("/movie")
    public void saveMovie(@RequestBody Movie movie) {
        movieService.saveMovie(movie);
    }

    @DeleteMapping("/movie/{id}")
    public void deleteMovie(@PathVariable int id) {
        Movie movie = movieService.getMovie(id);
        movieService.deleteMovie(movie);
    }
}
