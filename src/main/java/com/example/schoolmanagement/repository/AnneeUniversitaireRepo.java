package com.example.schoolmanagement.repository;

import com.example.schoolmanagement.entity.AnneeUniversitaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnneeUniversitaireRepo extends JpaRepository<AnneeUniversitaire, Long> {

}