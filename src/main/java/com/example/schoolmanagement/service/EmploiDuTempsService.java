package com.example.schoolmanagement.service;

import com.example.schoolmanagement.entity.EmploiDuTemps;
import com.example.schoolmanagement.repository.EmploiDuTempsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmploiDuTempsService {

    @Autowired
    private EmploiDuTempsRepo emploiDuTempsRepo;

    // Obtenir tous les emplois du temps
    public List<EmploiDuTemps> getAllEmploiDuTemps() {
        return emploiDuTempsRepo.findAll();
    }

    // Obtenir un emploi du temps par ID
    public Optional<EmploiDuTemps> getEmploiDuTempsById(Long id) {
        return emploiDuTempsRepo.findById(id);
    }

    // Créer un nouvel emploi du temps
    public EmploiDuTemps createEmploiDuTemps(EmploiDuTemps emploiDuTemps) {
        return emploiDuTempsRepo.save(emploiDuTemps);
    }

    // Mettre à jour un emploi du temps existant
    public EmploiDuTemps updateEmploiDuTemps(Long id, EmploiDuTemps updatedEmploiDuTemps) {
        Optional<EmploiDuTemps> existingEmploiDuTempsOpt = emploiDuTempsRepo.findById(id);
        if (existingEmploiDuTempsOpt.isPresent()) {
            EmploiDuTemps emploiDuTemps = existingEmploiDuTempsOpt.get();

            // Mettre à jour les champs si les nouvelles valeurs ne sont pas nulles
            if (updatedEmploiDuTemps.getClasse() != null) {
                emploiDuTemps.setClasse(updatedEmploiDuTemps.getClasse());
            }
            if (updatedEmploiDuTemps.getSemestre() != null) {
                emploiDuTemps.setSemestre(updatedEmploiDuTemps.getSemestre());
            }
            if (updatedEmploiDuTemps.getAnneeUniversitaire() != null) {
                emploiDuTemps.setAnneeUniversitaire(updatedEmploiDuTemps.getAnneeUniversitaire());
            }
            if (updatedEmploiDuTemps.getSeances() != null) {
                emploiDuTemps.setSeances(updatedEmploiDuTemps.getSeances());
            }
            return emploiDuTempsRepo.save(emploiDuTemps);
        }
        return null;
    }

    // Supprimer un emploi du temps
    public void deleteEmploiDuTemps(Long id) {
        emploiDuTempsRepo.deleteById(id);
    }

    // Chercher par classe
    public List<EmploiDuTemps> findByClasseId(Long classeId) {
        return emploiDuTempsRepo.findByClasseId(classeId);
    }

    // Chercher par semestre
    public List<EmploiDuTemps> findBySemestreId(Long semestreId) {
        return emploiDuTempsRepo.findBySemestreId(semestreId);
    }

    // Chercher par année universitaire
    public List<EmploiDuTemps> findByAnneeUniversitaireId(Long anneeUniversitaireId) {
        return emploiDuTempsRepo.findByAnneeUniversitaireId(anneeUniversitaireId);
    }
}
