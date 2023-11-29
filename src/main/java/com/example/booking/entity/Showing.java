package com.example.booking.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.example.booking.dto.ShowingDtos;
import com.example.booking.dto.TicketDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
public class Showing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @JsonIgnore
    @OneToMany(mappedBy = "showing", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Ticket> tickets;

    private Timestamp showingTime;

    @Override
    public String toString() {
        return "Showing{id=" + id + ", showingTime=" + showingTime + "}";
    }

    public ShowingDtos toDTO() {
        ShowingDtos showingDTO = new ShowingDtos();
        showingDTO.setId(this.id);
        showingDTO.setShowingTime(this.showingTime);

        if (this.tickets != null) {
            List<TicketDTO> ticketDTOList = new ArrayList<>();
            for (Ticket ticket : this.tickets) {
                ticketDTOList.add(ticket.toDTO());
            }
            showingDTO.setTickets(ticketDTOList);
        }

        return showingDTO;
    }
}
