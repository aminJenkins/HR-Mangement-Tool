package com.hsaugsburg.HRManagementTool.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class MitarbeiterDTO {
    private int id;
    private String name;
    private String nachname;
    private String telnr;
    private String email;
    private String anschrift;
    private int abteilung;
}
