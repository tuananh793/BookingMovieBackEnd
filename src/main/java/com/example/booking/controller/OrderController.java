package com.example.booking.controller;

import java.util.List;

import com.example.booking.dto.MyOrders;
import com.example.booking.entity.Food;
import com.example.booking.entity.Orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.booking.dto.CreateOrderRequest;
import com.example.booking.dto.FoodDTO;
import com.example.booking.service.FoodService;
import com.example.booking.service.OrderService;
import com.example.booking.service.UserService;

@CrossOrigin
@RestController
public class OrderController {
    @Autowired
    private FoodService foodService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @GetMapping("/food")
    public List<FoodDTO> getFoods() {
        return foodService.getFoods();
    }

    @PostMapping("/create-order")
    public ResponseEntity<String> createOrder(
            @RequestBody CreateOrderRequest createOrderRequest) {
        orderService.createOrder(createOrderRequest.getUser(), createOrderRequest.getTickets(),
                createOrderRequest.getFoods());

        return ResponseEntity.ok("Order created successfully");
    }

    @GetMapping("order/{id}")
    public MyOrders getOrders(@PathVariable int id) {
        MyOrders myOrders = orderService.getMyOrder(id);
        return myOrders;
    }

    @GetMapping("order1/{id}")
    public List<FoodDTO> getOrders1(@PathVariable int id) {
        return foodService.getByOrders(id);
    }
}
