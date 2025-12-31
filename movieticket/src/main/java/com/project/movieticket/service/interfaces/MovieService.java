package com.project.movieticket.service.interfaces;

import com.project.movieticket.entity.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAllMovies();

    Movie getMovieById(Long id);
}
