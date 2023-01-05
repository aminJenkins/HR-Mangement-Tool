package com.hsaugsburg.HRManagementTool.controller;

import java.util.List;
import java.util.Set;

import com.hsaugsburg.HRManagementTool.dto.AngelegteZeiterfassungDTO;
import com.hsaugsburg.HRManagementTool.dto.ArbeitstagDTO;
import com.hsaugsburg.HRManagementTool.dto.ZeiterfassungDTO;
import com.hsaugsburg.HRManagementTool.services.TimeTrackingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
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
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class TimeTrackingController {
    @Autowired
    private  TimeTrackingService timeTrackingService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/tracks")
    public ResponseEntity<String> postTimeTrack(Authentication authentication, @RequestBody ZeiterfassungDTO jsonBody) {
        try {
            String mail =authentication.getName();
            timeTrackingService.createTimeTrack(authentication.getName(),jsonBody);
            return ResponseEntity.ok().build();
        }catch (Exception exception){
            return ResponseEntity.status(500).body(exception.getMessage());
        }
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping("/tracks")
    public ResponseEntity<String>  putTimeTrack(Authentication authentication, @RequestBody AngelegteZeiterfassungDTO jsonBody) {
        try {
            timeTrackingService.updateTimeTrack(authentication.getName(),jsonBody);
            return ResponseEntity.ok().build();
        }catch (Exception exception){
            return ResponseEntity.status(500).body(exception.getMessage());
        }
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/tracks")
    public ResponseEntity<List<ArbeitstagDTO>> getSortedTimeTracks(Authentication authentication) {
        try {
            return ResponseEntity.ok(timeTrackingService.getTimeTracksSortedByDate(authentication.getName()));
        }catch (Exception exception){
            return ResponseEntity.status(500).build();
        }
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @DeleteMapping("/tracks/{id}")
    public ResponseEntity<String>  deleteTimeTrack(Authentication authentication,@PathVariable("id") String timeTrackID) {
        try {
            timeTrackingService.deleteTimeTrack(timeTrackID);
            return ResponseEntity.ok().build();
        }catch (Exception exception){
            return ResponseEntity.status(500).body(exception.getMessage());
        }
    }

}
