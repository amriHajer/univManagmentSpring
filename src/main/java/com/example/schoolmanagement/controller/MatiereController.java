package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.entity.Matiere;
import com.example.schoolmanagement.service.MatiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/matieres")
public class MatiereController {

    @Autowired
    private MatiereService matiereService;

    @GetMapping
    public List<Matiere> getAllMatieres() {
        return matiereService.getAllMatieres();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matiere> getMatiereById(@PathVariable Long id) {
        Matiere matiere = matiereService.getMatiereById(id);
        if (matiere != null) {
            return ResponseEntity.ok(matiere);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Matiere createMatiere(@RequestBody Matiere matiere) {
        return matiereService.createMatiere(matiere);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Matiere> updateMatiere(@PathVariable Long id, @RequestBody Matiere matiere) {
        Matiere updatedMatiere = matiereService.updateMatiere(id, matiere);
        if (updatedMatiere != null) {
            return ResponseEntity.ok(updatedMatiere);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatiere(@PathVariable Long id) {
        matiereService.deleteMatiere(id);
        return ResponseEntity.noContent().build();
    }
}
