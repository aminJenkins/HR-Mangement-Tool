package com.hsaugsburg.HRManagementTool.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hsaugsburg.HRManagementTool.database.entity.KontingentEntity;
import com.hsaugsburg.HRManagementTool.database.repository.KontingentRepo;
import com.hsaugsburg.HRManagementTool.dto.KontingentDTO;
import com.hsaugsburg.HRManagementTool.services.models.Kontingent;
import com.hsaugsburg.HRManagementTool.utils.JsonMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class KontingentService {

    @Autowired
    private KontingentRepo kontingentRepo;

    public KontingentEntity getKontingentEntity(int kontingentID){
        return kontingentRepo.findById(kontingentID);
    }

    public String getContingents() throws JsonProcessingException {
        Set<KontingentDTO> kontingentDTOS = new HashSet<>();
        List<KontingentEntity> entitySet = kontingentRepo.findAll();

        entitySet.forEach(e->{kontingentDTOS.add(Kontingent.parseEntityToDTO(e));});
        return JsonMapper.parseObjectToJson(kontingentDTOS);
    }
}
