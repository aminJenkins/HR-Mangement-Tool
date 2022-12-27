package com.hsaugsburg.HRManagementTool.dto.calendar;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NewTerminDTO {

    @NotNull
    private String betreff;

    @NotNull
    private String beschreibung;

    @NotNull
    private LocalTime beginn;

    @NotNull
    private LocalTime ende;

    @NotNull
    private Date datum;

}
