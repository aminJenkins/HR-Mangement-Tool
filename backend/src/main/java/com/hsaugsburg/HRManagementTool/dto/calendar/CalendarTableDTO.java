package com.hsaugsburg.HRManagementTool.dto.calendar;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CalendarTableDTO {

    private LocalDate startOfweek;
    private LocalDate endOfweek;
    private List<CalendarWeekRowDTO> appointments = new ArrayList<>();
}
