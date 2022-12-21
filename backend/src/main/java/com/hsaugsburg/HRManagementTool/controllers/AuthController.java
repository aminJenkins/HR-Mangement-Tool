package com.hsaugsburg.HRManagementTool.controllers;

import com.hsaugsburg.HRManagementTool.config.JwtUtils;
import com.hsaugsburg.HRManagementTool.database.DAO.UserDao;
import com.hsaugsburg.HRManagementTool.dto.AuthenticationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserDao userDao;
    private final JwtUtils jwtUtils;

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
       final UserDetails user = userDao.findUserByEmail(request.getEmail());
       if (user != null) {
           return ResponseEntity.ok(jwtUtils.generateToken(user));
       }
       return ResponseEntity.status(401).body("");
    }
}
