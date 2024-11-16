package com.example.schoolmanagement.repository;

import com.example.schoolmanagement.entity.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpecialiteRepo extends JpaRepository<Specialite, Long> {
    Optional<List<Specialite>> findByCycle(String cycle);
}
