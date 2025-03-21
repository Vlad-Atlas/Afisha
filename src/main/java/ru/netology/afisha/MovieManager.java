package ru.netology.afisha;

import java.util.Arrays;


public class MovieManager {
    private String[] movies = new String[0];
    private final int limit;

    public MovieManager() {
        this.limit = 5;
    }

    public MovieManager(int limit) {
        this.limit = limit;
    }

    public void add(String movie) {
        String[] newMovies = Arrays.copyOf(movies, movies.length + 1);
        newMovies[newMovies.length - 1] = movie;
        movies = newMovies;
    }

    public String[] findAll() {
        return Arrays.copyOf(movies, movies.length);
    }

    public String[] findLast() {
        int resultLength = Math.min(limit, movies.length);
        String[] result = new String[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = movies[movies.length - 1 - i];
        }
        return result;
    }
}