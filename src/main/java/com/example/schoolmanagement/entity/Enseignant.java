package com.example.schoolmanagement.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "enseignants")
@PrimaryKeyJoinColumn(name = "user_id")
public class Enseignant extends User {
    @Column(name = "departement", nullable = false)
    private String departement;

    @OneToMany(mappedBy = "enseignant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Seance> seances; // Liste des séances que l'enseignant assure

    @ManyToMany
    @JoinTable(
            name = "enseignant_classe",
            joinColumns = @JoinColumn(name = "enseignant_id"),
            inverseJoinColumns = @JoinColumn(name = "classe_id")
    )
    private Set<Classe> classes;

    public void setSeances(List<Seance> seances) {
        this.seances = seances;
    }

    public Set<Classe> getClasses() {
        return classes;
    }

    public void setClasses(Set<Classe> classes) {
        this.classes = classes;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public List<Seance> getSeances() {
        return seances;
    }


}
