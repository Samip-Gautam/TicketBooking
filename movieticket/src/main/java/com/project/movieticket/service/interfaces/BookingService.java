package com.project.movieticket.service.interfaces;

public interface BookingService {
    double calculatePrice(Long theaterId, int seatCount);
}
