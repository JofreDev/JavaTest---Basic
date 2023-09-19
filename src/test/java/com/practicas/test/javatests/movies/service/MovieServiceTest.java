package com.practicas.test.javatests.movies.service;

import com.practicas.test.javatests.movies.data.MovieRepository;
import com.practicas.test.javatests.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import static com.practicas.test.javatests.movies.model.Genre.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

class MovieServiceTest {

    private MovieService movieService;

    @BeforeEach
    void setUp() {

        // Acá si simulo sus respuestas !! No tengo su implementación y no la necesito !
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, ACTION),
                        new Movie(2, "Memento", 113, THRILLER),
                        new Movie(3, "There's Something About Mary", 119, COMEDY),
                        new Movie(4, "Super 8", 112, THRILLER),
                        new Movie(5, "Scream", 111, HORROR),
                        new Movie(6, "Home Alone", 103, COMEDY),
                        new Movie(7, "Matrix", 136, ACTION)
                )
        );

         movieService = new MovieService(movieRepository);

    }

    @Test
    void return_movies_by_genre() {


        Collection<Movie> movies = movieService.findMoviesByGenre(COMEDY);

        Collection<Integer> moviesIds = getMovieIds(movies);

        assertThat(moviesIds, CoreMatchers.is(
                Arrays.asList(3,6)
        ));


    }

    @Test
    void return_movies_by_duration() {

        Collection<Movie> movies = movieService.findMoviesByLength(119);
        Collection<Integer> moviesIds = getMovieIds(movies);

        assertThat(moviesIds, CoreMatchers.is(
                Arrays.asList(2,3,4,5,6)
        ));
    }

    private static Collection<Integer> getMovieIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).toList();
    }
}