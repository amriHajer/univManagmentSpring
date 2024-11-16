package com.example.schoolmanagement.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Specialite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomSpecialite;
    private String cycle;

    @OneToMany(mappedBy = "specialite", cascade = CascadeType.ALL)
    private List<Module> modules = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "specialite_niveau",
            joinColumns = @JoinColumn(name = "specialite_id"),
            inverseJoinColumns = @JoinColumn(name = "niveau_id")
    )
    private List<Niveau> niveaux = new ArrayList<>();

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomSpecialite() {
        return nomSpecialite;
    }

    public void setNomSpecialite(String nomSpecialite) {
        this.nomSpecialite = nomSpecialite;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public List<Niveau> getNiveaux() {
        return niveaux;
    }

    public void setNiveaux(List<Niveau> niveaux) {
        this.niveaux = niveaux;
    }
}
