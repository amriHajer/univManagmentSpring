package com.example.schoolmanagement.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "modules")
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomModule;

    @ManyToOne
    @JoinColumn(name = "specialite_id")
    private Specialite specialite;

    @ManyToOne
    @JoinColumn(name = "niveau_id")
    private Niveau niveau;

    @ManyToOne
    @JoinColumn(name = "semestre_id")
    private Semestre semestre;

    @OneToMany(mappedBy = "module", cascade = CascadeType.ALL)
    private List<MatiereModule> matiereModules;

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomModule() {
        return nomModule;
    }

    public void setNomModule(String nomModule) {
        this.nomModule = nomModule;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public List<MatiereModule> getMatiereModules() {
        return matiereModules;
    }

    public void setMatiereModules(List<MatiereModule> matiereModules) {
        this.matiereModules = matiereModules;
    }
}
