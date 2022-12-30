package com.hsaugsburg.HRManagementTool.controller;

import com.hsaugsburg.HRManagementTool.dto.calendar.NewTerminDTO;
import com.hsaugsburg.HRManagementTool.dto.calendar.TerminDTO;
import com.hsaugsburg.HRManagementTool.dto.calendar.TerminUpdateDTO;
import com.hsaugsburg.HRManagementTool.mapper.calendar.CalendarApiMapper;
import com.hsaugsburg.HRManagementTool.services.models.calendar.Termin;
import com.hsaugsburg.HRManagementTool.services.CalendarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/calendar")
public class CalendarController {
    private final CalendarService calendarService;
    private final CalendarApiMapper calendarApiMapper;

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/termin")
    public ResponseEntity<TerminDTO> createNewTermin(@RequestBody @Valid final NewTerminDTO newTerminDTO,Authentication authentication ){
        Termin newTermin = this.calendarService.createNewTermin(this.calendarApiMapper.map(newTerminDTO),authentication);
        return ResponseEntity.ok(this.calendarApiMapper.map(newTermin));
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping("/termin")
    public ResponseEntity<TerminDTO> updateTermin(@RequestBody @Valid final TerminUpdateDTO terminUpdateDTO, Authentication authentication){
        Termin updatedTermin = this.calendarService.updateTermin(this.calendarApiMapper.map(terminUpdateDTO),authentication);
        return ResponseEntity.ok(this.calendarApiMapper.map(updatedTermin));
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @DeleteMapping("/termin/{terminId}")
    public ResponseEntity<Void> deleteTermin(@PathVariable("terminId") final int terminId,Authentication authentication){
        this.calendarService.deleteTermin(terminId,authentication);
        return ResponseEntity.ok().build();
    }




}
