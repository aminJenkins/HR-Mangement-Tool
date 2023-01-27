package com.hsaugsburg.HRManagementTool.controller;

import com.hsaugsburg.HRManagementTool.dto.authentication.AuthenticationRequest;
import com.hsaugsburg.HRManagementTool.dto.authentication.AuthenticationResponse;
import com.hsaugsburg.HRManagementTool.dto.authentication.PasswortResetDTO;
import com.hsaugsburg.HRManagementTool.services.ZugangsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final ZugangsService zugangsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<Object> authenticate(@RequestBody AuthenticationRequest request) {
        //checks if user is in db with correct password
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        //generates token for user
        final String token = zugangsService.generateTokenForUser(request.getEmail());
        if (token != null) {
            return ResponseEntity.ok(new AuthenticationResponse(token));
        } else {
            return ResponseEntity.status(401).body("Could not find user");
        }
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/pw_reset")
    public ResponseEntity<String> resetPassword(@RequestBody PasswortResetDTO passwortResetDTO, Authentication authentication) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authentication.getName(), passwortResetDTO.getOldPassword())
        );
        String encodedPassword = passwordEncoder.encode(passwortResetDTO.getConfirmPassword());
        zugangsService.resetPassword(passwortResetDTO, authentication.getName(), encodedPassword);
        return ResponseEntity.status(200).build();
    }
}
