package com.example.booking.dto;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class ShowingDtos {
    private int id;
    private String movieName;
    private Timestamp showingTime;
    private List<TicketDTO> tickets;

}
