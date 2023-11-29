package com.example.booking.dto;

import java.util.List;

import com.example.booking.entity.Movie;
import com.example.booking.entity.Showing;

import lombok.Data;

@Data
public class MovieShowing {
    private Movie movie;
    private List<Showing> showing;

}
