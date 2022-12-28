package com.hsaugsburg.HRManagementTool.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.hsaugsburg.HRManagementTool.database.entity.KontingentEntity;
import com.hsaugsburg.HRManagementTool.database.entity.ProjektEntity;
import com.hsaugsburg.HRManagementTool.database.entity.ZeiterfassungEntity;
import com.hsaugsburg.HRManagementTool.dto.KontingentDTO;
import com.hsaugsburg.HRManagementTool.dto.MitarbeiterDTO;
import com.hsaugsburg.HRManagementTool.dto.ProjektDTO;
import com.hsaugsburg.HRManagementTool.dto.ZeiterfassungDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
public class Zeiterfassung {
    private int id;
    private MitarbeiterDTO mitarbeiter;
    private Set<ProjektDTO> projekte;
    private Set<KontingentDTO> kontingente;
    private String kommentar;
    private double dauer;
    private Date datum;

    public static ZeiterfassungDTO mapEntityToDTO(ZeiterfassungEntity entity){
        ZeiterfassungDTO dto = new ZeiterfassungDTO();
        if(entity.getProjekt()!=null){
            dto.setProjektID(entity.getProjekt().getId());
        }
        if(entity.getKontingent()!=null){
            dto.setKontingentID(entity.getKontingent().getId());
        }
        dto.setKommentar(entity.getKommentar());
        dto.setId(entity.getId());
        dto.setDauer(entity.getDauer());
        dto.setDatum(entity.getDatum());
        dto.setMitarbeiter(entity.getMitarbeiter());
        return dto;
    }

    public static ZeiterfassungEntity mapDTOToEntity(ZeiterfassungDTO dto, ProjektEntity projektEntity,KontingentEntity kontingentEntity){
        ZeiterfassungEntity entity = new ZeiterfassungEntity();
        entity.setProjekt(projektEntity);
        entity.setKontingent(kontingentEntity);
        entity.setKommentar(dto.getKommentar());
        entity.setId(dto.getId());
        entity.setDauer(dto.getDauer());
        entity.setDatum(dto.getDatum());
        entity.setMitarbeiter(dto.getMitarbeiter());
        return entity;
    }

    public static Set<ZeiterfassungDTO> parseEntitiestoDTOs(Set<ZeiterfassungEntity> entities){
        Set<ZeiterfassungDTO> dtos = new HashSet<>();
        entities.forEach((e)->{
            ZeiterfassungDTO dto = new ZeiterfassungDTO();
            dto.setDatum(e.getDatum());
            dto.setDauer(e.getDauer());
            dto.setId(e.getId());
            dto.setKommentar(e.getKommentar());
            if(e.getProjekt()!=null){
                dto.setProjektID(e.getProjekt().getId());
            }
            if(e.getKontingent()!=null){
                dto.setKontingentID(e.getKontingent().getId());
            }
            dtos.add(dto);
        });
        return dtos;
    }
}
