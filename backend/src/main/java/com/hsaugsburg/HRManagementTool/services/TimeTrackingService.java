package com.hsaugsburg.HRManagementTool.services;
import java.util.Set;

import com.hsaugsburg.HRManagementTool.database.entity.KontingentEntity;
import com.hsaugsburg.HRManagementTool.database.entity.MitarbeiterEntity;
import com.hsaugsburg.HRManagementTool.database.entity.ProjektEntity;
import com.hsaugsburg.HRManagementTool.database.entity.ZeiterfassungEntity;
import com.hsaugsburg.HRManagementTool.database.repository.ZeiterfassungRepo;
import com.hsaugsburg.HRManagementTool.dto.AngelegteZeiterfassungDTO;
import com.hsaugsburg.HRManagementTool.dto.ZeiterfassungDTO;
import com.hsaugsburg.HRManagementTool.models.Zeiterfassung;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TimeTrackingService {
    @Autowired
    private  ZeiterfassungRepo timeTrackingRepo;
    @Autowired
    private MitarbeiterService mitarbeiterService;
    @Autowired
    private ProjektService projektService;

    @Autowired
    private KontingentService kontingentService;



    public Set<AngelegteZeiterfassungDTO> getTimeTracks(String userEmail){

        return Zeiterfassung.parseEntitiestoDTOs(timeTrackingRepo.findTimeTracksForEmploye(userEmail));
    }

    public void updateTimeTrack(String mail,AngelegteZeiterfassungDTO timetrack){
        ZeiterfassungEntity entity = buildTimeTrackEntity(mail,timetrack);
        entity.setId(timetrack.getId());
        timeTrackingRepo.save(entity);
    }

    public void deleteTimeTrack(String id){

        timeTrackingRepo.deleteById(Integer.valueOf(id));
    }

    public void createTimeTrack(String mail, ZeiterfassungDTO zeiterfassungDTO) {
        timeTrackingRepo.save(buildTimeTrackEntity(mail,zeiterfassungDTO));
    }

    public ZeiterfassungEntity buildTimeTrackEntity(String mail, ZeiterfassungDTO zeiterfassungDTO){
        MitarbeiterEntity maEntity = mitarbeiterService.getMitarbeiterEntity(mail);

        ProjektEntity projektEntity = projektService.getProjektEntity(zeiterfassungDTO.getProjektID());

        KontingentEntity kontingentEntity = kontingentService.getKontingentEntity(zeiterfassungDTO.getKontingentID());

        ZeiterfassungEntity entity =  Zeiterfassung.mapDTOToEntity(zeiterfassungDTO,projektEntity,kontingentEntity,maEntity);

        return entity;
    }



}
