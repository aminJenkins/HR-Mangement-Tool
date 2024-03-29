package com.hsaugsburg.HRManagementTool.models;

import com.hsaugsburg.HRManagementTool.database.entity.AbteilungEntity;
import com.hsaugsburg.HRManagementTool.database.entity.MitarbeiterEntity;
import com.hsaugsburg.HRManagementTool.database.entity.ZugangEntity;
import com.hsaugsburg.HRManagementTool.dto.MitarbeiterDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor

public class Mitarbeiter {
    private int id;
    private String name;
    private String nachname;
    private AbteilungEntity abteilungenInLeitung;
    private String telnr;
    private String email;
    private String anschrift;
    private AbteilungEntity abteilung;

    public static MitarbeiterDTO mapEntityToDTO(MitarbeiterEntity entity) {
        MitarbeiterDTO dto = new MitarbeiterDTO();
        dto.setAbteilung(entity.getAbteilung().getId());
        dto.setAnschrift(entity.getAnschrift());
        dto.setEmail(entity.getEmail());
        dto.setId(entity.getId());
        dto.setNachname(entity.getNachname());
        dto.setName(entity.getName());
        dto.setTelnr(entity.getTelnr());
        return dto;
    }

    public static MitarbeiterEntity mapDTOToEntity(MitarbeiterDTO dto, AbteilungEntity abteilungEntity, ZugangEntity zugang) {
        MitarbeiterEntity entity = new MitarbeiterEntity();
        entity.setAbteilung(abteilungEntity);
        entity.setAnschrift(dto.getAnschrift());
        entity.setEmail(dto.getEmail());
        entity.setId(dto.getId());
        entity.setNachname(dto.getNachname());
        entity.setName(dto.getName());
        entity.setTelnr(dto.getTelnr());
        return entity;
    }

    public static Set<MitarbeiterDTO> mapEntitiesToDTOs(Set<MitarbeiterEntity> entities) {
        Set<MitarbeiterDTO> dtos = new HashSet<>();
        entities.forEach((e) -> {
            dtos.add(Mitarbeiter.mapEntityToDTO(e));
        });
        return dtos;
    }
}
