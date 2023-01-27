package com.hsaugsburg.HRManagementTool.models;

import com.hsaugsburg.HRManagementTool.database.entity.AbteilungEntity;
import com.hsaugsburg.HRManagementTool.dto.AbteilungDTO;

import java.util.HashSet;
import java.util.Set;

public class Abteilung {

    public static AbteilungDTO parseEntityToDTO(AbteilungEntity abteilungEntity){
        AbteilungDTO abteilungDTO = new AbteilungDTO();
        abteilungDTO.setId(abteilungEntity.getId());
        abteilungDTO.setName(abteilungEntity.getName());
        return abteilungDTO;
    }

    public static Set<AbteilungDTO> parseEntitiesToDTOs(Set<AbteilungEntity> entities){
        Set<AbteilungDTO> dtos = new HashSet<>();
        entities.forEach(e->{
            dtos.add(parseEntityToDTO(e));
        });
        return dtos;
    }
}
