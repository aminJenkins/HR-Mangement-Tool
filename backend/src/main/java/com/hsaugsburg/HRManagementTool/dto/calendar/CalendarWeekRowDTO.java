package com.hsaugsburg.HRManagementTool.dto.calendar;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CalendarWeekRowDTO {

    private TerminDTO monday;

    private TerminDTO tuesday;

    private TerminDTO wednesday;

    private TerminDTO thursday;

    private TerminDTO friday;

}
