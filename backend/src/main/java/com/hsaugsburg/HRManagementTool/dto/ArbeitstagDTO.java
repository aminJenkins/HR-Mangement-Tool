package com.hsaugsburg.HRManagementTool.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter

public class ArbeitstagDTO implements Comparable<ArbeitstagDTO> {
    Set<ZeiterfassungDTO> timeTracks;
    LocalDateTime date;
    String day;
    String month;
    int year;
    String dayMonthNumbers;

    @Override
    public int compareTo(ArbeitstagDTO o) {
        return getDate().compareTo(o.getDate());
    }
}
