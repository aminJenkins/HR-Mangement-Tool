package com.hsaugsburg.HRManagementTool.dto.calendar;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CalendarTableDTO {

    private String week;
    private CalendarWeekRowDTO[] appointments;
}
