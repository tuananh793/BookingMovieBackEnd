package com.example.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.booking.entity.Movie;
import com.example.booking.entity.Showing;
import java.sql.Timestamp;

@Repository

public interface ShowingRepo extends JpaRepository<Showing, Integer> {
    List<Showing> findByMovie(Movie movie);

    List<Showing> findByShowingTimeBetween(Timestamp startOfDay, Timestamp endOfDay);
}
