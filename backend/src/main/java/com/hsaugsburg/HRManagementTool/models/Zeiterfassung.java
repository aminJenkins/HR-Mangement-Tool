package com.hsaugsburg.HRManagementTool.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.hsaugsburg.HRManagementTool.database.entity.KontingentEntity;
import com.hsaugsburg.HRManagementTool.database.entity.MitarbeiterEntity;
import com.hsaugsburg.HRManagementTool.database.entity.ProjektEntity;
import com.hsaugsburg.HRManagementTool.database.entity.ZeiterfassungEntity;
import com.hsaugsburg.HRManagementTool.dto.KontingentDTO;
import com.hsaugsburg.HRManagementTool.dto.MitarbeiterDTO;
import com.hsaugsburg.HRManagementTool.dto.ProjektDTO;
import com.hsaugsburg.HRManagementTool.dto.AngelegteZeiterfassungDTO;
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
    final static private String pattern = "dd-M-yyyy hh:mm:ss";
    final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    public static AngelegteZeiterfassungDTO mapEntityToDTO(ZeiterfassungEntity entity){
        AngelegteZeiterfassungDTO dto = new AngelegteZeiterfassungDTO();
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
        dto.setMitarbeiter(entity.getMitarbeiter().getId());
        return dto;
    }

    public static ZeiterfassungEntity mapDTOToEntity(AngelegteZeiterfassungDTO timeTrackDto){
        ZeiterfassungEntity zeiterfassungEntity = mapDTOToEntity(timeTrackDto);
        zeiterfassungEntity.setId(timeTrackDto.getId());
        return zeiterfassungEntity;

    }

    public static ZeiterfassungEntity mapDTOToEntity(ZeiterfassungDTO dto, ProjektEntity projektEntity,KontingentEntity kontingentEntity,
            MitarbeiterEntity mitarbeiterEntity) throws ParseException {
        ZeiterfassungEntity entity = new ZeiterfassungEntity();
        entity.setProjekt(projektEntity);
        entity.setKontingent(kontingentEntity);
        entity.setKommentar(dto.getKommentar());
        entity.setDauer(dto.getDauer());
        entity.setDatum(dto.getDatum());
        entity.setMitarbeiter(mitarbeiterEntity);
        return entity;
    }

    public static Set<AngelegteZeiterfassungDTO> parseEntitiestoDTOs(Set<ZeiterfassungEntity> entities){
        Set<AngelegteZeiterfassungDTO> dtos = new HashSet<>();
        entities.forEach((e)->{
            AngelegteZeiterfassungDTO dto = new AngelegteZeiterfassungDTO();
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
