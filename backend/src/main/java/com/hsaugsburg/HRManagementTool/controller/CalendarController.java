package com.hsaugsburg.HRManagementTool.controller;

import com.hsaugsburg.HRManagementTool.dto.calendar.NewTerminDTO;
import com.hsaugsburg.HRManagementTool.dto.calendar.TerminDTO;
import com.hsaugsburg.HRManagementTool.dto.calendar.UpdateTerminDTO;
import com.hsaugsburg.HRManagementTool.services.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calendar")
public class CalendarController {
    private final CalendarService calendarService;

    @Autowired
    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/termin")
    public ResponseEntity<TerminDTO> createNewTermin(@RequestBody @Validated final NewTerminDTO newTerminDTO){
        this.calendarService.createNewTermin(newTerminDTO);
        return null;
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping("/termin")
    public ResponseEntity<UpdateTerminDTO> updateTermin(@RequestBody @Validated final UpdateTerminDTO updateTerminDTO){
        this.calendarService.updateTermin(updateTerminDTO);
        return null;
    }

    @DeleteMapping("/{terminId}")
    public ResponseEntity<Void> deleteTermin(@PathVariable("terminId") final int terminId){
        this.calendarService.deleteTermin(terminId);
        return ResponseEntity.ok().build();
    }




}
