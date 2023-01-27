package com.hsaugsburg.HRManagementTool.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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
