package com.hsaugsburg.HRManagementTool.models;

import com.hsaugsburg.HRManagementTool.database.entity.ZugangEntity;
import com.hsaugsburg.HRManagementTool.dto.ZugangDTO;

public class Zugang {

    public static ZugangEntity mapDTOtoEntity(ZugangDTO zugangDTO){
        ZugangEntity zugangEntity =new ZugangEntity();
        zugangEntity.setAuthority(zugangDTO.getAuthority());
        zugangEntity.setPassword(zugangDTO.getPassword());
        zugangEntity.setUsername(zugangDTO.getUsername());
        return zugangEntity;
    }
}

