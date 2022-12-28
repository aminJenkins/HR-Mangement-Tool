package com.hsaugsburg.HRManagementTool.services;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hsaugsburg.HRManagementTool.database.entity.MitarbeiterEntity;
import com.hsaugsburg.HRManagementTool.database.entity.ZeiterfassungEntity;
import com.hsaugsburg.HRManagementTool.database.repository.KontingentRepo;
import com.hsaugsburg.HRManagementTool.database.repository.MitarbeiterRepo;
import com.hsaugsburg.HRManagementTool.database.repository.ZeiterfassungRepo;
import com.hsaugsburg.HRManagementTool.dto.MitarbeiterDTO;
import com.hsaugsburg.HRManagementTool.dto.ZeiterfassungDTO;
import com.hsaugsburg.HRManagementTool.models.Mitarbeiter;
import com.hsaugsburg.HRManagementTool.models.Zeiterfassung;
import com.hsaugsburg.HRManagementTool.utils.JsonMapper;
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
    private MitarbeiterRepo mitarbeiterRepo;
    @Autowired
    private KontingentRepo kontingentRepo;

    public MitarbeiterDTO getMitarbeiter(String email) throws JsonProcessingException {

        return  Mitarbeiter.mapEntityToDTO(mitarbeiterRepo.findByEmail(email));
    }


    private Set<ZeiterfassungEntity> getTimeTracks(String userEmail){
        return timeTrackingRepo.findTimeTracksForEmploye(userEmail);
    }

    public String getparsedTimeTrackJson(String userEmail) throws JsonProcessingException {
        Set<ZeiterfassungDTO> timeTracksDTO=Zeiterfassung.parseEntitiestoDTOs(getTimeTracks(userEmail));
        return parseObjectToJson(timeTracksDTO);

    }

    public String getContingents() throws JsonProcessingException {
        return parseObjectToJson(kontingentRepo.findAll());
    }

    public void createTimeTrack(String mail,String jsonBody) throws JsonProcessingException {
        MitarbeiterEntity maEntity = mitarbeiterRepo.findByEmail(mail);

        ZeiterfassungDTO zeiterfassungDTO=new ZeiterfassungDTO();

        zeiterfassungDTO.setMitarbeiter(maEntity);

        zeiterfassungDTO = (ZeiterfassungDTO)parseJsonToObject(jsonBody,zeiterfassungDTO);


        ZeiterfassungEntity entity =  Zeiterfassung.mapDTOToEntity(zeiterfassungDTO);

        entity.setMitarbeiter(maEntity);

        timeTrackingRepo.save(entity);
    }

}
