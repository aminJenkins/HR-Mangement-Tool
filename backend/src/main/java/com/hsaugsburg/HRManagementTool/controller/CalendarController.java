package com.hsaugsburg.HRManagementTool.controller;

import com.hsaugsburg.HRManagementTool.dto.calendar.NewTerminDTO;
import com.hsaugsburg.HRManagementTool.dto.calendar.TerminDTO;
import com.hsaugsburg.HRManagementTool.dto.calendar.TerminUpdateDTO;
import com.hsaugsburg.HRManagementTool.mapper.calendar.CalendarApiMapper;
import com.hsaugsburg.HRManagementTool.mapper.calendar.CalendarMapper;
import com.hsaugsburg.HRManagementTool.models.calendar.Termin;
import com.hsaugsburg.HRManagementTool.services.CalendarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/calendar")
public class CalendarController {
    private final CalendarService calendarService;
    private final CalendarApiMapper calendarApiMapper;

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/termin")
    public ResponseEntity<TerminDTO> createNewTermin(@RequestBody @Validated final NewTerminDTO newTerminDTO){
        Termin newTermin = this.calendarService.createNewTermin(this.calendarApiMapper.map(newTerminDTO));
        return ResponseEntity.ok(this.calendarApiMapper.map(newTermin));
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping("/termin")
    public ResponseEntity<TerminUpdateDTO> updateTermin(@RequestBody @Validated final TerminUpdateDTO terminUpdateDTO){
        this.calendarService.updateTermin(terminUpdateDTO);
        return null;
    }

    @DeleteMapping("/{terminId}")
    public ResponseEntity<Void> deleteTermin(@PathVariable("terminId") final int terminId){
        this.calendarService.deleteTermin(terminId);
        return ResponseEntity.ok().build();
    }




}
