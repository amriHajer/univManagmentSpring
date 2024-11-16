package com.example.schoolmanagement.dto;

import com.example.schoolmanagement.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.repository.query.parser.Part;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReqRes {

    private int statusCode ;
    private String error;
    private String message;
    private String token;
    private String refreshToken;
    private String expirationTime;
    private String name ;
    //private  String prenom ;
    private String email ;
    private String password;
    private String role ;
    private String imageUrl; //
    private User Users ;
    private String departement;
    private List<User> userList ;
    /*********************/
    private String cin ;
    private String tel ;
    private String NomSalle ;
    private  String typeSalle ;


    //private Date dateNaissance;

    private LocalDate dateNaissance;

    //private String nomFiliere;
    private String nomSpecialite;
    private String cycle ;
    private String nomNiveau;
    private String nomMatiere;
    private String nomModule ;
    private Integer ECTS;
    private String nomClasse;
    private String nomSemestre ;
    private String nomAnnee ;
    private LocalDateTime debutSeance;
    private LocalDateTime finSeance;
    private DayOfWeek jourSeance;

}
