package com.hsaugsburg.HRManagementTool.dto;

import java.util.Set;
import com.hsaugsburg.HRManagementTool.database.entity.KontingentEntity;
import com.hsaugsburg.HRManagementTool.database.entity.MitarbeiterEntity;
import com.hsaugsburg.HRManagementTool.database.entity.TerminEntity;
import com.hsaugsburg.HRManagementTool.database.entity.ZeiterfassungEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjektDTO {
    private int id;

    private int leiterID;

    private String auftragsgeber;

    private String bezeichnung;

    //private Set<TerminEntity> termine;

    private Set<String> projektbeteiligte;
}
