package com.project.movieticket.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@Table(name = "bookings")
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;

    private int seatsBooked;
    private String customerName;
}
