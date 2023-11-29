package com.example.booking.dto;

import java.util.List;

import com.example.booking.entity.Food;
import com.example.booking.entity.Ticket;
import com.example.booking.entity.User;

import lombok.Data;

@Data
public class CreateOrderRequest {
    private User user;
    private List<Ticket> tickets;
    private List<Food> foods;

}