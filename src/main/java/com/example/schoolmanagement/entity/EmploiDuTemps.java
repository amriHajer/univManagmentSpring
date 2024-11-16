package com.example.schoolmanagement.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class EmploiDuTemps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relation avec la Classe
    @ManyToOne
    @JoinColumn(name = "classe_id", nullable = false)
    private Classe classe;

    public AnneeUniversitaire getAnneeUniversitaire() {
        return anneeUniversitaire;
    }

    public void setAnneeUniversitaire(AnneeUniversitaire anneeUniversitaire) {
        this.anneeUniversitaire = anneeUniversitaire;
    }

    @ManyToOne
    @JoinColumn(name = "annee_universitaire_id", nullable = false)
    private AnneeUniversitaire anneeUniversitaire;

    // Relation avec le Semestre
    @ManyToOne
    @JoinColumn(name = "semestre_id", nullable = false)
    private Semestre semestre;

    // Relation avec les séances
    @OneToMany(mappedBy = "emploiDuTemps", cascade = CascadeType.ALL)
    private List<Seance> seances;



    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public List<Seance> getSeances() {
        return seances;
    }

    public void setSeances(List<Seance> seances) {
        this.seances = seances;
    }
}
