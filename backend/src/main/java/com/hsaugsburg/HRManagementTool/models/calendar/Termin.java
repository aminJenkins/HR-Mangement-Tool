package com.hsaugsburg.HRManagementTool.models.calendar;

import com.hsaugsburg.HRManagementTool.models.Priority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;
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
    private LocalDate datum;
    private Set<String> teilnehmer;
    private Priority priority;
    private String ersteller;
    private String projekt;


    public void update(final TerminUpdate update) {
        this.titel = update.getTitel();
        this.beschreibung = update.getBeschreibung();
        this.beginn = update.getBeginn();
        this.ende = update.getEnde();
        this.datum = update.getDatum();
        this.teilnehmer = update.getTeilnehmer();
        this.priority = update.getPriority();
        this.projekt = update.getProjekt();
    }


}