package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.entity.Niveau;
import com.example.schoolmanagement.service.NiveauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/public/niveaux")
public class NiveauController {

    @Autowired
    private NiveauService niveauService;

    // Créer un nouveau niveau
    @PostMapping
    public ResponseEntity<Niveau> createNiveau(@RequestBody Niveau niveau) {
        Niveau newNiveau = niveauService.createNiveau(niveau);
        return ResponseEntity.ok(newNiveau);
    }

    // Récupérer tous les niveaux
    @GetMapping
    public ResponseEntity<List<Niveau>> getAllNiveaux() {
        List<Niveau> niveaux = niveauService.getAllNiveaux();
        return ResponseEntity.ok(niveaux);
    }

    // Récupérer un niveau par ID
    @GetMapping("/{id}")
    public ResponseEntity<Niveau> getNiveauById(@PathVariable Long id) {
        Optional<Niveau> niveau = niveauService.getNiveauById(id);
        return niveau.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Mettre à jour un niveau existant
    @PutMapping("/{id}")
    public ResponseEntity<Niveau> updateNiveau(@PathVariable Long id, @RequestBody Niveau niveauDetails) {
        Niveau updatedNiveau = niveauService.updateNiveau(id, niveauDetails);
        return ResponseEntity.ok(updatedNiveau);
    }

    // Supprimer un niveau par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNiveau(@PathVariable Long id) {
        niveauService.deleteNiveau(id);
        return ResponseEntity.noContent().build();
    }
}
