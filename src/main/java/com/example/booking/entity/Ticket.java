package com.example.booking.entity;

import com.example.booking.dto.TicketDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long price;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;

    @ManyToOne()
    @JoinColumn(name = "showing_id")
    private Showing showing;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;

    public TicketDTO toDTO() {
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setId(this.id);
        ticketDTO.setPrice(this.price);
        ticketDTO.setSeat(this.seat.toString().substring(8, 10));
        // Add other fields if needed

        return ticketDTO;
    }
}
