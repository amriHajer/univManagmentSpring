package com.example.schoolmanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "enseignants")
@PrimaryKeyJoinColumn(name = "user_id")
public class Professeur extends User {
    @Column(name = "departement", nullable = false)
    private String departement;

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }
}
