package com.hsaugsburg.HRManagementTool.dto.calendar;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TerminUpdateDTO {

    @NotNull
    private int id;

    private String beschreibung;

    @NotNull
    private LocalTime beginn;

    @NotNull
    private LocalTime ende;

    @NotNull
    private Date datum;

}
