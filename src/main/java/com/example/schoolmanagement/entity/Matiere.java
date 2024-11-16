package com.example.schoolmanagement.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Matiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomMatiere;



    // Relation OneToMany avec MatiereModule
    @OneToMany(mappedBy = "matiere", cascade = CascadeType.ALL)
    private List<MatiereModule> matiereModules = new ArrayList<>();



    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomMatiere() {
        return nomMatiere;
    }

    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }


    public List<MatiereModule> getMatiereModules() {
        return matiereModules;
    }

    public void setMatiereModules(List<MatiereModule> matiereModules) {
        this.matiereModules = matiereModules;
    }
}
