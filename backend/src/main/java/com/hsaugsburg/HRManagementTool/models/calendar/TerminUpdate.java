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
public class TerminUpdate {
    private final int id;
    private final String titel;
    private final String beschreibung;
    private final LocalTime beginn;
    private final LocalTime ende;
    private final LocalDate datum;
    private final Set<String> teilnehmer;
    private final Priority priority;
    private final String projekt;
}
