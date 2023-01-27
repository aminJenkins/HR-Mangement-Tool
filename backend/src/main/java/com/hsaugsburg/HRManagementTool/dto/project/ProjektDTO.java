package com.hsaugsburg.HRManagementTool.dto.project;

import com.hsaugsburg.HRManagementTool.database.entity.KontingentEntity;
import com.hsaugsburg.HRManagementTool.database.entity.MitarbeiterEntity;
import com.hsaugsburg.HRManagementTool.database.entity.ProjektEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class ProjektDTO {
    private int id;

    private double stundensatz;

    private double budget;

    private int leiterID;

    private String auftragsgeber;

    private String bezeichnung;


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

    public static ProjektDTO parseFromEntity(ProjektEntity entity) {
        ProjektDTO dto = new ProjektDTO();
        dto.setId(entity.getId());
        dto.setAuftragsgeber(entity.getAuftragsgeber());
        dto.setBezeichnung(entity.getBezeichnung());
        dto.setLeiterID(entity.getLeiter().getId());
        dto.setBudget(entity.getBudget());
        dto.setStundensatz(entity.getStundensatz());
        dto.setProjektbeteiligte(entity.getProjektbeteiligte().stream().map(MitarbeiterEntity::getEmail).collect(Collectors.toSet()));
        dto.setKontingente(entity.getKontingente().stream().map(KontingentEntity::getId).collect(Collectors.toSet()));
        return dto;
    }

    public static List<ProjektDTO> parseFromEntities(List<ProjektEntity> entities) {
        return entities.stream().map(ProjektDTO::parseFromEntity
        ).collect(Collectors.toList());
    }
}
