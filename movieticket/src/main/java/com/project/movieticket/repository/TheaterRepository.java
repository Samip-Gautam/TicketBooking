package com.project.movieticket.repository;

import com.project.movieticket.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TheaterRepository extends JpaRepository<Theater, Long> {
    List<Theater> findByCity(String city);

    List<Theater> findByTotalSeats(int totalSeats);
}
