package com.project.movieticket.exceptions;

public class MovieNotFound extends RuntimeException{
    public MovieNotFound(String exception) {
        super(exception);
    }
}
