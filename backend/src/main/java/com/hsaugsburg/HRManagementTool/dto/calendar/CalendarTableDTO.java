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

    private LocalDate startOfWeek;
    private LocalDate endOfWeek;
    private List<CalendarWeekRowDTO> appointments = new ArrayList<>();
}
