package com.hsaugsburg.HRManagementTool.services;

import com.hsaugsburg.HRManagementTool.database.entity.MitarbeiterEntity;
import com.hsaugsburg.HRManagementTool.database.entity.TerminEntity;
import com.hsaugsburg.HRManagementTool.database.repository.TerminRepo;
import com.hsaugsburg.HRManagementTool.mapper.calendar.CalendarMapper;
import com.hsaugsburg.HRManagementTool.models.calendar.Termin;
import com.hsaugsburg.HRManagementTool.models.calendar.TerminUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;

import java.util.Set;


@Service
@RequiredArgsConstructor
public class CalendarService {

    private final TerminRepo terminRepo;
    private final MitarbeiterService mitarbeiterService;
    private final CalendarMapper calendarMapper;


    public Termin createNewTermin(Termin newTermin,Authentication authentication) {
        MitarbeiterEntity erstellerOfTermin = this.mitarbeiterService.getMitarbeiterEntity(authentication.getName());
        Set<MitarbeiterEntity> teilnehmerOfTermin = this.mitarbeiterService.getMitarbeiterEntities(newTermin.getTeilnehmer());
        TerminEntity terminToBeSaved =  calendarMapper.mapToTerminEntity(newTermin);
        terminToBeSaved.setErstellerId(erstellerOfTermin.getId());
        terminToBeSaved.setTeilnehmer(teilnehmerOfTermin);
        this.terminRepo.save(terminToBeSaved);
        return this.calendarMapper.mapToTermin(terminToBeSaved);

    }

    public void deleteTermin(int terminId, Authentication authentication) {
        TerminEntity terminToDeleted =  this.terminRepo.findById(terminId).orElseThrow();
        if(!isLoggedInUserOwnerOfTermin(terminToDeleted.getErstellerId(),authentication)){
            throw new RuntimeException("ERROR! Logged in User is not owner of Termin");
        }
        this.terminRepo.deleteById(terminId);
    }

    public Termin updateTermin(TerminUpdate terminUpdate,Authentication authentication) {
       Termin terminToBeUpdated= getTermin(terminUpdate.getId());
       if(!isLoggedInUserOwnerOfTermin(terminToBeUpdated.getErstellerId(),authentication)){
           throw new RuntimeException("ERROR! Logged in User is not owner of Termin");
       }
       terminToBeUpdated.update(terminUpdate);
       TerminEntity terminToBeUpdatedEntity = calendarMapper.mapToTerminEntity(terminToBeUpdated);
       Set<MitarbeiterEntity> teilnehmerOfUpdatedTermin = this.mitarbeiterService.getMitarbeiterEntities(terminUpdate.getTeilnehmer());
       terminToBeUpdatedEntity.setTeilnehmer(teilnehmerOfUpdatedTermin);
       this.terminRepo.save(terminToBeUpdatedEntity);
       return this.calendarMapper.mapToTermin(terminToBeUpdatedEntity);

    }

    private Termin getTermin(final int terminId){
        return this.terminRepo.findById(terminId).map(termin -> calendarMapper.mapToTermin(termin)).orElseThrow();
    }

    private boolean isLoggedInUserOwnerOfTermin(int erstellerID,Authentication authentication){
        MitarbeiterEntity loggedInUser = this.mitarbeiterService.getMitarbeiterEntity(authentication.getName());
        return erstellerID == loggedInUser.getId();
    }



}
