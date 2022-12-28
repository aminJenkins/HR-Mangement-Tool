package com.hsaugsburg.HRManagementTool.controller;

import com.hsaugsburg.HRManagementTool.dto.MitarbeiterDto;
import com.hsaugsburg.HRManagementTool.services.mitarbeiter.MitarbeiterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/mitarbeiter")
@RequiredArgsConstructor
public class MitarbeiterController {
    private final MitarbeiterService maService;

    @GetMapping("/")
    ResponseEntity<MitarbeiterDto> getMitarbeiter() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        System.out.println("email: " + email);

        MitarbeiterDto maDto = maService.getMaByEmail(email);

        if (maDto != null) {
            System.out.println("dao nicht null: " + maDto);
            return ResponseEntity.status(HttpStatus.OK).body(maDto);
        }
        System.out.println("dao null");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
