package com.project.movieticket.service.interfaces;

import com.project.movieticket.entity.Theater;

import java.util.List;

public interface TheaterService {
    List<Theater> getAllTheaters();
    Theater getTheaterById(Long id);
    List<Theater> getTheatersByCity(String city);
    List<Theater> getTheatersByType(int type);
    List<Theater> getTheatersByTotalSeats(int seatcapcity);

}
