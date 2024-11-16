package com.example.schoolmanagement.service;

import com.example.schoolmanagement.entity.Classe;
import com.example.schoolmanagement.repository.ClasseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasseService {

    @Autowired
    private ClasseRepo classeRepo;

    // Obtenir toutes les classes
    public List<Classe> getAllClasses() {
        return classeRepo.findAll();
    }

    // Obtenir une classe par ID
    public Classe getClasseById(Long id) {
        return classeRepo.findById(id).orElseThrow(() -> new RuntimeException("Classe non trouvée"));
    }

    // Ajouter une nouvelle classe
    public Classe addClasse(Classe classe) {
        return classeRepo.save(classe);
    }

    // Mettre à jour une classe existante
    public Classe updateClasse(Long id, Classe classeDetails) {
        Classe existingClasse = getClasseById(id);
        existingClasse.setNomClasse(classeDetails.getNomClasse());
        existingClasse.setNiveau(classeDetails.getNiveau());
        existingClasse.setSpecialite(classeDetails.getSpecialite());
        existingClasse.setAnneeUniversitaire(classeDetails.getAnneeUniversitaire());
        existingClasse.setEtudiants(classeDetails.getEtudiants());
        existingClasse.setEmploisDuTemps(classeDetails.getEmploisDuTemps());
        existingClasse.setEnseignants(classeDetails.getEnseignants());
        return classeRepo.save(existingClasse);
    }

    // Supprimer une classe
    public void deleteClasse(Long id) {
        classeRepo.deleteById(id);
    }

    // Rechercher des classes par nom
    public List<Classe> getClassesByNom(String nomClasse) {
        return classeRepo.findByNomClasse(nomClasse);
    }

    // Rechercher des classes par spécialité
    public List<Classe> getClassesBySpecialiteId(Long specialiteId) {
        return classeRepo.findBySpecialiteId(specialiteId);
    }
}
