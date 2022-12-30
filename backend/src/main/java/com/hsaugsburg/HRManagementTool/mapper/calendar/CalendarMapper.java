package com.hsaugsburg.HRManagementTool.mapper.calendar;

import com.hsaugsburg.HRManagementTool.database.entity.TerminEntity;
import com.hsaugsburg.HRManagementTool.services.models.calendar.Termin;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;
@Component
@NoArgsConstructor
public class CalendarMapper{

    public Termin mapToTermin(TerminEntity terminEntity){
        Set<Integer> teilnehmerOfTermin = terminEntity.getTeilnehmer().stream().map(teilnehmer -> teilnehmer.getId()).collect(Collectors.toSet());

        Termin termin =    Termin.builder().titel(terminEntity.getTitel()).beschreibung(terminEntity.getBeschreibung()).id(terminEntity.getId()).beginn(terminEntity.getBeginn())
                .ende(terminEntity.getEnde()).datum(terminEntity.getDatum()).erstellerId(terminEntity.getErstellerId()).priority(terminEntity.getPriority()).teilnehmer(teilnehmerOfTermin).projektId(terminEntity.getProjektId()).build();

        return termin;
    }

    public TerminEntity mapToTerminEntity(Termin termin){
        TerminEntity terminEntity = new TerminEntity();
        terminEntity.setId(termin.getId());
        terminEntity.setTitel(termin.getTitel());
        terminEntity.setBeschreibung(termin.getBeschreibung());
        terminEntity.setBeginn(termin.getBeginn());
        terminEntity.setEnde(termin.getEnde());
        terminEntity.setDatum(termin.getDatum());
        terminEntity.setPriority(termin.getPriority());
        terminEntity.setProjektId(termin.getProjektId());
        terminEntity.setErstellerId(termin.getErstellerId());



        return terminEntity;

    }

}


