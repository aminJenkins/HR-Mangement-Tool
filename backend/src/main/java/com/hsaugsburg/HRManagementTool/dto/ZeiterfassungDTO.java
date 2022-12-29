package com.hsaugsburg.HRManagementTool.dto;

import java.util.Date;

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
    private Date datum;
}
