package com.example.schoolmanagement.service;

import com.example.schoolmanagement.entity.Seance;
import com.example.schoolmanagement.repository.SeanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeanceService {

    @Autowired
    private SeanceRepo seanceRepository;

    // Ajouter une séance
    public Seance saveSeance(Seance seance) {
        return seanceRepository.save(seance);
    }

    // Obtenir toutes les séances
    public List<Seance> getAllSeances() {
        return seanceRepository.findAll();
    }

    // Obtenir une séance par ID
    public Optional<Seance> getSeanceById(Long id) {
        return seanceRepository.findById(id);
    }

    // Obtenir les séances par matière
    public List<Seance> getSeancesByMatiere(Long matiereId) {
        return seanceRepository.findByMatiereId(matiereId);
    }

    // Obtenir les séances par enseignant
    public List<Seance> getSeancesByEnseignant(Long enseignantId) {
        return seanceRepository.findByEnseignantId(enseignantId);
    }

    // Obtenir les séances par salle
    public List<Seance> getSeancesBySalle(Long salleId) {
        return seanceRepository.findBySalleId(salleId);
    }

    // Supprimer une séance par ID
    public void deleteSeance(Long id) {
        seanceRepository.deleteById(id);
    }
}