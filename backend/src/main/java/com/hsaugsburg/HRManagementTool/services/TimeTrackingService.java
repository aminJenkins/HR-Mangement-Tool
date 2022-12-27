package com.hsaugsburg.HRManagementTool.services;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.hsaugsburg.HRManagementTool.database.entity.ZeiterfassungEntity;
import com.hsaugsburg.HRManagementTool.database.repository.ZeiterfassungRepo;
import com.hsaugsburg.HRManagementTool.dto.ZeiterfassungDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TimeTrackingService {
    @Autowired
    private  ZeiterfassungRepo timeTrackingRepo;
    private String parseTimeTrackToJson(Set<ZeiterfassungDTO> timeTracks) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(timeTracks);
        return  json;
    }

    private Set<ZeiterfassungEntity> getTimeTracks(int maID){
        return timeTrackingRepo.findTimeTracksForEmploye(maID);
    }

    private Set<ZeiterfassungDTO> parseEntitytoDTO(Set<ZeiterfassungEntity> entities){
        Set<ZeiterfassungDTO> dtos = new HashSet<>();
        entities.forEach((e)->{
            ZeiterfassungDTO dto = new ZeiterfassungDTO();
            dto.setDatum(e.getDatum());
            dto.setDauer(e.getDauer());
            dto.setId(e.getId());
            dto.setKommentar(e.getKommentar());
            dto.setKontingente(e.getKontingente());
            dto.setProjekte(e.getProjekte());
            dtos.add(dto);
        });
        return dtos;
    }

    public String getparsedTimeTrackJson(int maID) throws JsonProcessingException {
        Set<ZeiterfassungDTO> timeTracksDTO=parseEntitytoDTO(getTimeTracks(maID));
        return parseTimeTrackToJson(timeTracksDTO);

    }
}
