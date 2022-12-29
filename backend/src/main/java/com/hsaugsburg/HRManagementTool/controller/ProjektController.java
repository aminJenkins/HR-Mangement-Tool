package com.hsaugsburg.HRManagementTool.controller;

import java.util.Set;

import com.hsaugsburg.HRManagementTool.dto.ProjektDTO;
import com.hsaugsburg.HRManagementTool.services.ProjektService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ProjektController {

    @Autowired
    ProjektService projektService;

    @PreAuthorize("hasRole('ROLE_USER') || hasRole('ROLE_ADMIN')")
    @GetMapping("/")
    public ResponseEntity<Set<ProjektDTO>> getProjects(Authentication authentication) {
        try {
            return ResponseEntity.ok(projektService.getProjektDTOs(authentication.getName()));
        }catch (Exception exception){
            return ResponseEntity.status(500).body(null);
        }
    }
}
