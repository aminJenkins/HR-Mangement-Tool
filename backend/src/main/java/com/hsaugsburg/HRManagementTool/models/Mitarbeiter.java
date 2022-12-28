package com.hsaugsburg.HRManagementTool.models;

import java.util.HashSet;
import java.util.Set;

import com.hsaugsburg.HRManagementTool.database.entity.AbteilungEntity;
import com.hsaugsburg.HRManagementTool.database.entity.MitarbeiterEntity;
import com.hsaugsburg.HRManagementTool.database.entity.ProjektEntity;
import com.hsaugsburg.HRManagementTool.database.entity.TerminEntity;
import com.hsaugsburg.HRManagementTool.database.entity.ZeiterfassungEntity;
import com.hsaugsburg.HRManagementTool.dto.MitarbeiterDTO;
import com.hsaugsburg.HRManagementTool.dto.ZeiterfassungDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
        return dto;
    }

    public static MitarbeiterEntity mapDTOToEntity(MitarbeiterDTO dto) {
        MitarbeiterEntity entity = new MitarbeiterEntity();
//        entity.setAbteilung(dto.getAbteilung());
//        entity.setAbteilung(dto.getAbteilung());
        entity.setAnschrift(dto.getAnschrift());
        entity.setEmail(dto.getEmail());
        entity.setId(dto.getId());
        entity.setNachname(dto.getNachname());
        entity.setName(dto.getName());
        return entity;
    }

    public static Set<MitarbeiterDTO> parseEntitiestoDTOs(Set<MitarbeiterEntity> entities) {
        Set<MitarbeiterDTO> dtos = new HashSet<>();
        entities.forEach((e) -> {
            dtos.add(Mitarbeiter.mapEntityToDTO(e));
        });
        return dtos;
    }

    public static Set<MitarbeiterDTO> parseDTOsToEntyties(Set<MitarbeiterDTO> dtos) {
        Set<MitarbeiterEntity> entities = new HashSet<>();
        dtos.forEach((e) -> {
            entities.add(Mitarbeiter.mapDTOToEntity(e));
        });
        return dtos;
    }
}
