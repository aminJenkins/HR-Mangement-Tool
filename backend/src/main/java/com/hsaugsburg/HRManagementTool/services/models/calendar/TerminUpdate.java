package com.hsaugsburg.HRManagementTool.services.models.calendar;

import com.hsaugsburg.HRManagementTool.services.models.Priority;
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
    private final Set<Integer> teilnehmer;
    private final Priority priority;
    private final int projektId;
}
