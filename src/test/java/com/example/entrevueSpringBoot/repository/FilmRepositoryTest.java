package com.example.entrevueSpringBoot.repository;

import com.example.entrevueSpringBoot.entity.Film;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FilmRepositoryTest {

    @Autowired
    private FilmRepository filmRepository;

    @Test
    void findById_should_return_entry_from_db_with_provided_id() {
        Optional<Film> film = filmRepository.findById(1L);

        assertTrue(film.isPresent());
        assertEquals(1L, film.get().getId());
    }

    @Test
    void findById_should_return_empty_if_no_entity_found_with_provided_id_in_db() {
        Optional<Film> film = filmRepository.findById(1L);

        assertTrue(film.isEmpty());
    }

}
