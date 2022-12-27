package com.hsaugsburg.HRManagementTool.models.calendar;

import com.hsaugsburg.HRManagementTool.dto.calendar.TerminUpdateDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalTime;
import java.util.Date;

@Getter
@AllArgsConstructor
@Builder
public class Termin {
    private final int id;
    private String beschreibung;
    private LocalTime beginn;
    private LocalTime ende;
    private Date datum;

    public void update(final TerminUpdateDTO update){
        this.beschreibung = update.getBeschreibung();
        this.beginn = update.getBeginn();
        this.ende = update.getEnde();
        this.datum = update.getDatum();
    }
}