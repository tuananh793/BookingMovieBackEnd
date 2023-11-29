package com.example.booking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Seat {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private String id;

}
