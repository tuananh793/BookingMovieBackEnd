package com.example.booking.dto;

import java.util.List;

import com.example.booking.entity.Seat;
import com.example.booking.entity.Showing;
import lombok.Data;

@Data
public class ShowingSeat {
    private Showing showing;
    private List<Seat> seats;

}
