package com.hsaugsburg.HRManagementTool.dto.calendar;
package com.hsaugsburg.HRManagementTool.dto.calendar;

import com.hsaugsburg.HRManagementTool.models.Priority;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;
import java.util.Set;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewTerminDTO {

    @NotNull
    private String titel;

    @NotNull
    private String beschreibung;

    @NotNull
    private LocalTime beginn;

    @NotNull
    private LocalTime ende;

    @NotNull
    private Date datum;

    @NotNull
    private Set<Integer> teilnehmer;

    @NotNull
    private Priority priority;

    @NotNull
    private int projektId;

}
