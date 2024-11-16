package com.example.schoolmanagement.repository;

import com.example.schoolmanagement.entity.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalleRepo extends JpaRepository<Salle, Long> {
}
