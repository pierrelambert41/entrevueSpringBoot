package com.example.entrevueSpringBoot.dto;

import com.example.entrevueSpringBoot.entity.Acteur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FilmDto {
    private Long id;
    private String titre;
    private String description;
    private List<Acteur> acteurs;
}
