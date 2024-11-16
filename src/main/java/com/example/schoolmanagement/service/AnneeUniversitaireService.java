package com.example.schoolmanagement.service;

import com.example.schoolmanagement.entity.AnneeUniversitaire;
import com.example.schoolmanagement.repository.AnneeUniversitaireRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnneeUniversitaireService {

    @Autowired
    private AnneeUniversitaireRepo anneeUniversitaireRepo;

    // Méthode pour récupérer toutes les années universitaires
    public List<AnneeUniversitaire> getAllAnneesUniversitaires() {
        return anneeUniversitaireRepo.findAll();
    }

    // Méthode pour obtenir une année universitaire par ID
    public Optional<AnneeUniversitaire> getAnneeUniversitaireById(Long id) {
        return anneeUniversitaireRepo.findById(id);
    }

    // Méthode pour ajouter ou mettre à jour une année universitaire
    public AnneeUniversitaire saveAnneeUniversitaire(AnneeUniversitaire anneeUniversitaire) {
        return anneeUniversitaireRepo.save(anneeUniversitaire);
    }

    // Méthode pour supprimer une année universitaire
    public void deleteAnneeUniversitaire(Long id) {
        anneeUniversitaireRepo.deleteById(id);
    }
}
