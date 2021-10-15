package com.example.entrevueSpringBoot.repository;

import com.example.entrevueSpringBoot.entity.Acteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActeurRepository extends JpaRepository<Acteur, Long> {
}
