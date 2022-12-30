package com.hsaugsburg.HRManagementTool.models;

import com.hsaugsburg.HRManagementTool.database.entity.KontingentEntity;
import com.hsaugsburg.HRManagementTool.dto.KontingentDTO;

public class Kontingent {
    public static KontingentDTO parseEntityToDTO(KontingentEntity kontingentEntity){
        KontingentDTO kontingentDTO = new KontingentDTO();
        kontingentDTO.setId(kontingentEntity.getId());
        kontingentDTO.setBezeichnung(kontingentEntity.getBezeichnung());
        return kontingentDTO;
    }
}
