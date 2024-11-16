package com.example.schoolmanagement.entity;

import jakarta.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomClasse;

    @ManyToOne
    @JoinColumn(name = "niveau_id", nullable = false)
    private Niveau niveau;

    @ManyToOne
    @JoinColumn(name = "specialite_id", nullable = false)
    private Specialite specialite;

    @ManyToOne
    @JoinColumn(name = "annee_universitaire_id")
    private AnneeUniversitaire anneeUniversitaire;

    @OneToMany(mappedBy = "classe", cascade = CascadeType.ALL)
    private List<Etudiant> etudiants;

    @OneToMany(mappedBy = "classe", cascade = CascadeType.ALL)
    private List<EmploiDuTemps> emploisDuTemps;

    @ManyToMany(mappedBy = "classes")  // L'attribut 'classes' doit exister dans l'entité 'Enseignant'
    private Set<Enseignant> enseignants;

    // Getters et Setters
    public Long getId() {
        return id;
    }


    public Set<Enseignant> getEnseignants() {
        return enseignants;
    }

    public void setEnseignants(Set<Enseignant> enseignants) {
        this.enseignants = enseignants;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    public AnneeUniversitaire getAnneeUniversitaire() {
        return anneeUniversitaire;
    }

    public void setAnneeUniversitaire(AnneeUniversitaire anneeUniversitaire) {
        this.anneeUniversitaire = anneeUniversitaire;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public List<EmploiDuTemps> getEmploisDuTemps() {
        return emploisDuTemps;
    }

    public void setEmploisDuTemps(List<EmploiDuTemps> emploisDuTemps) {
        this.emploisDuTemps = emploisDuTemps;
    }
}
