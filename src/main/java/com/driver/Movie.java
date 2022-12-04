package com.driver;

import org.springframework.stereotype.Component;


@Component
public class Movie{

    private String name;
    private int durationInMinutes;
    private double imdbRating;

    public Movie(String name, int durationInMinutes, double imdbRating) {
        this.name = name;
        this.durationInMinutes = durationInMinutes;
        this.imdbRating = imdbRating;
    }

    public Movie() {

    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return durationInMinutes;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(int duration) {
        this.durationInMinutes = duration;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }
}


