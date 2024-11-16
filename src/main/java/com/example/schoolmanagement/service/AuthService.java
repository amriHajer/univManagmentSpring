package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dto.ReqRes;
import com.example.schoolmanagement.entity.Etudiant;
import com.example.schoolmanagement.entity.Enseignant;
import com.example.schoolmanagement.entity.User;
import com.example.schoolmanagement.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AuthService {

    @Autowired
    private UserRepo userRepo;



    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public ReqRes signUp(ReqRes registrationRequest){
        ReqRes resp = new ReqRes();
        try {
            User user;
            if ("ADMIN".equals(registrationRequest.getRole())) {
                user = new User();  // Créer un utilisateur de base pour un admin
                user.setName(registrationRequest.getName());
                user.setEmail(registrationRequest.getEmail());
                user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
                user.setRole("ADMIN");
            } else if ("ETUDIANT".equals(registrationRequest.getRole())) {
                Etudiant etudiant = new Etudiant();
                etudiant.setName(registrationRequest.getName());
                etudiant.setEmail(registrationRequest.getEmail());
                etudiant.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
                etudiant.setRole("ETUDIANT");
                etudiant.setCin(registrationRequest.getCin());
                etudiant.setTel(registrationRequest.getTel());
                etudiant.setDateNaissance(registrationRequest.getDateNaissance());
                etudiant.setImageUrl(registrationRequest.getImageUrl());
                user = etudiant;
            } else if ("ENSEIGNANT".equals(registrationRequest.getRole())) {
                Enseignant enseignant = new Enseignant();
                enseignant.setName(registrationRequest.getName());
                enseignant.setEmail(registrationRequest.getEmail());
                enseignant.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
                enseignant.setRole("ENSEIGNANT");
                enseignant.setDepartement(registrationRequest.getDepartement());
                enseignant.setImageUrl(registrationRequest.getImageUrl());

                user = enseignant;
            } else {
                throw new IllegalArgumentException("Invalid role provided");
            }

            User savedUser = userRepo.save(user);

            if (savedUser != null && savedUser.getId() > 0) {
                resp.setUsers(savedUser);
                resp.setMessage(savedUser.getRole() + " Saved Successfully");
                resp.setStatusCode(200);
            }
        } catch (Exception e) {
            resp.setStatusCode(500);
            resp.setError(e.getMessage());
        }
        return resp;
    }

    // Autres méthodes inchangées...

    public ReqRes signIn(ReqRes signinRequest) {
        ReqRes response = new ReqRes();
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getEmail(), signinRequest.getPassword()));
            User user = userRepo.findByEmail(signinRequest.getEmail()).orElseThrow();
            String jwt = jwtUtils.generateToken(user);
            String refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), user);
            response.setUsers(user);
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRefreshToken(refreshToken);
            response.setExpirationTime("24Hr");
            response.setMessage("Successfully Signed In");
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setError(e.getMessage());
            e.printStackTrace();
        }
        return response;
    }

    public ReqRes refreshToken(ReqRes refreshTokenRequest){
        ReqRes response = new ReqRes();
        String Email = jwtUtils.extractUsername(refreshTokenRequest.getToken());
        User users = userRepo.findByEmail(Email).orElseThrow();
        if (jwtUtils.isTokenValid(refreshTokenRequest.getToken(), users)) {
            var jwt = jwtUtils.generateToken(users);
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRefreshToken(refreshTokenRequest.getToken());
            response.setExpirationTime("24Hr");
            response.setMessage("Successfully Refreshed Token");
        }
        response.setStatusCode(500);
        return response;
    }
}
