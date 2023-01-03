package com.hsaugsburg.HRManagementTool.dto.calendar;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
public class CalendarTableDTO {

    private Date startOfweek;
    private Date endOfweek;
    private CalendarWeekRowDTO[] appointments;
}
