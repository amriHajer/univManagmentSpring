package com.example.schoolmanagement.service;

import com.example.schoolmanagement.entity.Specialite;
import com.example.schoolmanagement.repository.SpecialiteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialiteService {

    @Autowired
    private SpecialiteRepo specialiteRepo;

    // Ajouter une nouvelle spécialité
    public Specialite createSpecialite(Specialite specialite) {
        return specialiteRepo.save(specialite);
    }

    // Récupérer une spécialité par ID
    public Optional<Specialite> getSpecialiteById(Long id) {
        return specialiteRepo.findById(id);
    }

    public Optional<List<Specialite>> getSpecialiteByCycle(String cycle) {
        return specialiteRepo.findByCycle(cycle);
    }

    // Récupérer toutes les spécialités
    public List<Specialite> getAllSpecialites() {
        return specialiteRepo.findAll();
    }

    // Mettre à jour une spécialité existante
    public Specialite updateSpecialite(Long id, Specialite updatedSpecialite) {
        Optional<Specialite> specialiteOptional = specialiteRepo.findById(id);
        if (specialiteOptional.isPresent()) {
            Specialite specialite = specialiteOptional.get();
            specialite.setNomSpecialite(updatedSpecialite.getNomSpecialite());
            specialite.setCycle(updatedSpecialite.getCycle());
            specialite.setNiveaux(updatedSpecialite.getNiveaux());
            specialite.setModules(updatedSpecialite.getModules()); // Remplacez si nécessaire
            return specialiteRepo.save(specialite);
        }
        return null;  // ou lance une exception
    }

    // Supprimer une spécialité
    public void deleteSpecialite(Long id) {
        specialiteRepo.deleteById(id);
    }
}
