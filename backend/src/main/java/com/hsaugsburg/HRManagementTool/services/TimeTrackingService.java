package com.hsaugsburg.HRManagementTool.services;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hsaugsburg.HRManagementTool.database.entity.KontingentEntity;
import com.hsaugsburg.HRManagementTool.database.entity.MitarbeiterEntity;
import com.hsaugsburg.HRManagementTool.database.entity.ProjektEntity;
import com.hsaugsburg.HRManagementTool.database.entity.ZeiterfassungEntity;
import com.hsaugsburg.HRManagementTool.database.repository.ZeiterfassungRepo;
import com.hsaugsburg.HRManagementTool.dto.AngelegteZeiterfassungDTO;
import com.hsaugsburg.HRManagementTool.dto.ArbeitstagDTO;
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

    public void updateTimeTrack(String mail,AngelegteZeiterfassungDTO timetrack) throws ParseException {
        ZeiterfassungEntity entity = buildTimeTrackEntity(mail,timetrack);
        entity.setId(timetrack.getId());
        timeTrackingRepo.save(entity);
    }

    public void deleteTimeTrack(String id){
        timeTrackingRepo.deleteById(Integer.valueOf(id));
    }

    public List<ArbeitstagDTO> getTimeTracksSortedByDate(String mail){
        Map<LocalDateTime,ArbeitstagDTO> workdays = new HashMap();

        Zeiterfassung.parseEntitiestoDTOs(timeTrackingRepo.getAllSortedByDate(mail)).forEach(e->{
            LocalDateTime datum = e.getDatum();
            if(!workdays.containsKey(datum)){
                ArbeitstagDTO workday = new ArbeitstagDTO();
                Set<ZeiterfassungDTO> zeiterfassungDTOs= new HashSet<>();
                workday.setDate(datum);
                workday.setDay(datum.getDayOfWeek().name());
                workday.setMonth(datum.getMonth().name());
                workday.setYear(datum.getYear());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM");
                String date = datum.format(formatter);
                workday.setDayMonthNumbers(date);
                zeiterfassungDTOs.add(e);
                workday.setTimeTracks(zeiterfassungDTOs);
                workdays.put(datum,workday);
            }else{
                workdays.get(datum).getTimeTracks().add(e);
            }
        });
        List<ArbeitstagDTO> arbeitstagDTOsSet = new ArrayList<>();
        workdays.values().forEach(e->arbeitstagDTOsSet.add(e));
        Collections.sort(arbeitstagDTOsSet,Collections.reverseOrder());
        return arbeitstagDTOsSet;
    }

    public void createTimeTrack(String mail, ZeiterfassungDTO zeiterfassungDTO) throws ParseException {
        timeTrackingRepo.save(buildTimeTrackEntity(mail,zeiterfassungDTO));
    }

    public ZeiterfassungEntity buildTimeTrackEntity(String mail, ZeiterfassungDTO zeiterfassungDTO) throws ParseException {
        MitarbeiterEntity maEntity = mitarbeiterService.getMitarbeiterEntity(mail);

        ProjektEntity projektEntity = projektService.getProjektEntityById(zeiterfassungDTO.getProjektID());

        KontingentEntity kontingentEntity = kontingentService.getKontingentEntity(zeiterfassungDTO.getKontingentID());

        ZeiterfassungEntity entity =  Zeiterfassung.mapDTOToEntity(zeiterfassungDTO,projektEntity,kontingentEntity,maEntity);

        return entity;
    }



}
