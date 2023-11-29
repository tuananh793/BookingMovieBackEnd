package com.example.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.booking.dto.MovieShowing;
import com.example.booking.dto.ShowingDto;
import com.example.booking.dto.ShowingDtos;
import com.example.booking.dto.ShowingSeat;
import com.example.booking.entity.Movie;
import com.example.booking.entity.Showing;
import com.example.booking.service.MovieService;
import com.example.booking.service.ShowingService;

@CrossOrigin
@RestController
public class ShowingController {
    @Autowired
    private ShowingService showingService;

    @Autowired
    private MovieService movieService;
// lấy tất cả suất chiếu của ngày hnay
    @GetMapping("/create-showing")
    public List<Showing> getAllShowing() {
        return showingService.showingToday();
    }

    @PostMapping("/create-showing")
    public void createShowing(@RequestBody List<ShowingDto> showingDtos) {
        showingService.createShowing(showingDtos);

    }

    // Lấy tất cả suất chiếu của bộ phim
    @GetMapping("/showing/{id}")
    public MovieShowing getShowing(@PathVariable int id) {
        Movie movie = movieService.getMovie(id);
        MovieShowing movieShowing = new MovieShowing();
        movieShowing.setMovie(movie);
        movieShowing.setShowing(showingService.getShowing(movie));
        return movieShowing;
    }

    // lấy ra ds vé đã bị đặt của suất chiếu đó
    @GetMapping("/showing-movie/{id}")
    public ShowingSeat getShowingMovie(@PathVariable int id) {
        ShowingSeat showingSeat = new ShowingSeat();
        Showing showing = showingService.findById(id);
        showingSeat.setShowing(showing);

        return showingSeat;
    }

    @GetMapping("/ticket/{id}")
    public ShowingDtos getShowingDTOById(@PathVariable int id) {
        return showingService.getShowingDTOById(id);
    }

}
