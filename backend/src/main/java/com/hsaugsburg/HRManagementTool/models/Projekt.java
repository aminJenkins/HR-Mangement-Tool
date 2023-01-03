package com.hsaugsburg.HRManagementTool.models;

import java.util.HashSet;
import java.util.Set;

import com.hsaugsburg.HRManagementTool.database.entity.ProjektEntity;
import com.hsaugsburg.HRManagementTool.dto.project.ProjektDTO;

public class Projekt {
    public static Set<ProjektDTO> parseEntitiesToDTOs(Set<ProjektEntity> entities){
        Set<ProjektDTO> dtos = new HashSet<>();
        entities.forEach(projektEntity -> {
            dtos.add(parseEntityToDTO(projektEntity));
        });
        return dtos;
    }
    public static ProjektDTO parseEntityToDTO(ProjektEntity entity){
        ProjektDTO dto = new ProjektDTO();
        dto.setId(entity.getId());
        dto.setAuftragsgeber(entity.getAuftragsgeber());
        dto.setBezeichnung(entity.getBezeichnung());
        dto.setLeiterID(entity.getLeiter().getId());
        Set<String> beteiligte = new HashSet<>();
        entity.getProjektbeteiligte().forEach(beteiligter->{beteiligte.add(beteiligter.getName()+" "+ beteiligter.getNachname());});
        dto.setProjektbeteiligte(beteiligte);
        return dto;
    }

}
