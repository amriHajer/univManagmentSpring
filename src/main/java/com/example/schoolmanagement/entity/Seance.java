package com.example.schoolmanagement.entity;

import jakarta.persistence.*;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private DayOfWeek jourSeance;
    private LocalTime debutSeance;
    private LocalTime  finSeance;

    @ManyToOne // Relation plusieurs-à-un avec EmploiDuTemps
    @JoinColumn(name = "emploi_du_temps_id", nullable = false) // Colonne de liaison dans la table Seance
    private EmploiDuTemps emploiDuTemps; // Référence à l'emploi du temps


    @ManyToOne
    @JoinColumn(name = "matiere_id", nullable = false) // Colonne de liaison pour Matiere
    private Matiere matiere; // Matière de la séance

    @ManyToOne
    @JoinColumn(name = "enseignant_id", nullable = false)
    private Enseignant enseignant;

    @ManyToOne
    @JoinColumn(name = "salle_id", nullable = false) // Colonne de liaison pour Salle
    private Salle salle; // Salle où se déroule la séance

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public DayOfWeek getJourSeance() {
        return jourSeance;
    }

    public void setJourSeance(DayOfWeek jourSeance) {
        this.jourSeance = jourSeance;
    }

    public LocalTime getDebutSeance() {
        return debutSeance;
    }

    public void setDebutSeance(LocalTime debutSeance) {
        this.debutSeance = debutSeance;
    }

    public LocalTime getFinSeance() {
        return finSeance;
    }

    public void setFinSeance(LocalTime finSeance) {
        this.finSeance = finSeance;
    }

    public EmploiDuTemps getEmploiDuTemps() {
        return emploiDuTemps;
    }

    public void setEmploiDuTemps(EmploiDuTemps emploiDuTemps) {
        this.emploiDuTemps = emploiDuTemps;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }
}
