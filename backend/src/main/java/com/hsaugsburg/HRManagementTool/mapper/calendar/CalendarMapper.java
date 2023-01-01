package com.hsaugsburg.HRManagementTool.mapper.calendar;

import com.hsaugsburg.HRManagementTool.database.entity.MitarbeiterEntity;
import com.hsaugsburg.HRManagementTool.database.entity.ProjektEntity;
import com.hsaugsburg.HRManagementTool.database.entity.TerminEntity;
import com.hsaugsburg.HRManagementTool.models.Mitarbeiter;
import com.hsaugsburg.HRManagementTool.models.calendar.Termin;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;
@Component
@NoArgsConstructor
public class CalendarMapper{

    public Termin mapToTermin(TerminEntity terminEntity){
        Set<String> teilnehmerOfTermin = terminEntity.getTeilnehmer().stream().map(teilnehmer -> teilnehmer.getEmail()).collect(Collectors.toSet());
        String projekt = terminEntity.getProjekt().getBezeichnung();
        Termin termin =    Termin.builder().titel(terminEntity.getTitel())
                .beschreibung(terminEntity.getBeschreibung())
                .id(terminEntity.getId()).beginn(terminEntity.getBeginn())
                .ende(terminEntity.getEnde())
                .datum(terminEntity.getDatum())
                .erstellerId(terminEntity.getMitarbeiterEntity().getId())
                .priority(terminEntity.getPriority())
                .teilnehmer(teilnehmerOfTermin)
                .projekt(projekt).build();

        return termin;
    }

    public TerminEntity mapToTerminEntity(Termin termin, Set<MitarbeiterEntity> teilnehmerOfTermin, MitarbeiterEntity ersteller, ProjektEntity projektEntity){
        TerminEntity terminEntity = new TerminEntity();
        terminEntity.setId(termin.getId());
        terminEntity.setTitel(termin.getTitel());
        terminEntity.setBeschreibung(termin.getBeschreibung());
        terminEntity.setBeginn(termin.getBeginn());
        terminEntity.setEnde(termin.getEnde());
        terminEntity.setDatum(termin.getDatum());
        terminEntity.setPriority(termin.getPriority());
        terminEntity.setProjekt(projektEntity);
        terminEntity.setMitarbeiterEntity(ersteller);
        terminEntity.setTeilnehmer(teilnehmerOfTermin);
        return terminEntity;

    }

}


