package com.hsaugsburg.HRManagementTool.models.calendar;

import com.hsaugsburg.HRManagementTool.models.Priority;
import com.hsaugsburg.HRManagementTool.models.mitarbeiter.Mitarbeiter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalTime;
import java.util.Date;
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
    private final Date datum;
    private final Set<Mitarbeiter> teilnehmer;
    private final Priority priority;
}
