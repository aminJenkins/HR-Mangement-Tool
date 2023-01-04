package com.hsaugsburg.HRManagementTool.mapper.calendar;

import com.hsaugsburg.HRManagementTool.dto.calendar.NewTerminDTO;
import com.hsaugsburg.HRManagementTool.dto.calendar.TerminDTO;
import com.hsaugsburg.HRManagementTool.dto.calendar.TerminUpdateDTO;
import com.hsaugsburg.HRManagementTool.models.calendar.Termin;
import com.hsaugsburg.HRManagementTool.models.calendar.TerminUpdate;
import com.hsaugsburg.HRManagementTool.models.mitarbeiter.Mitarbeiter;
import org.mapstruct.Mapper;

@Mapper
public interface CalendarApiMapper {
    TerminDTO map(Termin termin);

    Termin map(TerminDTO termin);

    Termin map(NewTerminDTO newTermin);

    TerminUpdate map(TerminUpdateDTO terminUpdateDTO);

}
