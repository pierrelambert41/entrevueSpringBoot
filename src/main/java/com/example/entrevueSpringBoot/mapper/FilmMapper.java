package com.example.entrevueSpringBoot.mapper;

import com.example.entrevueSpringBoot.dto.FilmDto;
import com.example.entrevueSpringBoot.entity.Film;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FilmMapper {

    FilmDto filmToFilmDTO(Film film);

    Film filmDTOToFilm(FilmDto filmDTO);

}
