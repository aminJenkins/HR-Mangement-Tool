package com.hsaugsburg.HRManagementTool.dto;

import com.hsaugsburg.HRManagementTool.database.entity.Mitarbeiter;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MitarbeiterDto {
    private String name;
    private String nachName;
    private String email;
    private String telnr;
    private String anschrift;

    public MitarbeiterDto(Mitarbeiter ma) {
        this.name = ma.getName();
        nachName = ma.getNachname();
        email = ma.getEmail();
        telnr = ma.getTelnr();
        anschrift = ma.getAnschrift();
    }
}
