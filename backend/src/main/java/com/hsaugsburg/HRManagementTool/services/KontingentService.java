package com.hsaugsburg.HRManagementTool.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hsaugsburg.HRManagementTool.database.entity.KontingentEntity;
import com.hsaugsburg.HRManagementTool.database.repository.KontingentRepo;
import com.hsaugsburg.HRManagementTool.dto.KontingentDTO;
import com.hsaugsburg.HRManagementTool.models.Kontingent;
import com.hsaugsburg.HRManagementTool.utils.JsonMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
@AllArgsConstructor
public class KontingentService {

    @Autowired
    private KontingentRepo kontingentRepo;

    public KontingentEntity getKontingentEntity(int kontingentID) {
        return kontingentRepo.findById(kontingentID);
    }

    public String getContingents() throws JsonProcessingException {
        Set<KontingentDTO> kontingentDTOS = new HashSet<>();
        List<KontingentEntity> entitySet = kontingentRepo.findAll();

        entitySet.forEach(e -> {
            kontingentDTOS.add(Kontingent.parseEntityToDTO(e));
        });
        return JsonMapper.parseObjectToJson(kontingentDTOS);
    }

    public Set<KontingentEntity> getKontingentEntitiesById(Set<Integer> kontingente) {
        Set<KontingentEntity> kontingentEntities = new HashSet<>();

        kontingente.forEach(id -> {
            KontingentEntity ke = kontingentRepo.findById(id.intValue());
            kontingentEntities.add(ke);
        });
        return kontingentEntities;
    }
}
