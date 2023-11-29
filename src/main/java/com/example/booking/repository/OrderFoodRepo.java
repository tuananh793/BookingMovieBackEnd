package com.example.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.booking.entity.OrderFood;
import com.example.booking.entity.Orders;

import java.util.List;

@Repository

public interface OrderFoodRepo extends JpaRepository<OrderFood, Integer> {
    @Query(value = "SELECT * FROM order_food t WHERE t.order_id=?1", nativeQuery = true)
    List<OrderFood> findByOrder(int orderId);
}
