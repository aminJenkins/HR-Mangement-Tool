package com.hsaugsburg.HRManagementTool.controller;

import java.util.Set;

import com.hsaugsburg.HRManagementTool.dto.AngelegteZeiterfassungDTO;
import com.hsaugsburg.HRManagementTool.dto.ZeiterfassungDTO;
import com.hsaugsburg.HRManagementTool.services.TimeTrackingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/timetracking")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class TimeTrackingController {
    @Autowired
    private  TimeTrackingService timeTrackingService;


    @PreAuthorize("hasRole('ROLE_USER') || hasRole('ROLE_ADMIN')")
    @GetMapping("/tracks")
    public ResponseEntity<Set<AngelegteZeiterfassungDTO>> getTimeTracks(Authentication authentication) {
        try {
            return ResponseEntity.ok(timeTrackingService.getTimeTracks(authentication.getName()));
        }catch (Exception exception){
            return ResponseEntity.status(500).body(null);
        }
    }

    @PreAuthorize("hasRole('ROLE_USER') || hasRole('ROLE_ADMIN')")
    @PostMapping("/tracks")
    public ResponseEntity postTimeTrack(Authentication authentication, @RequestBody ZeiterfassungDTO jsonBody) {
        try {
            String mail =authentication.getName();
            timeTrackingService.createTimeTrack(authentication.getName(),jsonBody);
            return ResponseEntity.ok().build();
        }catch (Exception exception){
            return ResponseEntity.status(500).body(exception.getMessage());
        }
    }

    @PreAuthorize("hasRole('ROLE_USER') || hasRole('ROLE_ADMIN')")
    @PutMapping("/tracks")
    public ResponseEntity putTimeTrack(Authentication authentication, @RequestBody AngelegteZeiterfassungDTO jsonBody) {
        try {
            timeTrackingService.updateTimeTrack(authentication.getName(),jsonBody);
            return ResponseEntity.ok().build();
        }catch (Exception exception){
            return ResponseEntity.status(500).body(exception.getMessage());
        }
    }

    @PreAuthorize("hasRole('ROLE_USER') || hasRole('ROLE_ADMIN')")
    @DeleteMapping("/tracks/{id}")
    public ResponseEntity deleteTimeTrack(Authentication authentication,@PathVariable("id") String timeTrackID) {
        try {
            timeTrackingService.deleteTimeTrack(timeTrackID);
            return ResponseEntity.ok().build();
        }catch (Exception exception){
            return ResponseEntity.status(500).body(exception.getMessage());
        }
    }

}
