package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.entity.Etudiant;
import com.example.schoolmanagement.entity.User;
import com.example.schoolmanagement.repository.UserRepo;
import com.example.schoolmanagement.service.EnseignantService;
import com.example.schoolmanagement.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public")
public class EtudiantController {



    @Autowired
    private EtudiantService etudiantService;
    @Autowired
    private UserRepo userRepo;
    @GetMapping("/listEtudiantUsers")
    public ResponseEntity<Object> getAllEtudiantUsers() {
        List<User> etudiantUsers = userRepo.findByRole("ETUDIANT");
        if (etudiantUsers.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucun utilisateur avec le rôle CANDIDAT trouvé");
        } else {
            return ResponseEntity.ok(etudiantUsers);
        }
    }




    @GetMapping("/classe/{classeId}")
    public ResponseEntity<List<Etudiant>> getEtudiantsByClasse(@PathVariable Long classeId) {
        List<Etudiant> etudiants = etudiantService.getEtudiantsByClasseId(classeId);
        return ResponseEntity.ok(etudiants);
    }

    // Suppression d'un Etudiant par ID
    @DeleteMapping("dltEtudiant/{id}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable Integer id) {
        etudiantService.deleteEtudiantById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}