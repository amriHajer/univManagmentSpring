package com.example.schoolmanagement.service;

import com.example.schoolmanagement.entity.Matiere;
import com.example.schoolmanagement.repository.MatiereRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatiereService {

    @Autowired
    private MatiereRepo matiereRepository;

    public List<Matiere> getAllMatieres() {
        return matiereRepository.findAll();
    }

    public Matiere getMatiereById(Long id) {
        return matiereRepository.findById(id).orElse(null);
    }

    public Matiere createMatiere(Matiere matiere) {
        return matiereRepository.save(matiere);
    }

    public Matiere updateMatiere(Long id, Matiere matiere) {
        Matiere existingMatiere = getMatiereById(id);
        if (existingMatiere != null) {
            existingMatiere.setNomMatiere(matiere.getNomMatiere());
            return matiereRepository.save(existingMatiere);
        }
        return null;
    }

    public void deleteMatiere(Long id) {
        matiereRepository.deleteById(id);
    }
}
