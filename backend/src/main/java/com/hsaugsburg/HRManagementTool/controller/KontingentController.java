package com.hsaugsburg.HRManagementTool.controller;

import com.hsaugsburg.HRManagementTool.services.KontingentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contingent")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class KontingentController {

    @Autowired
    KontingentService kontingentService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/")
    public ResponseEntity<String> getContingents() {
        try {
            return ResponseEntity.ok(kontingentService.getContingents());
        } catch (Exception exception) {
            return ResponseEntity.status(500).body(exception.getMessage());
        }
    }
}
