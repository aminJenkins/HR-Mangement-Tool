package com.hsaugsburg.HRManagementTool.services;

import com.hsaugsburg.HRManagementTool.database.entity.MitarbeiterEntity;
import com.hsaugsburg.HRManagementTool.database.entity.ProjektEntity;
import com.hsaugsburg.HRManagementTool.database.entity.TerminEntity;
import com.hsaugsburg.HRManagementTool.database.repository.MitarbeiterRepo;
import com.hsaugsburg.HRManagementTool.database.repository.TerminRepo;
import com.hsaugsburg.HRManagementTool.dto.MitarbeiterDTO;
import com.hsaugsburg.HRManagementTool.dto.calendar.CalendarTableDTO;
import com.hsaugsburg.HRManagementTool.dto.calendar.CalendarWeekRowDTO;
import com.hsaugsburg.HRManagementTool.dto.calendar.TerminDTO;
import com.hsaugsburg.HRManagementTool.mapper.calendar.CalendarApiMapper;
import com.hsaugsburg.HRManagementTool.mapper.calendar.CalendarMapper;
import com.hsaugsburg.HRManagementTool.models.Mitarbeiter;
import com.hsaugsburg.HRManagementTool.models.calendar.Termin;
import com.hsaugsburg.HRManagementTool.models.calendar.TerminUpdate;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CalendarService {

    private final TerminRepo terminRepo;
    private final MitarbeiterRepo mitarbeiterRepo;
    private final MitarbeiterService mitarbeiterService;
    private final CalendarMapper calendarMapper;
    private final CalendarApiMapper calendarApiMapper;
    private final ProjektService projektService;


    public Termin createNewTermin(Termin newTermin, Authentication authentication) {
        MitarbeiterEntity erstellerOfTermin = this.mitarbeiterService.getMitarbeiterEntity(authentication.getName());
        Set<MitarbeiterEntity> teilnehmerOfTermin = this.mitarbeiterService.getEmployees(newTermin.getTeilnehmer());
        Optional<ProjektEntity> projektOfTermin = this.projektService.getProjectEntity(newTermin.getProjekt());
        TerminEntity terminToBeSaved = calendarMapper.mapToTerminEntity(newTermin, teilnehmerOfTermin, erstellerOfTermin, projektOfTermin);
        this.terminRepo.save(terminToBeSaved);
        return this.calendarMapper.mapToTermin(terminToBeSaved);

    }

    public void deleteTermin(int terminId, Authentication authentication) {
        TerminEntity terminToDeleted = this.terminRepo.findById(terminId).orElseThrow();
        if (!isLoggedInUserOwnerOfTermin(terminToDeleted.getErsteller().getId(), authentication)) {
            throw new RuntimeException("ERROR! Logged in User is not owner of Termin");
        }
        this.terminRepo.deleteById(terminId);
    }

    public Termin updateTermin(TerminUpdate terminUpdate, Authentication authentication) {
        Termin terminToBeUpdated = getTermin(terminUpdate.getId());
//        if (!isLoggedInUserOwnerOfTermin(terminToBeUpdated.getErstellerId(), authentication)) {
//            throw new RuntimeException("ERROR! Logged in User is not owner of Termin");
//        }
        terminToBeUpdated.update(terminUpdate);
        MitarbeiterEntity erstellerOfTermin = this.mitarbeiterService.getMitarbeiterEntity(authentication.getName());
        Set<MitarbeiterEntity> teilnehmerOfUpdatedTermin = this.mitarbeiterService.getEmployees(terminUpdate.getTeilnehmer());
        Optional<ProjektEntity> projectOfTermin = this.projektService.getProjectEntity(terminToBeUpdated.getProjekt());
        TerminEntity terminToBeUpdatedEntity = calendarMapper.mapToTerminEntity(terminToBeUpdated, teilnehmerOfUpdatedTermin, erstellerOfTermin, projectOfTermin);
        this.terminRepo.save(terminToBeUpdatedEntity);
        return this.calendarMapper.mapToTermin(terminToBeUpdatedEntity);

    }

    private Termin getTermin(final int terminId) {
        return this.terminRepo.findById(terminId).map(termin -> calendarMapper.mapToTermin(termin)).orElseThrow();
    }

    private boolean isLoggedInUserOwnerOfTermin(int erstellerID, Authentication authentication) {
        MitarbeiterEntity loggedInUser = this.mitarbeiterService.getMitarbeiterEntity(authentication.getName());
        return erstellerID == loggedInUser.getId();
    }


    public CalendarTableDTO getCalendarData(LocalDate startOfWeek, LocalDate endOfWeek, Authentication authentication) {

        MitarbeiterEntity loggedInUser = this.mitarbeiterService.getMitarbeiterEntity(authentication.getName());

        List<TerminDTO> appointmentsMonday = mapToTerminDTO(this.terminRepo.findAppointmentsByDate(startOfWeek, loggedInUser.getId()));
        List<TerminDTO> appointmentsTuesday = mapToTerminDTO(this.terminRepo.findAppointmentsByDate(startOfWeek.plusDays(1), loggedInUser.getId()));
        List<TerminDTO> appointmentsWednesday = mapToTerminDTO(this.terminRepo.findAppointmentsByDate(startOfWeek.plusDays(2), loggedInUser.getId()));
        List<TerminDTO> appointmentsThursday = mapToTerminDTO(this.terminRepo.findAppointmentsByDate(startOfWeek.plusDays(3), loggedInUser.getId()));
        List<TerminDTO> appointmentsFriday = mapToTerminDTO(this.terminRepo.findAppointmentsByDate(startOfWeek.plusDays(4), loggedInUser.getId()));

        final int maxListLength = Collections.max(Arrays.asList(appointmentsMonday.size(),
                appointmentsTuesday.size(),
                appointmentsTuesday.size(), appointmentsWednesday.size()
                , appointmentsThursday.size(),
                appointmentsFriday.size()));

        CalendarTableDTO calendarTableDTO = new CalendarTableDTO();

        List<CalendarWeekRowDTO> calendarWeekRowDTOS = new ArrayList<>();

        for (int i = 0; i < maxListLength; i++) {
            CalendarWeekRowDTO calendarWeekRowDTO = new CalendarWeekRowDTO();
            if(i < appointmentsMonday.size()){
                calendarWeekRowDTO.setMonday(appointmentsMonday.get(i));
            }
            if(i < appointmentsTuesday.size()){
                calendarWeekRowDTO.setTuesday(appointmentsTuesday.get(i));
            }
            if(i < appointmentsWednesday.size()){
                calendarWeekRowDTO.setWednesday(appointmentsWednesday.get(i));
            }
            if(i < appointmentsThursday.size()) {
                calendarWeekRowDTO.setThursday(appointmentsThursday.get(i));
            }
            if(i < appointmentsFriday.size()){
                calendarWeekRowDTO.setFriday(appointmentsFriday.get(i));
            }

        calendarWeekRowDTOS.add(calendarWeekRowDTO);

        }

        calendarTableDTO.setAppointments(calendarWeekRowDTOS);
        calendarTableDTO.setStartOfWeek(startOfWeek);
        calendarTableDTO.setEndOfWeek(endOfWeek);

        return calendarTableDTO;

    }

    private List<TerminDTO> mapToTerminDTO(List<TerminEntity> terminEntities) {
        List<Termin> termine = terminEntities.stream().map(terminEntity -> this.calendarMapper.mapToTermin(terminEntity)).collect(Collectors.toList());
        List<TerminDTO> terminDTOS = termine.stream().map(termin -> this.calendarApiMapper.map(termin)).collect(Collectors.toList());

        return terminDTOS;
    }

    public Set<MitarbeiterDTO> getAllPossibleParticipants(Authentication authentication) {
        List<MitarbeiterEntity> allEmployees = this.mitarbeiterRepo.findAll();
        MitarbeiterEntity loggedInUser = this.mitarbeiterService.getMitarbeiterEntity(authentication.getName());
        List<MitarbeiterEntity> possibleParticipants = allEmployees.stream().filter(employee -> employee.getId() != loggedInUser.getId()).collect(Collectors.toList());

        return Mitarbeiter.parseEntitiestoDTOs(new HashSet<>(possibleParticipants));
    }



}

