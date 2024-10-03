package com.example.schoolmanagement.repository;

import com.example.schoolmanagement.entity.Specialite;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Niveau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomNiveau; // ex: "Licence 1", "Master 1", etc.

    @OneToMany(mappedBy = "niveau")
    private List<Specialite> specialites;

    // Getters et Setters
}

