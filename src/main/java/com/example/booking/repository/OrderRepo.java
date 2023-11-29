package com.example.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.booking.entity.Orders;
import com.example.booking.entity.User;

import java.util.List;

@Repository

public interface OrderRepo extends JpaRepository<Orders, Integer> {
    @Query(value = "SELECT * FROM orders o WHERE o.user_id=?1", nativeQuery = true)
    List<Orders> findByUserId(int userId);
}
