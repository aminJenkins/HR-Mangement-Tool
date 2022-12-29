package com.hsaugsburg.HRManagementTool.dto.calendar;

import com.hsaugsburg.HRManagementTool.dto.mitarbeiter.MitarbeiterDTO;
import com.hsaugsburg.HRManagementTool.models.Priority;
import com.hsaugsburg.HRManagementTool.models.mitarbeiter.Mitarbeiter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalTime;
import java.util.Date;
import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
public class TerminDTO {
    @NotNull
    private int id;

    @NotNull
    private String titel;

    private String beschreibung;

    @NotNull
    private LocalTime beginn;

    @NotNull
    private LocalTime ende;

    @NotNull
    private Priority priority;

    @NotNull
    private Date datum;

    @NotNull
    private Set<MitarbeiterDTO> teilnehmer;

}
