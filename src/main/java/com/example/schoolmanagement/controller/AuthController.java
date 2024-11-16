package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.dto.ReqRes;
import com.example.schoolmanagement.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // Injecter le chemin de sauvegarde à partir de application.properties
    @Value("${file.upload-dir}")
    private String uploadDir;

//    @PostMapping("/signup")
//    public ResponseEntity<ReqRes> signUp(@RequestBody ReqRes signUpRequest){
//        return ResponseEntity.ok(authService.signUp(signUpRequest));
//    }

    @PostMapping("/signup")
    public ResponseEntity<ReqRes> signUp(@RequestParam("file") MultipartFile file, @ModelAttribute ReqRes signUpRequest) {
        try {
            // Sauvegarde de l'image et obtention de l'URL de l'image
            String imageUrl = saveFile(file);
            signUpRequest.setImageUrl(imageUrl); // Associer l'URL de l'image au DTO

            // Appel du service d'inscription avec l'image
            return ResponseEntity.ok(authService.signUp(signUpRequest));
        } catch (Exception e) {
            ReqRes response = new ReqRes();
            response.setMessage("Échec de la création d'utilisateur avec image.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    private String saveFile(MultipartFile file) throws IOException {
        Path directoryPath = Paths.get(uploadDir);

        if (!Files.exists(directoryPath)) {
            Files.createDirectories(directoryPath);
        }

        Path path = directoryPath.resolve(file.getOriginalFilename());
        Files.write(path, file.getBytes());

        //return path.toString(); // Retourner le chemin de l'image sauvegardée
        return path.toString().replace("\\", "/");
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("No file uploaded");
        }
        // Logic to handle the file
        return ResponseEntity.ok("File uploaded successfully");
    }

    /**********************************/

    @PostMapping("/signin")
    public ResponseEntity<ReqRes> signIn(@RequestBody ReqRes signInRequest){
        return ResponseEntity.ok(authService.signIn(signInRequest));
    }


    @GetMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) {
        // Récupère l'objet Authentication de l'utilisateur actuellement authentifié
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) { // Vérifie si un utilisateur est authentifié
            // Déconnecte l'utilisateur en utilisant un SecurityContextLogoutHandler
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        // Retourne une réponse HTTP 200 OK avec un message de déconnexion réussie
        return ResponseEntity.ok().body("Déconnexion réussie !");

    }




    @PostMapping("/refresh")
    public ResponseEntity<ReqRes> refreshToken(@RequestBody ReqRes refreshTokenRequest){
        return ResponseEntity.ok(authService.refreshToken(refreshTokenRequest));
    }
}








