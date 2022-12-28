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
    private Set<ProjektEntity> projekteInFuehrung;
    private Set<ZeiterfassungEntity> zeiterfassungen;
    private Set<TerminEntity> termine;
    private Set<ProjektEntity> projekte;
    private AbteilungEntity abteilung;

    public static MitarbeiterDTO mapEntityToDTO(MitarbeiterEntity entity) {
        MitarbeiterDTO dto = new MitarbeiterDTO();
        dto.setAbteilung(entity.getAbteilung());
        dto.setAbteilungenInLeitung(entity.getAbteilungenInLeitung());
        dto.setAbteilung(entity.getAbteilung());
        dto.setAnschrift(entity.getAnschrift());
        dto.setEmail(entity.getEmail());
        dto.setId(entity.getId());
        dto.setNachname(entity.getNachname());
        dto.setName(entity.getName());
        dto.setProjekte(entity.getProjekte());
        dto.setProjekteInFuehrung(entity.getProjekteInFuehrung());
        dto.setTelnr(entity.getTelnr());
        dto.setTermine(entity.getTermine());
        dto.setZeiterfassungen(entity.getZeiterfassungen());
        return dto;
    }

    public static MitarbeiterEntity mapDTOToEntity(MitarbeiterDTO dto) {
        MitarbeiterEntity entity = new MitarbeiterEntity();
        entity.setAbteilung(dto.getAbteilung());
        entity.setAbteilungenInLeitung(dto.getAbteilungenInLeitung());
        entity.setAbteilung(dto.getAbteilung());
        entity.setAnschrift(dto.getAnschrift());
        entity.setEmail(dto.getEmail());
        entity.setId(dto.getId());
        entity.setNachname(dto.getNachname());
        entity.setName(dto.getName());
        entity.setProjekte(dto.getProjekte());
        entity.setProjekteInFuehrung(dto.getProjekteInFuehrung());
        entity.setTelnr(dto.getTelnr());
        entity.setTermine(dto.getTermine());
        entity.setZeiterfassungen(dto.getZeiterfassungen());
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
