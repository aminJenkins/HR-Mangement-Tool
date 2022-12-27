package com.hsaugsburg.HRManagementTool.controller;

import com.hsaugsburg.HRManagementTool.services.TimeTrackingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/timetracking")
@RequiredArgsConstructor
public class TimeTrackingController {
    @Autowired
    private  TimeTrackingService timeTrackingService;
    @PreAuthorize("hasRole('ROLE_USER') && hasRole('ROLE_ADMIN')")
    @GetMapping("/tracks")
    public ResponseEntity<String> getTimeTracks(Authentication authentication) {
        try {
            System.out.println(authentication.getName());
            return ResponseEntity.ok(timeTrackingService.getparsedTimeTrackJson(1));
        }catch (Exception exception){
            return ResponseEntity.status(500).body(exception.getMessage());
        }
    }
}
