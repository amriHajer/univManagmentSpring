package com.example.schoolmanagement.repository;

import com.example.schoolmanagement.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudiantRepo extends JpaRepository<Etudiant, Integer> {
    List<Etudiant> findByClasse_Id(Long classeId);

}
