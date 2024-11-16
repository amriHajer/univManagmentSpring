package com.example.schoolmanagement.service;

import com.example.schoolmanagement.entity.Semestre;
import com.example.schoolmanagement.repository.SemestreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SemestreService {

    @Autowired
    private SemestreRepo semestreRepository;

    public Semestre save(Semestre semestre) {
        return semestreRepository.save(semestre);
    }

    public List<Semestre> findAll() {
        return semestreRepository.findAll();
    }

    public Optional<Semestre> findById(Long id) {
        return semestreRepository.findById(id);
    }

    public void deleteById(Long id) {
        semestreRepository.deleteById(id);
    }
}