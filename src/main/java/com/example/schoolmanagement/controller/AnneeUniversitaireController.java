package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.entity.AnneeUniversitaire;
import com.example.schoolmanagement.service.AnneeUniversitaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/public/annees-universitaires")
public class AnneeUniversitaireController {

    @Autowired
    private AnneeUniversitaireService anneeUniversitaireService;

    // Récupérer toutes les années universitaires
    @GetMapping
    public List<AnneeUniversitaire> getAllAnneesUniversitaires() {
        return anneeUniversitaireService.getAllAnneesUniversitaires();
    }

    // Récupérer une année universitaire par ID
    @GetMapping("/{id}")
    public ResponseEntity<AnneeUniversitaire> getAnneeUniversitaireById(@PathVariable Long id) {
        Optional<AnneeUniversitaire> anneeUniversitaire = anneeUniversitaireService.getAnneeUniversitaireById(id);
        return anneeUniversitaire.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Ajouter ou mettre à jour une année universitaire
    @PostMapping
    public AnneeUniversitaire createAnneeUniversitaire(@RequestBody AnneeUniversitaire anneeUniversitaire) {
        return anneeUniversitaireService.saveAnneeUniversitaire(anneeUniversitaire);
    }

    // Supprimer une année universitaire par ID
    @DeleteMapping("/{id}")
    public void deleteAnneeUniversitaire(@PathVariable Long id) {
        anneeUniversitaireService.deleteAnneeUniversitaire(id);
    }
}
