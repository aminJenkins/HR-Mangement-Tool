package com.hsaugsburg.HRManagementTool.services;

import com.hsaugsburg.HRManagementTool.database.entity.MitarbeiterEntity;
import com.hsaugsburg.HRManagementTool.database.entity.TerminEntity;
import com.hsaugsburg.HRManagementTool.database.repository.MitarbeiterRepo;
import com.hsaugsburg.HRManagementTool.database.repository.TerminRepo;
import com.hsaugsburg.HRManagementTool.dto.calendar.TerminUpdateDTO;
import com.hsaugsburg.HRManagementTool.mapper.calendar.CalendarMapper;
import com.hsaugsburg.HRManagementTool.models.calendar.Termin;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;


@Service
@RequiredArgsConstructor
public class CalendarService {

    private final TerminRepo terminRepo;
    private final MitarbeiterRepo mitarbeiterRepo;
    private final CalendarMapper calendarMapper;
    private final ZugangsService zugangsService;

    public Termin createNewTermin(Termin newTermin,Authentication authentication) {
        MitarbeiterEntity erstellerOfTermin = this.mitarbeiterRepo.findByEmail(authentication.getName());
        newTermin.setMitarbeiterId(erstellerOfTermin.getId());
        TerminEntity savedTermin = this.terminRepo.save(this.calendarMapper.map(newTermin));
        return this.calendarMapper.map(savedTermin);
    }

    public void deleteTermin(int terminId) {
    }

    public void updateTermin(TerminUpdateDTO terminUpdateDTO) {
    }
}
