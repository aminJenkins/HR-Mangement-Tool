package com.hsaugsburg.HRManagementTool.controller;

import java.util.Set;

import com.hsaugsburg.HRManagementTool.dto.AbteilungDTO;
import com.hsaugsburg.HRManagementTool.dto.MitarbeiterDTO;
import com.hsaugsburg.HRManagementTool.models.Abteilung;
import com.hsaugsburg.HRManagementTool.services.AbteilungService;
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
@RequestMapping("/api/department")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AbteilungController {
    @Autowired
    AbteilungService abteilungService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/")
    public ResponseEntity<Set<AbteilungDTO>> getEmployee() {
        try {
            return ResponseEntity.ok(abteilungService.getDepartments());
        }catch (Exception exception){
            return ResponseEntity.status(500).build();
        }
    }
}
