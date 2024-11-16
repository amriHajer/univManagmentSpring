package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.entity.Enseignant;
import com.example.schoolmanagement.entity.User;
import com.example.schoolmanagement.repository.UserRepo;
import com.example.schoolmanagement.service.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/public")
public class EnseignantController {



    @Autowired
    private EnseignantService enseignantService;
    @Autowired
    private UserRepo userRepo;
    @GetMapping("/listEnseignantUsers")
    public ResponseEntity<Object> getAllEnseignantUsers() {
        List<User> enseignantUsers = userRepo.findByRole("ENSEIGNANT");
        if (enseignantUsers.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucun utilisateur avec le rôle Enseignant trouvé");
        } else {
            return ResponseEntity.ok(enseignantUsers);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Enseignant> updateEnseignant(@PathVariable Integer id, @RequestBody Enseignant enseignantDetails) {
        Enseignant updatedEnseignant = enseignantService.updateEnseignant(id, enseignantDetails);
        if (updatedEnseignant != null) {
            return ResponseEntity.ok(updatedEnseignant);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // ou une réponse appropriée
        }
    }


    // Suppression d'un Enseignant par ID
    @DeleteMapping("dltEnseignant/{id}")
    public ResponseEntity<Void> deleteEnseignant(@PathVariable Integer id) {
        enseignantService.deleteEnseignantById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}