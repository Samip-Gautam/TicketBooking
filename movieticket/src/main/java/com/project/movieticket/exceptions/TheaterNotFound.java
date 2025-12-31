package com.project.movieticket.exceptions;

public class TheaterNotFound extends RuntimeException{
    public TheaterNotFound(String exceptionMessage) {
        super(exceptionMessage);
    }
}
