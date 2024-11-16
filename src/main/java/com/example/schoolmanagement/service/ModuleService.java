package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dto.ModuleRequest;
import com.example.schoolmanagement.entity.MatiereModule;
import com.example.schoolmanagement.entity.Module;
import com.example.schoolmanagement.entity.Niveau;
import com.example.schoolmanagement.entity.Semestre;
import com.example.schoolmanagement.entity.Specialite;
import com.example.schoolmanagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ModuleService {

    @Autowired
    private ModuleRepo moduleRepository;

    @Autowired
    private SpecialiteRepo specialiteRepository;

    @Autowired
    private NiveauRepo niveauRepository;

    @Autowired
    private SemestreRepo semestreRepository;

    @Autowired
    private MatiereRepo matiereRepository;

    @Transactional
    public Module createModule(ModuleRequest moduleRequest) {
        // Initialiser l'objet Module
        Module module = new Module();
        module.setNomModule(moduleRequest.getNomModule());

        // Récupérer et associer la spécialité
        Optional<Specialite> specialite = specialiteRepository.findById(moduleRequest.getSpecialiteId());
        specialite.ifPresent(module::setSpecialite);

        // Récupérer et associer le niveau
        Optional<Niveau> niveau = niveauRepository.findById(moduleRequest.getNiveauId());
        niveau.ifPresent(module::setNiveau);

        // Récupérer et associer le semestre
        Optional<Semestre> semestre = semestreRepository.findById(moduleRequest.getSemestreId());
        semestre.ifPresent(module::setSemestre);

        // Traiter les matières
        List<MatiereModule> matiereModules = new ArrayList<>();
        for (ModuleRequest.MatiereDTO matiereDTO : moduleRequest.getMatieres()) {
            matiereRepository.findById(matiereDTO.getMatiereId()).ifPresent(matiere -> {
                MatiereModule matiereModule = new MatiereModule();
                matiereModule.setMatiere(matiere);
                matiereModule.setModule(module);
                matiereModule.setCoefficient(matiereDTO.getCoefficient());
                matiereModule.setVolumeHoraire(matiereDTO.getVolumeHoraire());
                matiereModules.add(matiereModule);
            });
        }

        module.setMatiereModules(matiereModules);

        // Sauvegarder le module et les MatiereModules associés
        return moduleRepository.save(module);
    }
}
