package com.example.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.booking.entity.Movie;
import java.util.List;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer> {
    @Query(value = "SELECT * FROM Movie m WHERE m.is_delete = false", nativeQuery = true)
    List<Movie> findAllNotDeleted();

}
