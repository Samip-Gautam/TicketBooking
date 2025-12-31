package com.project.movieticket.controller;

import com.project.movieticket.entity.Theater;
import com.project.movieticket.exceptions.TheaterNotFound;
import com.project.movieticket.service.interfaces.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/theater")
@RequiredArgsConstructor
public class TheaterController {

    private final TheaterService theaterService;

    @GetMapping("/all")
    public List<Theater> getAllTheaters() {
        return theaterService.getAllTheaters();
    }

    @GetMapping("/{id}")
    public Theater getTheaterById(@PathVariable Long id) {
        return theaterService.getTheaterById(id);
    }

    @GetMapping("/city/{city}")
    public List<Theater> getTheatersByCity(@PathVariable String city) {
        return theaterService.getTheatersByCity(city);
    }

    @GetMapping("/seats/{totalseats}")
    public List<Theater> getTheatersByTotalSeats(@PathVariable int totalSeats) {
        return theaterService.getTheatersByTotalSeats(totalSeats);
    }
}
