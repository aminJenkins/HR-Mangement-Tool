package com.hsaugsburg.HRManagementTool.dto.mitarbeiter;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MitarbeiterDTO {
    @NotNull
    private int id;

    private String name;

    private String nachname;
}
