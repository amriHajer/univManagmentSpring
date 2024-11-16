package com.example.schoolmanagement.service;

import com.example.schoolmanagement.entity.Salle;
import com.example.schoolmanagement.repository.SalleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalleService {

    @Autowired
    private SalleRepo salleRepo;

    public List<Salle> getAllSalles() {
        return salleRepo.findAll();
    }

    public Optional<Salle> getSalleById(Long id) {
        return salleRepo.findById(id);
    }

    public Salle createSalle(Salle salle) {
        return salleRepo.save(salle);
    }

    public Salle updateSalle(Long id, Salle salleDetails) {
        return salleRepo.findById(id).map(salle -> {
            salle.setNomSalle(salleDetails.getNomSalle());
            salle.setTypeSalle(salleDetails.getTypeSalle());
            return salleRepo.save(salle);
        }).orElseThrow(() -> new RuntimeException("Salle not found with id " + id));
    }

    public void deleteSalle(Long id) {
        salleRepo.deleteById(id);
    }
}
