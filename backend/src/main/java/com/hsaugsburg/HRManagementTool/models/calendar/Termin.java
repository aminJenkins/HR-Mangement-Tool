package com.hsaugsburg.HRManagementTool.models.calendar;

import com.hsaugsburg.HRManagementTool.dto.calendar.TerminUpdateDTO;
import com.hsaugsburg.HRManagementTool.dto.mitarbeiter.MitarbeiterDTO;
import com.hsaugsburg.HRManagementTool.models.Priority;
import com.hsaugsburg.HRManagementTool.models.mitarbeiter.Mitarbeiter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor
@Builder
public class Termin {
    private final int id;
    private String titel;
    private String beschreibung;
    private LocalTime beginn;
    private LocalTime ende;
    private Date datum;
    private Set<Integer> teilnehmer;
    private Priority priority;


    public void update(final TerminUpdate update){
        this.beschreibung = update.getBeschreibung();
        this.beginn = update.getBeginn();
        this.ende = update.getEnde();
        this.datum = update.getDatum();
        this.teilnehmer = update.getTeilnehmer();
        this.priority = update.getPriority();
    }


}