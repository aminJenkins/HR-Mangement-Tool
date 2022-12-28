package com.hsaugsburg.HRManagementTool.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hsaugsburg.HRManagementTool.database.entity.KontingentEntity;
import com.hsaugsburg.HRManagementTool.database.repository.KontingentRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.hsaugsburg.HRManagementTool.utils.JsonMapper.parseObjectToJson;

@Service
@AllArgsConstructor
public class KontingentService {

    @Autowired
    private KontingentRepo kontingentRepo;

    public KontingentEntity getKontingentEntity(int kontingentID){
        return kontingentRepo.findById(kontingentID);
    }

    public String getContingents() throws JsonProcessingException {
        return parseObjectToJson(kontingentRepo.findAll());
    }
}
