package com.hsaugsburg.HRManagementTool.dto;

import java.util.Set;

import com.hsaugsburg.HRManagementTool.database.entity.AbteilungEntity;
import com.hsaugsburg.HRManagementTool.database.entity.ProjektEntity;
import com.hsaugsburg.HRManagementTool.database.entity.TerminEntity;
import com.hsaugsburg.HRManagementTool.database.entity.ZeiterfassungEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class MitarbeiterDTO {
    private int id;
    private String name;
    private String nachname;
    private AbteilungEntity abteilungenInLeitung;
    private String telnr;
    private String email;
    private String anschrift;
    private Set<ProjektEntity> projekteInFuehrung;
    private Set<ZeiterfassungEntity> zeiterfassungen;
    private Set<TerminEntity> termine;
    private Set<ProjektEntity> projekte;
    private AbteilungEntity abteilung;
}
