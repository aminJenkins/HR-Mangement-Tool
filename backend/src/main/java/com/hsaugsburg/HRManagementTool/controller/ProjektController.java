package com.hsaugsburg.HRManagementTool.controller;

import java.util.Set;

import com.hsaugsburg.HRManagementTool.dto.project.CreateProjectDTO;
import com.hsaugsburg.HRManagementTool.dto.project.ProjektDTO;
import com.hsaugsburg.HRManagementTool.services.ProjektService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class ProjektController {

    @Autowired
    ProjektService projektService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/")
    public ResponseEntity<Set<ProjektDTO>> getProjects(Authentication authentication) {
        try {
            return ResponseEntity.ok(projektService.getProjektDTOs(authentication.getName()));
        }catch (Exception exception){
            return ResponseEntity.status(500).body(null);
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/")
    public ResponseEntity<ProjektDTO> createProject(@RequestBody CreateProjectDTO createProjectDto) {
            projektService.createProject(createProjectDto);
            return ResponseEntity.ok().build();
    }
}
