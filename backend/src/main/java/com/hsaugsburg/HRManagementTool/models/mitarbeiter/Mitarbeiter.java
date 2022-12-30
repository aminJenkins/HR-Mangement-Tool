package com.hsaugsburg.HRManagementTool.models.mitarbeiter;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class Mitarbeiter {
    private final int id;
    private String name;
    private String nachname;
}
