package com.hsaugsburg.HRManagementTool.controller;

import com.hsaugsburg.HRManagementTool.dto.MitarbeiterDTO;
import com.hsaugsburg.HRManagementTool.services.MitarbeiterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class MitarbeiterController {

    @Autowired
    MitarbeiterService maService;

    @PreAuthorize("hasRole('ROLE_USER') || hasRole('ROLE_ADMIN')")
    @GetMapping("/")
    public ResponseEntity<MitarbeiterDTO> getEmployee(Authentication authentication) {
        try {
            return ResponseEntity.ok(maService.getMitarbeiterDTO(authentication.getName()));
        }catch (Exception exception){
            return ResponseEntity.status(500).body(null);
        }
    }

    @PreAuthorize("hasRole('ROLE_USER') || hasRole('ROLE_ADMIN')")
    @PostMapping("/")
    public ResponseEntity<String> createEmployee(@RequestBody MitarbeiterDTO mitarbeiterDTO, Authentication authentication) {
        try {
            maService.createMitarbeiter(mitarbeiterDTO);
            return ResponseEntity.ok("Der Mitarbeiter wurde erfolgreich angelegt");
        }catch (Exception exception){
            return ResponseEntity.status(500).body(exception.getMessage());
        }
    }

}
