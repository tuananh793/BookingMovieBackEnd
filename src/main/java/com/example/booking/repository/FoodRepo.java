package com.example.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.booking.entity.Food;

@Repository
public interface FoodRepo extends JpaRepository<Food, Integer> {

}
