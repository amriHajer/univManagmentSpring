package com.example.schoolmanagement.repository;

import com.example.schoolmanagement.entity.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemestreRepo extends JpaRepository<Semestre, Long> {
}
