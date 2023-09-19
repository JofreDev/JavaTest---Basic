package com.practicas.test.javatests.movies.data;

import com.practicas.test.javatests.movies.model.*;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

class MovieRepositoryJdbcTest {

    @Test
    void load_all_movies() throws SQLException {

        // Conexión a Base de datos
        // Crea una BD en memoria de pruebas
        DataSource dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        /// Ejecutar script para cear la tabla o las tablas
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));

        MovieRepositoryJdbc movieRespositoryJdbc = new MovieRepositoryJdbc(jdbcTemplate);

        Collection<Movie>movies= movieRespositoryJdbc.findAll();

        assertThat(movies, is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACCION) ,
                new Movie(2, "Memento", 113, Genre.DRAMA) ,
                new Movie(3, "Matrix", 136, Genre.ACCION)

        )));


    }
}