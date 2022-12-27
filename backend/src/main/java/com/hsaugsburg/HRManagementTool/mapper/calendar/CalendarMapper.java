package com.hsaugsburg.HRManagementTool.mapper.calendar;

import com.hsaugsburg.HRManagementTool.database.entity.TerminEntity;
import com.hsaugsburg.HRManagementTool.models.calendar.Termin;
import org.mapstruct.Mapper;

@Mapper
public interface CalendarMapper {
    TerminEntity map(Termin termin);
    Termin map(TerminEntity termin);
}
