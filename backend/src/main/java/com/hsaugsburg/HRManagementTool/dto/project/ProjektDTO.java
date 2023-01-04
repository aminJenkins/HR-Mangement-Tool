package com.hsaugsburg.HRManagementTool.dto.project;

import java.util.Set;

import com.hsaugsburg.HRManagementTool.database.entity.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjektDTO {
    private int id;

    private double stundensatz;

    private double budget;

    private int leiterID;

    private String auftragsgeber;

    private String bezeichnung;

    //private Set<TerminEntity> termine;

    private Set<String> projektbeteiligte;

    private Set<Integer> kontingente;

    public ProjektEntity parseToEntity(MitarbeiterEntity leiter, Set<MitarbeiterEntity> beteiligte, Set<KontingentEntity> kontingente) {
        ProjektEntity projektEntity = new ProjektEntity();
        projektEntity.setId(id);
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
