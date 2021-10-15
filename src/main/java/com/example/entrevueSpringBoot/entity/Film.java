package com.example.entrevueSpringBoot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "films")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titre;
    private String description;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Acteur> acteurs;
}
