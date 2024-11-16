package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.entity.Seance;
import com.example.schoolmanagement.service.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/public/seances")
public class SeanceController {

    @Autowired
    private SeanceService seanceService;

    // Ajouter une nouvelle séance
    @PostMapping
    public ResponseEntity<Seance> createSeance(@RequestBody Seance seance) {
        Seance newSeance = seanceService.saveSeance(seance);
        return ResponseEntity.ok(newSeance);
    }

    // Récupérer toutes les séances
    @GetMapping
    public ResponseEntity<List<Seance>> getAllSeances() {
        List<Seance> seances = seanceService.getAllSeances();
        return ResponseEntity.ok(seances);
    }

    // Récupérer une séance par ID
    @GetMapping("/{id}")
    public ResponseEntity<Seance> getSeanceById(@PathVariable Long id) {
        Optional<Seance> seance = seanceService.getSeanceById(id);
        return seance.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Récupérer les séances par matière
    @GetMapping("/matiere/{matiereId}")
    public ResponseEntity<List<Seance>> getSeancesByMatiere(@PathVariable Long matiereId) {
        List<Seance> seances = seanceService.getSeancesByMatiere(matiereId);
        return ResponseEntity.ok(seances);
    }

    // Récupérer les séances par enseignant
    @GetMapping("/enseignant/{enseignantId}")
    public ResponseEntity<List<Seance>> getSeancesByEnseignant(@PathVariable Long enseignantId) {
        List<Seance> seances = seanceService.getSeancesByEnseignant(enseignantId);
        return ResponseEntity.ok(seances);
    }

    // Récupérer les séances par salle
    @GetMapping("/salle/{salleId}")
    public ResponseEntity<List<Seance>> getSeancesBySalle(@PathVariable Long salleId) {
        List<Seance> seances = seanceService.getSeancesBySalle(salleId);
        return ResponseEntity.ok(seances);
    }

    // Mettre à jour une séance existante
    @PutMapping("/{id}")
    public ResponseEntity<Seance> updateSeance(@PathVariable Long id, @RequestBody Seance seanceDetails) {
        Optional<Seance> seanceOptional = seanceService.getSeanceById(id);
        if (!seanceOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Seance seance = seanceOptional.get();
        seance.setJourSeance(seanceDetails.getJourSeance());
        seance.setDebutSeance(seanceDetails.getDebutSeance());
        seance.setFinSeance(seanceDetails.getFinSeance());
        seance.setMatiere(seanceDetails.getMatiere());
        seance.setEnseignant(seanceDetails.getEnseignant());
        seance.setSalle(seanceDetails.getSalle());
        seance.setEmploiDuTemps(seanceDetails.getEmploiDuTemps());

        Seance updatedSeance = seanceService.saveSeance(seance);
        return ResponseEntity.ok(updatedSeance);
    }

    // Supprimer une séance par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeance(@PathVariable Long id) {
        seanceService.deleteSeance(id);
        return ResponseEntity.noContent().build();
    }
}
