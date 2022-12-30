package com.hsaugsburg.HRManagementTool.controller;

import com.hsaugsburg.HRManagementTool.dto.AuthenticationRequest;
import com.hsaugsburg.HRManagementTool.dto.AuthenticationResponse;
import com.hsaugsburg.HRManagementTool.services.ZugangsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final ZugangsService zugangsService;

    @PostMapping("/login")
    public ResponseEntity<Object> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        //checks if user is in db with correct password
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        //generates token for user
        final String token = zugangsService.generateTokenForUser(request.getEmail());
        if (token != null) {
            System.out.println("token: "+ token);

            return ResponseEntity.ok(new AuthenticationResponse(token));
        } else {
            return ResponseEntity.status(401).body("Could not find user");
        }
    }
}
