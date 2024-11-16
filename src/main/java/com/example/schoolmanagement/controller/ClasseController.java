package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.entity.Classe;
import com.example.schoolmanagement.service.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/classes")
public class ClasseController {

    @Autowired
    private ClasseService classeService;

    // Endpoint pour obtenir toutes les classes
    @GetMapping
    public List<Classe> getAllClasses() {
        return classeService.getAllClasses();
    }

    // Endpoint pour obtenir une classe par ID
    @GetMapping("/{id}")
    public ResponseEntity<Classe> getClasseById(@PathVariable Long id) {
        Classe classe = classeService.getClasseById(id);
        return ResponseEntity.ok(classe);
    }

    // Endpoint pour ajouter une nouvelle classe
    @PostMapping
    public ResponseEntity<Classe> addClasse(@RequestBody Classe classe) {
        Classe newClasse = classeService.addClasse(classe);
        return new ResponseEntity<>(newClasse, HttpStatus.CREATED);
    }

    // Endpoint pour mettre à jour une classe
    @PutMapping("/{id}")
    public ResponseEntity<Classe> updateClasse(@PathVariable Long id, @RequestBody Classe classeDetails) {
        Classe updatedClasse = classeService.updateClasse(id, classeDetails);
        return ResponseEntity.ok(updatedClasse);
    }

    // Endpoint pour supprimer une classe
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClasse(@PathVariable Long id) {
        classeService.deleteClasse(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint pour rechercher des classes par nom
    @GetMapping("/search/nom")
    public ResponseEntity<List<Classe>> getClassesByNom(@RequestParam String nomClasse) {
        List<Classe> classes = classeService.getClassesByNom(nomClasse);
        return ResponseEntity.ok(classes);
    }

    // Endpoint pour rechercher des classes par ID de spécialité
    @GetMapping("/search/specialite/{specialiteId}")
    public ResponseEntity<List<Classe>> getClassesBySpecialite(@PathVariable Long specialiteId) {
        List<Classe> classes = classeService.getClassesBySpecialiteId(specialiteId);
        return ResponseEntity.ok(classes);
    }
}
