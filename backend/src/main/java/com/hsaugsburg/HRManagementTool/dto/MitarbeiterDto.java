package com.hsaugsburg.HRManagementTool.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MitarbeiterDTO {
    private int id;
    private String name;
    private String nachname;
    private String telnr;
    private String email;
    private String anschrift;
    private int abteilung;
}
