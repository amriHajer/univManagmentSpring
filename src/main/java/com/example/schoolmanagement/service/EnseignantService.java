package com.example.schoolmanagement.service;

import com.example.schoolmanagement.entity.Enseignant;
import com.example.schoolmanagement.repository.EnseignantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnseignantService {
    @Autowired
    private EnseignantRepo enseignantRepo;


    public Enseignant saveEnseignant(Enseignant enseignant) {
        return enseignantRepo.save(enseignant);
    }


    public List<Enseignant> getAllEnseignant() {
        return enseignantRepo.findAll();
    }


    public Optional<Enseignant> getEnseignantById(Integer id) {
        return enseignantRepo.findById(id);
    }


//    public Enseignant updateEnseignant(Integer id, Enseignant enseignanttDetails) {
//        Optional<Enseignant> enseignantOptional = enseignantRepo.findById(id);
//        if (enseignantOptional.isPresent()) {
//            Enseignant existingEnseignant = enseignantOptional.get();
//            existingEnseignant.setName(existingEnseignant.getName());
//            existingEnseignant.setEmail(existingEnseignant.getEmail());
//            existingEnseignant.setPassword(existingEnseignant.getPassword());
//            existingEnseignant.setRole(existingEnseignant.getRole());
//            existingEnseignant.setDepartement(existingEnseignant.getDepartement());
//            existingEnseignant.setImageUrl(existingEnseignant.getImageUrl());
//            existingEnseignant.setClasses(existingEnseignant.getClasses()); /*****/
//            existingEnseignant.setSeances(existingEnseignant.getSeances()); /*****/
//
//            return enseignantRepo.save(existingEnseignant);
//        } else {
//            return null;
//        }
//    }



    public Enseignant updateEnseignant(Integer id, Enseignant enseignantDetails) {
        Optional<Enseignant> enseignantOptional = enseignantRepo.findById(id);
        if (enseignantOptional.isPresent()) {
            Enseignant existingEnseignant = enseignantOptional.get();

            // Mettre à jour les propriétés avec les détails fournis
            existingEnseignant.setName(enseignantDetails.getName());
            existingEnseignant.setEmail(enseignantDetails.getEmail());
            existingEnseignant.setPassword(enseignantDetails.getPassword());
            existingEnseignant.setRole(enseignantDetails.getRole());
            existingEnseignant.setDepartement(enseignantDetails.getDepartement());
            existingEnseignant.setImageUrl(enseignantDetails.getImageUrl());

            return enseignantRepo.save(existingEnseignant);
        } else {
            return null; // ou lancer une exception pour gérer le cas où l'enseignant n'est pas trouvé
        }
    }







    // Méthode pour supprimer un enseignant par son ID
    public void deleteEnseignantById(Integer id) {
        enseignantRepo.deleteById(id);
    }
}



