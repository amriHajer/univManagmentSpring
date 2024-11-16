package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.entity.Specialite;
import com.example.schoolmanagement.service.SpecialiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/public/specialites")
public class SpecialiteController {

    @Autowired
    private SpecialiteService specialiteService;

    // Créer une nouvelle spécialité
    @PostMapping
    public ResponseEntity<Specialite> createSpecialite(@RequestBody Specialite specialite) {
        Specialite newSpecialite = specialiteService.createSpecialite(specialite);
        return ResponseEntity.ok(newSpecialite);
    }

    // Récupérer toutes les spécialités
    @GetMapping
    public ResponseEntity<List<Specialite>> getAllSpecialites() {
        List<Specialite> specialites = specialiteService.getAllSpecialites();
        return ResponseEntity.ok(specialites);
    }

    // Récupérer une spécialité par ID
    @GetMapping("/{id}")
    public ResponseEntity<Specialite> getSpecialiteById(@PathVariable Long id) {
        Optional<Specialite> specialite = specialiteService.getSpecialiteById(id);
        return specialite.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Récupérer les spécialités par cycle
    @GetMapping("/cycle/{cycle}")
    public ResponseEntity<List<Specialite>> getSpecialiteByCycle(@PathVariable String cycle) {
        Optional<List<Specialite>> specialites = specialiteService.getSpecialiteByCycle(cycle);
        return specialites.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Mettre à jour une spécialité existante
    @PutMapping("/{id}")
    public ResponseEntity<Specialite> updateSpecialite(@PathVariable Long id, @RequestBody Specialite specialiteDetails) {
        Specialite updatedSpecialite = specialiteService.updateSpecialite(id, specialiteDetails);
        return ResponseEntity.ok(updatedSpecialite);
    }

    // Supprimer une spécialité par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpecialite(@PathVariable Long id) {
        specialiteService.deleteSpecialite(id);
        return ResponseEntity.noContent().build();
    }
}
