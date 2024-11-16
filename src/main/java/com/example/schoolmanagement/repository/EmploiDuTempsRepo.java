package com.example.schoolmanagement.repository;

import com.example.schoolmanagement.entity.EmploiDuTemps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmploiDuTempsRepo extends JpaRepository<EmploiDuTemps, Long> {
    List<EmploiDuTemps> findByClasseId(Long classeId);
    List<EmploiDuTemps> findBySemestreId(Long semestreId);
    List<EmploiDuTemps> findByAnneeUniversitaireId(Long anneeUniversitaireId);
}
