package com.hsaugsburg.HRManagementTool.services;

import com.hsaugsburg.HRManagementTool.database.entity.AbteilungEntity;
import com.hsaugsburg.HRManagementTool.database.entity.MitarbeiterEntity;
import com.hsaugsburg.HRManagementTool.database.repository.AbteilungsRepo;
import com.hsaugsburg.HRManagementTool.database.repository.MitarbeiterRepo;
import com.hsaugsburg.HRManagementTool.dto.MitarbeiterDTO;
import com.hsaugsburg.HRManagementTool.models.Mitarbeiter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MitarbeiterService {
    @Autowired
    MitarbeiterRepo mitarbeiterRepo;
    @Autowired
    AbteilungsRepo abteilungsRepo;

    public MitarbeiterDTO getMitarbeiterDTO(String userName){
        MitarbeiterEntity maEntity = getMitarbeiterEntity(userName);
        return Mitarbeiter.mapEntityToDTO(maEntity);
    }

    public MitarbeiterEntity getMitarbeiterEntity(String userName){
         return mitarbeiterRepo.findByEmail(userName);
    }

    public Set<MitarbeiterEntity> getMitarbeiterEntities(Set<Integer> mitarbeiterIds){
            return new HashSet<MitarbeiterEntity>(mitarbeiterRepo.findAllById(mitarbeiterIds));
    }

    public void createMitarbeiter(MitarbeiterDTO mitarbeiter){
        AbteilungEntity abteilungEntity = abteilungsRepo.findById(mitarbeiter.getAbteilung());
        mitarbeiterRepo.save(Mitarbeiter.mapDTOToEntity(mitarbeiter,abteilungEntity));
        return;
    }

}
