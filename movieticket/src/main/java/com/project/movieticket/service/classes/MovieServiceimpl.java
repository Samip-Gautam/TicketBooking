package com.project.movieticket.service.classes;

import com.project.movieticket.entity.Movie;
import com.project.movieticket.exceptions.MovieNotFound;
import com.project.movieticket.repository.MovieRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@RequiredArgsConstructor
@Service

public class MovieServiceimpl implements com.project.movieticket.service.interfaces.MovieService {
    private final MovieRepository movieRepository;
    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElseThrow(() -> new MovieNotFound("Movie not found with id: " + id));
    }
}
