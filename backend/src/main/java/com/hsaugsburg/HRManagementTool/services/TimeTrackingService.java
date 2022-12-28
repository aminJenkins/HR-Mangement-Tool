package com.hsaugsburg.HRManagementTool.services;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hsaugsburg.HRManagementTool.database.entity.KontingentEntity;
import com.hsaugsburg.HRManagementTool.database.entity.MitarbeiterEntity;
import com.hsaugsburg.HRManagementTool.database.entity.ProjektEntity;
import com.hsaugsburg.HRManagementTool.database.entity.ZeiterfassungEntity;
import com.hsaugsburg.HRManagementTool.database.repository.KontingentRepo;
import com.hsaugsburg.HRManagementTool.database.repository.ProjektRepo;
import com.hsaugsburg.HRManagementTool.database.repository.ZeiterfassungRepo;
import com.hsaugsburg.HRManagementTool.dto.ZeiterfassungDTO;
import com.hsaugsburg.HRManagementTool.models.Zeiterfassung;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.hsaugsburg.HRManagementTool.utils.JsonMapper.*;

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



    public Set<ZeiterfassungDTO> getTimeTracks(String userEmail){

        return Zeiterfassung.parseEntitiestoDTOs(timeTrackingRepo.findTimeTracksForEmploye(userEmail));
    }


    public void createTimeTrack(String mail,String jsonBody) throws JsonProcessingException {
        MitarbeiterEntity maEntity = mitarbeiterService.getMitarbeiterEntity(mail);

        ZeiterfassungDTO zeiterfassungDTO=new ZeiterfassungDTO();

        zeiterfassungDTO.setMitarbeiter(maEntity);

        zeiterfassungDTO = (ZeiterfassungDTO)parseJsonToObject(jsonBody,zeiterfassungDTO);

        ProjektEntity projektEntity = projektService.getProjektEntity(zeiterfassungDTO.getProjektID());

        KontingentEntity kontingentEntity = kontingentService.getKontingentEntity(zeiterfassungDTO.getKontingentID());

        ZeiterfassungEntity entity =  Zeiterfassung.mapDTOToEntity(zeiterfassungDTO,projektEntity,kontingentEntity);

        entity.setMitarbeiter(maEntity);

        timeTrackingRepo.save(entity);
    }

}
