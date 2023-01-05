package com.hsaugsburg.HRManagementTool.dto.calendar;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CalendarWeekRowDTO {

    private TerminDTO monday;

    private TerminDTO tuesday;

    private TerminDTO wednesday;

    private TerminDTO thursday;

    private TerminDTO friday;

}
