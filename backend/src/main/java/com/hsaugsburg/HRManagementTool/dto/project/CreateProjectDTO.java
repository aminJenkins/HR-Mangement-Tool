package com.hsaugsburg.HRManagementTool.dto.project;

import com.hsaugsburg.HRManagementTool.database.entity.KontingentEntity;
import com.hsaugsburg.HRManagementTool.database.entity.MitarbeiterEntity;
import com.hsaugsburg.HRManagementTool.database.entity.ProjektEntity;
import com.hsaugsburg.HRManagementTool.dto.KontingentDTO;
import com.hsaugsburg.HRManagementTool.dto.MitarbeiterDTO;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CreateProjectDTO {
    @NonNull
    private double stundensatz;
    @NonNull
    private double budget;
    @NonNull
    private int leiterID;
    private String auftragsgeber;
    private String bezeichnung;
    private Set<String> projektbeteiligte;
    private Set<Integer> kontingente;

    public  ProjektEntity parseToEntity(MitarbeiterEntity leiter, Set<MitarbeiterEntity> beteiligte, Set<KontingentEntity> kontingente) {
        ProjektEntity projektEntity = new ProjektEntity();
        projektEntity.setStundensatz(stundensatz);
        projektEntity.setBudget(budget);
        projektEntity.setAuftragsgeber(auftragsgeber);
        projektEntity.setBezeichnung(bezeichnung);
        projektEntity.setLeiter(leiter);
        projektEntity.setProjektbeteiligte(beteiligte);
        projektEntity.setKontingente(kontingente);

        return projektEntity;
    }
}


