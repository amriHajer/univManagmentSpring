package com.example.schoolmanagement.repository;

import com.example.schoolmanagement.entity.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatiereRepo extends JpaRepository<Matiere, Long> {
}
