package com.example.entrevueSpringBoot.service;

import com.example.entrevueSpringBoot.entity.Film;
import com.example.entrevueSpringBoot.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("filmService")
public class FilmService {

    @Autowired
    FilmRepository filmRepository;

    public Film getFilmById(Long id) {
        return filmRepository.getById(id);
    }

    public Film save(final Film film) {
        return filmRepository.save(film);
    }
}
