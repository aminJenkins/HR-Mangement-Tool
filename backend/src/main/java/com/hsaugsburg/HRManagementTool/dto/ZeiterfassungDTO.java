package com.hsaugsburg.HRManagementTool.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ZeiterfassungDTO {
    private int mitarbeiter;
    private int projektID;
    private int kontingentID;
    private String kommentar;
    private double dauer;
    private LocalDateTime datum;
}
