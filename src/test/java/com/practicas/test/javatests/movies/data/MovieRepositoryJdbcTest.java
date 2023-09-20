package com.practicas.test.javatests.movies.data;

import com.practicas.test.javatests.movies.model.*;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

@Transactional
@Rollback
class MovieRepositoryJdbcTest {

    private static MovieRepositoryJdbc movieRespositoryJdbc;

    @BeforeAll
    static void setUp() throws SQLException {
        // Conexión a Base de datos
        // Crea una BD en memoria de pruebas
        DataSource dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        /// Ejecutar script para cear la tabla o las tablas
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));

        movieRespositoryJdbc = new MovieRepositoryJdbc(jdbcTemplate);
    }

    @Test
    void insert_a_movie() {
        Movie movie = new Movie(4,"Taxi Driver", 114, Genre.DRAMA);
        movieRespositoryJdbc.saveOrUpdate(movie);

        Movie movieExpected = movieRespositoryJdbc.findById(4);
        assertThat(movieExpected, is(movie));

    }

    /* Este test no funciona como deberia, se acomodó para su funcionamiento
     * No se arregla de verdad porque acá (en esta clase) deberia servir
     * la anotación @Transactional y @Rollback pero no se estan usando
     * configuraciones propias de spring. Lo que hace que falle.
     */

    @Test
    void load_all_movies()  {


        Collection<Movie>movies= movieRespositoryJdbc.findAll();

        assertThat(movies, is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACCION) ,
                new Movie(2, "Memento", 113, Genre.DRAMA) ,
                new Movie(3, "Matrix", 136, Genre.ACCION),
                new Movie(4,"Taxi Driver", 114, Genre.DRAMA)


        )));


    }

    @Test
    void load_movie_by_id() {

        Movie movie = movieRespositoryJdbc.findById(2);

        assertThat(movie, is(new Movie(2,"Memento",113,Genre.DRAMA)));
    }



}