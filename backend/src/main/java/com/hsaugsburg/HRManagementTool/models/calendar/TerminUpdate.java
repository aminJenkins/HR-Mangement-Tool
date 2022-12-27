package com.hsaugsburg.HRManagementTool.models.calendar;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalTime;
import java.util.Date;
@Getter
@AllArgsConstructor
public class TerminUpdate {
    private final int id;
    private final String beschreibung;
    private final LocalTime beginn;
    private final LocalTime ende;
    private final Date datum;


}
