package com.hsaugsburg.HRManagementTool.services;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hsaugsburg.HRManagementTool.database.entity.MitarbeiterEntity;
import com.hsaugsburg.HRManagementTool.database.entity.ZeiterfassungEntity;
import com.hsaugsburg.HRManagementTool.database.repository.MitarbeiterRepo;
import com.hsaugsburg.HRManagementTool.database.repository.ZeiterfassungRepo;
import com.hsaugsburg.HRManagementTool.dto.MitarbeiterDTO;
import com.hsaugsburg.HRManagementTool.dto.ZeiterfassungDTO;
import com.hsaugsburg.HRManagementTool.models.Mitarbeiter;
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
    private MitarbeiterRepo mitarbeiterRepo;


    private Set<ZeiterfassungEntity> getTimeTracks(String userEmail){
        return timeTrackingRepo.findTimeTracksForEmploye(userEmail);
    }

    public String getparsedTimeTrackJson(String userEmail) throws JsonProcessingException {
        Set<ZeiterfassungDTO> timeTracksDTO=Zeiterfassung.parseEntitiestoDTOs(getTimeTracks(userEmail));
        return parseObjectToJson(timeTracksDTO);

    }

    public void createTimeTrack(String mail,String jsonBody) throws JsonProcessingException {
        ZeiterfassungDTO zeiterfassungDTO=new ZeiterfassungDTO();
        ZeiterfassungDTO dto = (ZeiterfassungDTO)parseJsonToObject(jsonBody,zeiterfassungDTO);
        //MitarbeiterDTO maDTO = Mitarbeiter.mapEntityToDTO(mitarbeiterRepo.findMitarbeiterByMail(mail));
        MitarbeiterEntity ma = mitarbeiterRepo.findMitarbeiterByMail(mail);
        dto.setMitarbeiter(ma);
        timeTrackingRepo.save(Zeiterfassung.mapDTOToEntity(dto));
    }

}
