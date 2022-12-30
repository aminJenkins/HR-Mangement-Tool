package com.hsaugsburg.HRManagementTool.models.calendar;

import com.hsaugsburg.HRManagementTool.models.Priority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalTime;
import java.util.Date;
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
    private int erstellerId;
    private int projektId;


    public void update(final TerminUpdate update){
        this.titel = update.getTitel();
        this.beschreibung = update.getBeschreibung();
        this.beginn = update.getBeginn();
        this.ende = update.getEnde();
        this.datum = update.getDatum();
        this.teilnehmer = update.getTeilnehmer();
        this.priority = update.getPriority();
        this.projektId = update.getProjektId();
    }


}