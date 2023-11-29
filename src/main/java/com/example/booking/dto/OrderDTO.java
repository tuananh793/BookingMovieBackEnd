package com.example.booking.dto;

import com.example.booking.entity.Ticket;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class OrderDTO {
    private Timestamp orderTime;
    private String movieName;
    private Timestamp showingTime;
    private List<Ticket> tickets;
    private List<FoodDTO> food;
    private long totalPrice;
}
