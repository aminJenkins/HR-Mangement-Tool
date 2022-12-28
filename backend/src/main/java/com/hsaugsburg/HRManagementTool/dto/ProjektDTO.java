package com.hsaugsburg.HRManagementTool.dto;

import java.util.Set;
import com.hsaugsburg.HRManagementTool.database.entity.KontingentEntity;
import com.hsaugsburg.HRManagementTool.database.entity.MitarbeiterEntity;
import com.hsaugsburg.HRManagementTool.database.entity.TerminEntity;
import com.hsaugsburg.HRManagementTool.database.entity.ZeiterfassungEntity;

public class ProjektDTO {
    private int id;

    private MitarbeiterEntity leiter;

    private Set<ZeiterfassungEntity> zeiterfassungen;

    private Double stundensatz;

    private double budget;

    private String auftragsgeber;

    private String bezeichnung;

    private Set<TerminEntity> termine;

    private KontingentEntity kontingente;

    private Set<MitarbeiterEntity> projektbeteiligte;
}
