package com.hsaugsburg.HRManagementTool.dto.mitarbeiter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateEmployeeDTO {
    String email;
    String name;
    String nachname;
    String anschrift;
    String telnr;
    int abteilung;
    String password;
    String authority;
}
