package com.example.schoolmanagement.service;

import com.example.schoolmanagement.entity.Enseignant;
import com.example.schoolmanagement.entity.Etudiant;
import com.example.schoolmanagement.repository.EnseignantRepo;
import com.example.schoolmanagement.repository.EtudiantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {
    @Autowired
    private EtudiantRepo etudiantRepo;


    public Etudiant saveEnseignant(Etudiant etudiant) {
        return etudiantRepo.save(etudiant);
    }


    public List<Etudiant> getAllEnseignant() {
        return etudiantRepo.findAll();
    }


    public Optional<Etudiant> getEnseignantById(Integer id) {
        return etudiantRepo.findById(id);
    }


    public Etudiant updateEtudiant(Integer id, Etudiant etudianttDetails) {
        Optional<Etudiant> etudiantOptional = etudiantRepo.findById(id);
        if (etudiantOptional.isPresent()) {
            Etudiant existingEtudiant = etudiantOptional.get();
            existingEtudiant.setName(etudianttDetails.getName());
            existingEtudiant.setEmail(etudianttDetails.getEmail());
            existingEtudiant.setPassword(etudianttDetails.getPassword());
            existingEtudiant.setRole(etudianttDetails.getRole());
            existingEtudiant.setTel(etudianttDetails.getTel());
            existingEtudiant.setImageUrl(etudianttDetails.getImageUrl());
            existingEtudiant.setCin(etudianttDetails.getCin());
            existingEtudiant.setDateNaissance(etudianttDetails.getDateNaissance());

            return etudiantRepo.save(existingEtudiant);
        } else {
            return null;
        }
    }

    public List<Etudiant> getEtudiantsByClasseId(Long classeId) {
        return etudiantRepo.findByClasse_Id(classeId);
    }

    // Méthode pour supprimer un enseignant par son ID
    public void deleteEtudiantById(Integer id) {
        etudiantRepo.deleteById(id);
    }

}
