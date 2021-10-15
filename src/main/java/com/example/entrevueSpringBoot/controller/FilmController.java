package com.example.entrevueSpringBoot.controller;

import com.example.entrevueSpringBoot.dto.FilmDto;
import com.example.entrevueSpringBoot.entity.Film;
import com.example.entrevueSpringBoot.mapper.FilmMapper;
import com.example.entrevueSpringBoot.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/")
public class FilmController {

    @Autowired
    FilmService filmService;

    @Autowired
    FilmMapper filmMapper;

    // l'URI aurait du être 'films/', mais pour ne pas créer de confusion avec le script postman j'ai laissé film

    /**
     * Read - Get Film
     * @param id
     * @return An object of Film full filled
     */
    @GetMapping("film/{id}")
    public ResponseEntity<FilmDto> getFilm(@PathVariable("id") long id) {
        Optional<Film> filmResult = Optional.ofNullable(filmService.getFilmById(id));

        return filmResult
                .map(r -> new ResponseEntity<>(filmMapper.filmToFilmDTO(r), HttpStatus.OK))
                .orElse(ResponseEntity.notFound().build());

    }

    /**
     * Add Film
     * @param filmDto
     * @return The film object saved
     */
    @PostMapping("film")
    public ResponseEntity<Film> createFilm(@RequestBody FilmDto filmDto) {
        Optional<Film> film = Optional.ofNullable(filmService.save(filmMapper.filmDTOToFilm(filmDto)));
        return ResponseEntity.of(film);
    }

}
