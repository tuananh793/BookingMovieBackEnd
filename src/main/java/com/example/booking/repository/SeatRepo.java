package com.example.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.booking.entity.Seat;

@Repository

public interface SeatRepo extends JpaRepository<Seat, String> {

}
