package com.example.schoolmanagement.repository;

import com.example.schoolmanagement.entity.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClasseRepo extends JpaRepository<Classe, Long> {
    List<Classe> findByNomClasse(String nomClasse);
    List<Classe> findBySpecialiteId(Long specialiteId);
}
