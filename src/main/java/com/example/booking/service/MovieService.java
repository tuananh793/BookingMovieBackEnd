package com.example.booking.service;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.booking.entity.Movie;
import com.example.booking.repository.MovieRepo;

@Service
public class MovieService {
    @Autowired
    private MovieRepo movieRepo;
    @Autowired
    private EntityManager entityManager;

    public List<Movie> getAllMovie() {
        return movieRepo.findAllNotDeleted();
    }

    public Movie getMovie(int id) {
        return movieRepo.findById(id).orElse(null);
    }

    @Transactional
    public void saveMovie(Movie movie) {
        if (movie.getId() != null) {
            Movie movie1 = movieRepo.findById(movie.getId()).orElse(null);
            movie1.setActors(movie.getActors());
            movie1.setName(movie.getName());
            movie1.setCategory(movie.getCategory());
            movie1.setImg(movie.getImg());
            movie1.setTrailer(movie.getTrailer());
            movie1.setLongTime(movie.getLongTime());

        } else
            movieRepo.save(movie);
        entityManager.flush();
    }

    public void deleteMovie(Movie movie) {
        movie.setDelete(true);
        movieRepo.save(movie);
    }

}
