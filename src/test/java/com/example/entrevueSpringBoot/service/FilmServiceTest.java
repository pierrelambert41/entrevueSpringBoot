package com.example.entrevueSpringBoot.service;

import com.example.entrevueSpringBoot.entity.Film;
import com.example.entrevueSpringBoot.repository.FilmRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FilmServiceTest {

    @InjectMocks
    private FilmService filmService;

    @Mock
    private FilmRepository filmRepository;

    @Test
    void getFilmById() {
        Film filmEntity = new Film();
        Mockito.when(filmRepository.getById(Mockito.any())).thenReturn(filmEntity);

        Film res = filmService.getFilmById(1L);

        Assertions.assertEquals(filmEntity, res);
    }

    @Test
    void save() {
        Film filmEntity = new Film();
        Mockito.when(filmRepository.save(Mockito.any())).thenReturn(filmEntity);

        Film res = filmService.save(new Film());

        Assertions.assertEquals(filmEntity, res);
    }
}
