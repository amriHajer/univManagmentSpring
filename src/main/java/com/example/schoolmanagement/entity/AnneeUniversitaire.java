package com.example.schoolmanagement.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class AnneeUniversitaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomAnnee;

    @OneToMany(mappedBy = "anneeUniversitaire", cascade = CascadeType.ALL)
    private List<Classe> classes = new ArrayList<>();

    @OneToMany(mappedBy = "anneeUniversitaire", cascade = CascadeType.ALL)
    private List<EmploiDuTemps> emploisDuTemps = new ArrayList<>();


    public List<EmploiDuTemps> getEmploisDuTemps() {
        return emploisDuTemps;
    }

    public void setEmploisDuTemps(List<EmploiDuTemps> emploisDuTemps) {
        this.emploisDuTemps = emploisDuTemps;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Classe> getClasses() {
        return classes;
    }

    public void setClasses(List<Classe> classes) {
        this.classes = classes;
    }

    public String getNomAnnee() {
        return nomAnnee;
    }

    public void setNomAnnee(String nomAnnee) {
        this.nomAnnee = nomAnnee;
    }


}
