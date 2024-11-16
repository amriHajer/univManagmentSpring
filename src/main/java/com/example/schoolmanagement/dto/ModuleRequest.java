package com.example.schoolmanagement.dto;

import java.util.List;

public class ModuleRequest {
    private String nomModule;
    private Long specialiteId;
    private Long niveauId;
    private Long semestreId;
    private List<MatiereDTO> matieres;

    // Getters et Setters
    public String getNomModule() {
        return nomModule;
    }

    public void setNomModule(String nomModule) {
        this.nomModule = nomModule;
    }

    public Long getSpecialiteId() {
        return specialiteId;
    }

    public void setSpecialiteId(Long specialiteId) {
        this.specialiteId = specialiteId;
    }

    public Long getNiveauId() {
        return niveauId;
    }

    public void setNiveauId(Long niveauId) {
        this.niveauId = niveauId;
    }

    public Long getSemestreId() {
        return semestreId;
    }

    public void setSemestreId(Long semestreId) {
        this.semestreId = semestreId;
    }

    public List<MatiereDTO> getMatieres() {
        return matieres;
    }

    public void setMatieres(List<MatiereDTO> matieres) {
        this.matieres = matieres;
    }

    public static class MatiereDTO {
        private Long matiereId;
        private int coefficient;
        private int volumeHoraire;

        // Getters et Setters
        public Long getMatiereId() {
            return matiereId;
        }

        public void setMatiereId(Long matiereId) {
            this.matiereId = matiereId;
        }

        public int getCoefficient() {
            return coefficient;
        }

        public void setCoefficient(int coefficient) {
            this.coefficient = coefficient;
        }

        public int getVolumeHoraire() {
            return volumeHoraire;
        }

        public void setVolumeHoraire(int volumeHoraire) {
            this.volumeHoraire = volumeHoraire;
        }
    }
}
