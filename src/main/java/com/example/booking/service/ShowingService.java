package com.example.booking.service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.booking.dto.ShowingDto;
import com.example.booking.dto.ShowingDtos;
import com.example.booking.entity.Movie;
import com.example.booking.entity.Seat;
import com.example.booking.entity.Showing;
import com.example.booking.entity.Ticket;
import com.example.booking.repository.MovieRepo;
import com.example.booking.repository.ShowingRepo;
import com.example.booking.repository.TicketRepo;

@Service
public class ShowingService {
    @Autowired
    private MovieRepo movieRepo;

    @Autowired
    private ShowingRepo showingRepo;

    @Autowired
    private TicketRepo ticketRepo;

    public List<Showing> getShowing(Movie movie) {
        Timestamp now = new Timestamp(System.currentTimeMillis());

        List<Showing> list = showingRepo.findByMovie(movie);
        List<Showing> result = new ArrayList<>();
        for (Showing i : list) {
            if (i.getShowingTime().compareTo(now) > 0)
                result.add(i);

        }
        return result;
    }

    public void createShowing(List<ShowingDto> showingDtos) {

        LocalDate today = LocalDate.now();

        for (ShowingDto i : showingDtos) {
            Movie movie = movieRepo.findById(i.getId()).orElse(null);
            int showingTime = i.getShowingTime();
            LocalDateTime timeSave = LocalDateTime.of(today, LocalTime.of(showingTime, 0));
            Timestamp timeStapsave = Timestamp.valueOf(timeSave);
            Showing showing = new Showing();
            showing.setMovie(movie);
            showing.setShowingTime(timeStapsave);
            showingRepo.save(showing);
        }
    }

    public List<Seat> getSeatBooked(Showing showing) {
        List<Ticket> tickets = ticketRepo.findByShowing(showing);
        List<Seat> result = new ArrayList<>();
        for (Ticket i : tickets)
            result.add(i.getSeat());
        return result;

    }

    public List<Ticket> gTickets(Showing showing) {
        return ticketRepo.findByShowingId(showing.getId());
    }

    public Showing findById(int id) {
        return showingRepo.findById(id).orElse(null);
    }

    public List<Showing> showingToday() {

        LocalDate today = LocalDate.now();

        LocalDateTime startOfDay = LocalDateTime.of(today, LocalTime.MIN);
        LocalDateTime endOfDay = LocalDateTime.of(today, LocalTime.MAX);

        Timestamp startOfDayTimestamp = Timestamp.valueOf(startOfDay);
        Timestamp endOfDayTimestamp = Timestamp.valueOf(endOfDay);
        return showingRepo.findByShowingTimeBetween(startOfDayTimestamp, endOfDayTimestamp);
    }

    public ShowingDtos getShowingDTOById(int showingId) {

        Showing showing = showingRepo.findById(showingId).orElse(null);
        if (showing != null) {
            ShowingDtos showingDtos = showing.toDTO();
            showingDtos.setMovieName(showing.getMovie().toString());
            return showingDtos;
        }
        return null;
    }

}
