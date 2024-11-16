package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.entity.Semestre;
import com.example.schoolmanagement.service.SemestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/semestres")
public class SemestreController {

    @Autowired
    private SemestreService semestreService;

    @PostMapping
    public ResponseEntity<Semestre> createSemestre(@RequestBody Semestre semestre) {
        Semestre savedSemestre = semestreService.save(semestre);
        return new ResponseEntity<>(savedSemestre, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Semestre>> getAllSemestres() {
        List<Semestre> semestres = semestreService.findAll();
        return new ResponseEntity<>(semestres, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Semestre> getSemestreById(@PathVariable Long id) {
        return semestreService.findById(id)
                .map(semestre -> new ResponseEntity<>(semestre, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSemestre(@PathVariable Long id) {
        semestreService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
