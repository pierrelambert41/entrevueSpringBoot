package com.example.entrevueSpringBoot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ActeurDto {
    private Long id;
    private String nom;
    private String prenom;
}
