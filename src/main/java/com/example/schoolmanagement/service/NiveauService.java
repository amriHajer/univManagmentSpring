package com.example.schoolmanagement.service;

import com.example.schoolmanagement.entity.Niveau;
import com.example.schoolmanagement.repository.NiveauRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NiveauService {

    @Autowired
    private NiveauRepo niveauRepo;

    // Ajouter un nouveau niveau
    public Niveau createNiveau(Niveau niveau) {
        return niveauRepo.save(niveau);
    }

    // Récupérer un niveau par ID
    public Optional<Niveau> getNiveauById(Long id) {
        return niveauRepo.findById(id);
    }

    // Récupérer tous les niveaux
    public List<Niveau> getAllNiveaux() {
        return niveauRepo.findAll();
    }

    // Mettre à jour un niveau existant
    public Niveau updateNiveau(Long id, Niveau niveauDetails) {
        Optional<Niveau> niveauOptional = niveauRepo.findById(id);
        if (niveauOptional.isPresent()) {
            Niveau niveau = niveauOptional.get();
            niveau.setNomNiveau(niveauDetails.getNomNiveau());
            niveau.setSpecialites(niveauDetails.getSpecialites());
            return niveauRepo.save(niveau);
        } else {
            throw new RuntimeException("Niveau non trouvé pour id: " + id);
        }
    }

    // Supprimer un niveau
    public void deleteNiveau(Long id) {
        niveauRepo.deleteById(id);
    }
}
