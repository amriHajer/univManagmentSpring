package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.entity.Salle;
import com.example.schoolmanagement.service.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/salles")
public class SalleController {

    @Autowired
    private SalleService salleService;

    // Récupérer toutes les salles
    @GetMapping
    public List<Salle> getAllSalles() {
        return salleService.getAllSalles();
    }

    // Créer une nouvelle salle
    @PostMapping
    public ResponseEntity<Salle> createSalle(@RequestBody Salle salle) {
        Salle savedSalle = salleService.createSalle(salle);
        return ResponseEntity.status(201).body(savedSalle); // Retourne un code 201 Created
    }

    // Récupérer une salle par ID
    @GetMapping("/{id}")
    public ResponseEntity<Salle> getSalleById(@PathVariable Long id) {
        return salleService.getSalleById(id)
                .map(ResponseEntity::ok) // Retourne 200 OK si trouvé
                .orElseGet(() -> ResponseEntity.notFound().build()); // Retourne 404 Not Found
    }

    // Mettre à jour une salle existante
    @PutMapping("/{id}")
    public ResponseEntity<Salle> updateSalle(@PathVariable Long id, @RequestBody Salle salleDetails) {
        try {
            Salle updatedSalle = salleService.updateSalle(id, salleDetails);
            return ResponseEntity.ok(updatedSalle); // Retourne 200 OK si mis à jour
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // Retourne 404 Not Found si non trouvé
        }
    }

    // Supprimer une salle par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalle(@PathVariable Long id) {
        salleService.deleteSalle(id);
        return ResponseEntity.noContent().build(); // Retourne 204 No Content après suppression
    }
}
