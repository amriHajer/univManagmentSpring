package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.dto.ModuleRequest;
import com.example.schoolmanagement.entity.Module;
import com.example.schoolmanagement.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public/modules")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @PostMapping
    public ResponseEntity<Module> createModule(@RequestBody ModuleRequest moduleRequest) {
        Module module = moduleService.createModule(moduleRequest);
        return ResponseEntity.ok(module);
    }
}
