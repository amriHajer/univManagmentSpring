package com.example.schoolmanagement.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "etudiants")
@PrimaryKeyJoinColumn(name = "user_id")
public class Etudiant extends User{
    @Column(name = "cin", nullable = false, unique = true)
    private String cin;

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    @Column(name = "tel", nullable = false)
    private String tel;



    @ManyToOne
    @JoinColumn(name = "classe_id")
    //@JoinColumn(name = "classe_id", nullable = false)
    private Classe classe;

    @Column(nullable = false)
    private LocalDate dateNaissance;

    // Getters et setters


    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getCin() {
        return cin;
    }



    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}

