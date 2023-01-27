package com.hsaugsburg.HRManagementTool.controller;

import com.hsaugsburg.HRManagementTool.dto.ZugangDTO;
import com.hsaugsburg.HRManagementTool.services.ZugangsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/zugang")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ZugangsController {

    @Autowired
    ZugangsService zugangsService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/")
    public ResponseEntity createZugang(@RequestBody ZugangDTO zugangDTO) {
        try {
            zugangsService.createZugang(zugangDTO);
            return ResponseEntity.ok().build();
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }
}
