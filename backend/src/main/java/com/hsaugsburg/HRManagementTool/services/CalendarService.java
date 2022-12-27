package com.hsaugsburg.HRManagementTool.services;

import com.hsaugsburg.HRManagementTool.database.entity.TerminEntity;
import com.hsaugsburg.HRManagementTool.database.repository.TerminRepo;
import com.hsaugsburg.HRManagementTool.dto.calendar.TerminUpdateDTO;
import com.hsaugsburg.HRManagementTool.mapper.calendar.CalendarMapper;
import com.hsaugsburg.HRManagementTool.models.calendar.Termin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class CalendarService {

    private final TerminRepo terminRepo;
    private final CalendarMapper calendarMapper;

    public Termin createNewTermin(Termin newTermin) {
        TerminEntity savedTermin = this.terminRepo.save(this.calendarMapper.map(newTermin));
        return this.calendarMapper.map(savedTermin);
    }

    public void deleteTermin(int terminId) {
    }

    public void updateTermin(TerminUpdateDTO terminUpdateDTO) {
    }
}
