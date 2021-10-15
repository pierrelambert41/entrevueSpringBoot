package com.example.entrevueSpringBoot.controller;

import com.example.entrevueSpringBoot.dto.FilmDto;
import com.example.entrevueSpringBoot.entity.Acteur;
import com.example.entrevueSpringBoot.entity.Film;
import com.example.entrevueSpringBoot.mapper.FilmMapper;
import com.example.entrevueSpringBoot.service.FilmService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.service.spi.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(FilmController.class)
public class FilmControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private FilmService filmService;

    @MockBean
    private FilmMapper filmMapper;


    @Test
    void getFilmById_should_return_status_200_if_found() throws Exception {
        when(filmService.getFilmById(anyLong())).thenReturn(new Film());

        this.mockMvc
                .perform(get("/api/film/{id}", 1))
                .andExpect(status().isOk());
    }

    @Test
    void getFilmById_should_return_status_404_if_not_found() throws Exception {
        when(filmService.getFilmById(any())).thenReturn(null);

        this.mockMvc
                .perform(get("/api/film/{id}", 1))
                .andExpect(status().isNotFound());
    }

    @Test
    void createFilm_should_return_status_201_if_success() throws Exception {
        FilmDto dto = getDtoMock();
        dto.setId(null);
        dto.getActeurs().get(0).setId(null);
        Film film = getFilmMock();
        when(filmService.save(any())).thenReturn(film);
        FilmDto result = filmMapper.filmToFilmDTO(film);

        this.mockMvc
                .perform(
                        post("/api/film")
                                .contentType("application/json").characterEncoding("charset-utf8")
                                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated());
    }

    @Test
    void createFilm_should_return_status_500_if_service_catch_exception() throws Exception {
        FilmDto dto = getDtoMock();
        dto.setId(null);
        dto.getActeurs().get(0).setId(null);
        when(filmService.save(any())).thenThrow(new ServiceException("Error"));

        this.mockMvc
                .perform(
                        post("/api/film", 1)
                                .contentType("application/json").characterEncoding("charset-utf8")
                                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isInternalServerError());
    }

    private Film getFilmMock() {
        Acteur acteur = new Acteur();
        acteur.setId(17L);
        acteur.setNom("Lambert");
        acteur.setPrenom("Pierre");

        Film film = new Film();
        film.setId(9L);
        film.setTitre("Film titre");
        film.setDescription("Film description");
        film.setActeurs(List.of(acteur));

        return film;
    }

    private FilmDto getDtoMock() {
        Acteur acteur = new Acteur();
        acteur.setId(7L);
        acteur.setNom("Lambert");
        acteur.setPrenom("Pierre");

        FilmDto film = new FilmDto();
        film.setId(8L);
        film.setTitre("Film titre");
        film.setDescription("Film description");
        film.setActeurs(List.of(acteur));

        return film;
    }
}
