package com.example.schoolmanagement.repository;

import com.example.schoolmanagement.entity.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeanceRepo extends JpaRepository<Seance, Long> {
    List<Seance> findByMatiereId(Long matiereId);
    List<Seance> findByEnseignantId(Long enseignantId);
    List<Seance> findBySalleId(Long salleId);
}