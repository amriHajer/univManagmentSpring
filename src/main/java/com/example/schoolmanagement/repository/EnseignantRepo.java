package com.example.schoolmanagement.repository;

import com.example.schoolmanagement.entity.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnseignantRepo extends JpaRepository<Enseignant, Integer> {
    List<Enseignant> findByDepartement(String departement);
}
