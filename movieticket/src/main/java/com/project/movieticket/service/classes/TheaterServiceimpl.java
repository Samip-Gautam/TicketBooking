package com.project.movieticket.service.classes;

import com.project.movieticket.entity.Theater;
import com.project.movieticket.exceptions.TheaterNotFound;
import com.project.movieticket.repository.TheaterRepository;
import com.project.movieticket.service.interfaces.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TheaterServiceimpl implements TheaterService {

    private final TheaterRepository theaterRepository;

    @Override
    public List<Theater> getAllTheaters() {
        return theaterRepository.findAll();
    }

    @Override
    public Theater getTheaterById(Long id) {
        return theaterRepository.findById(id)
                .orElseThrow(() -> new TheaterNotFound("Theater not found: " + id));
    }

    @Override
    public List<Theater> getTheatersByCity(String city) {
        return theaterRepository.findByCity(city);
    }

    @Override
    public List<Theater> getTheatersByType(int type) {
        return theaterRepository.findByType(type);
    }

    @Override
    public List<Theater> getTheatersByTotalSeats(int totalSeats) {
        return theaterRepository.findByTotalSeats(totalSeats);
    }
}
