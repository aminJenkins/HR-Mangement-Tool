package com.hsaugsburg.HRManagementTool.controller;

import com.hsaugsburg.HRManagementTool.dto.MitarbeiterDTO;
import com.hsaugsburg.HRManagementTool.dto.mitarbeiter.CreateEmployeeDTO;
import com.hsaugsburg.HRManagementTool.services.MitarbeiterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class MitarbeiterController {

    @Autowired
    MitarbeiterService maService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/")
    public ResponseEntity<MitarbeiterDTO> getEmployee(Authentication authentication) {
        try {
            return ResponseEntity.ok(maService.getMitarbeiterDTO(authentication.getName()));
        } catch (Exception exception) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/getAll")
    public ResponseEntity<Set<MitarbeiterDTO>> getAllEmployees() {
        try {
            return ResponseEntity.ok(maService.getAllEmaployees());
        } catch (Exception exception) {
            return ResponseEntity.status(500).build();
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<Set<MitarbeiterDTO>> getAllEmployee() {
        return ResponseEntity.ok(maService.getAllEmployees());
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/update")
    public ResponseEntity<MitarbeiterDTO> updateEmployee(@RequestBody MitarbeiterDTO mitarbeiterDTO, Authentication authentication) {
        try {
            maService.checkIsAdminOrCorrectUser(authentication, mitarbeiterDTO.getEmail());
            MitarbeiterDTO m = maService.updateEmployee(mitarbeiterDTO);
            return ResponseEntity.status(HttpStatus.OK).body(m);
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<MitarbeiterDTO> createEmployee(@RequestBody CreateEmployeeDTO createEmployeeDTO) {
        return ResponseEntity.ok(maService.createEmployee(createEmployeeDTO));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") int employeeID) {
        try {
            maService.delete(employeeID);
            return ResponseEntity.ok().build();
        } catch (Exception exception) {
            return ResponseEntity.status(500).body(exception.getMessage());
        }
    }
}
