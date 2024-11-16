package com.example.schoolmanagement.repository;

import com.example.schoolmanagement.entity.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NiveauRepo extends JpaRepository<Niveau, Long> {

}
