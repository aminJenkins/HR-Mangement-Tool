package com.hsaugsburg.HRManagementTool.mapper.calendar;

import com.hsaugsburg.HRManagementTool.database.entity.TerminEntity;
import com.hsaugsburg.HRManagementTool.dto.calendar.NewTerminDTO;
import com.hsaugsburg.HRManagementTool.dto.calendar.TerminDTO;
import com.hsaugsburg.HRManagementTool.dto.calendar.TerminUpdateDTO;
import com.hsaugsburg.HRManagementTool.dto.mitarbeiter.MitarbeiterDTO;
import com.hsaugsburg.HRManagementTool.models.calendar.Termin;
import com.hsaugsburg.HRManagementTool.models.calendar.TerminUpdate;
import com.hsaugsburg.HRManagementTool.models.mitarbeiter.Mitarbeiter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
@Component
@NoArgsConstructor
public class CalendarMapper{

    public Termin mapToTermin(TerminEntity terminEntity){
        Set<Integer> teilnehmerOfTermin = terminEntity.getTeilnehmer().stream().map(teilnehmer -> teilnehmer.getId()).collect(Collectors.toSet());

        Termin termin =    Termin.builder().titel(terminEntity.getTitel()).beschreibung(terminEntity.getBeschreibung()).id(terminEntity.getId()).beginn(terminEntity.getBeginn())
                .ende(terminEntity.getEnde()).datum(terminEntity.getDatum()).erstellerId(terminEntity.getErstellerId()).priority(terminEntity.getPriority()).teilnehmer(teilnehmerOfTermin).build();

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
        terminEntity.setErstellerId(termin.getErstellerId());


        return terminEntity;

    }

}


