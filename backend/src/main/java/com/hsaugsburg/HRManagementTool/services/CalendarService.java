package com.hsaugsburg.HRManagementTool.services;

import com.hsaugsburg.HRManagementTool.database.entity.MitarbeiterEntity;
import com.hsaugsburg.HRManagementTool.database.entity.TerminEntity;
import com.hsaugsburg.HRManagementTool.database.repository.MitarbeiterRepo;
import com.hsaugsburg.HRManagementTool.database.repository.TerminRepo;
import com.hsaugsburg.HRManagementTool.dto.calendar.TerminUpdateDTO;
import com.hsaugsburg.HRManagementTool.mapper.calendar.CalendarMapper;
import com.hsaugsburg.HRManagementTool.models.calendar.Termin;
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
        TerminEntity terminToBeSaved =  this.calendarMapper.map(newTermin);
        terminToBeSaved.setErstellerId(erstellerOfTermin.getId());
        terminToBeSaved.setTeilnehmern(teilnehmerOfTermin);
        this.terminRepo.save(terminToBeSaved);
        return this.calendarMapper.map(terminToBeSaved);
    }

    public void deleteTermin(int terminId) {
    }

    public void updateTermin(TerminUpdateDTO terminUpdateDTO) {
    }
}
