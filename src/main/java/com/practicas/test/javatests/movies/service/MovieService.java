package com.practicas.test.javatests.movies.service;

import com.practicas.test.javatests.movies.data.MovieRepository;
import com.practicas.test.javatests.movies.model.Genre;
import com.practicas.test.javatests.movies.model.Movie;

import java.util.Collection;

public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre) {
        return movieRepository.findAll().stream().filter(
                movie -> movie.getGenre()==genre
        ).toList();
    }

    public Collection<Movie> findMoviesByLength(int length) {
        return movieRepository.findAll().stream().filter(
                movie -> movie.getMinutes()<=length
        ).toList();
    }
}
