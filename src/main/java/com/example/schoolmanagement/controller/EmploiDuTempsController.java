package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.entity.EmploiDuTemps;
import com.example.schoolmanagement.service.EmploiDuTempsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/public/emploiDuTemps")
public class EmploiDuTempsController {

    @Autowired
    private EmploiDuTempsService emploiDuTempsService;

    // Obtenir tous les emplois du temps
    @GetMapping
    public ResponseEntity<List<EmploiDuTemps>> getAllEmploiDuTemps() {
        List<EmploiDuTemps> emploisDuTemps = emploiDuTempsService.getAllEmploiDuTemps();
        return new ResponseEntity<>(emploisDuTemps, HttpStatus.OK);
    }

    // Obtenir un emploi du temps par ID
    @GetMapping("/{id}")
    public ResponseEntity<EmploiDuTemps> getEmploiDuTempsById(@PathVariable Long id) {
        Optional<EmploiDuTemps> emploiDuTemps = emploiDuTempsService.getEmploiDuTempsById(id);
        return emploiDuTemps.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Créer un nouvel emploi du temps
    @PostMapping
    public ResponseEntity<EmploiDuTemps> createEmploiDuTemps(@RequestBody EmploiDuTemps emploiDuTemps) {
        EmploiDuTemps createdEmploiDuTemps = emploiDuTempsService.createEmploiDuTemps(emploiDuTemps);
        return new ResponseEntity<>(createdEmploiDuTemps, HttpStatus.CREATED);
    }

    // Mettre à jour un emploi du temps existant
    @PutMapping("/{id}")
    public ResponseEntity<EmploiDuTemps> updateEmploiDuTemps(@PathVariable Long id,
                                                             @RequestBody EmploiDuTemps updatedEmploiDuTemps) {
        EmploiDuTemps updated = emploiDuTempsService.updateEmploiDuTemps(id, updatedEmploiDuTemps);
        return updated != null ? ResponseEntity.ok(updated)
                : ResponseEntity.notFound().build();
    }

    // Supprimer un emploi du temps
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmploiDuTemps(@PathVariable Long id) {
        emploiDuTempsService.deleteEmploiDuTemps(id);
        return ResponseEntity.noContent().build();
    }

    // Chercher par classe
    @GetMapping("/classe/{classeId}")
    public ResponseEntity<List<EmploiDuTemps>> findByClasseId(@PathVariable Long classeId) {
        List<EmploiDuTemps> emploisDuTemps = emploiDuTempsService.findByClasseId(classeId);
        return new ResponseEntity<>(emploisDuTemps, HttpStatus.OK);
    }

    // Chercher par semestre
    @GetMapping("/semestre/{semestreId}")
    public ResponseEntity<List<EmploiDuTemps>> findBySemestreId(@PathVariable Long semestreId) {
        List<EmploiDuTemps> emploisDuTemps = emploiDuTempsService.findBySemestreId(semestreId);
        return new ResponseEntity<>(emploisDuTemps, HttpStatus.OK);
    }
}
