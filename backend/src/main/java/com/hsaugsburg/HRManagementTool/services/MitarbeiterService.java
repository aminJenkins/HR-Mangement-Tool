package com.hsaugsburg.HRManagementTool.services;

import com.hsaugsburg.HRManagementTool.database.entity.AbteilungEntity;
import com.hsaugsburg.HRManagementTool.database.entity.MitarbeiterEntity;
import com.hsaugsburg.HRManagementTool.database.entity.ZugangEntity;
import com.hsaugsburg.HRManagementTool.database.repository.AbteilungsRepo;
import com.hsaugsburg.HRManagementTool.database.repository.MitarbeiterRepo;
import com.hsaugsburg.HRManagementTool.database.repository.ZugangsRepo;
import com.hsaugsburg.HRManagementTool.dto.MitarbeiterDTO;
import com.hsaugsburg.HRManagementTool.models.Mitarbeiter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.util.HashSet;
import java.util.Set;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MitarbeiterService {
    @Autowired
    MitarbeiterRepo mitarbeiterRepo;
    @Autowired
    AbteilungsRepo abteilungsRepo;
    @Autowired
    ZugangsRepo zugangsRepo;

    public MitarbeiterDTO getMitarbeiterDTO(String userName) {
        MitarbeiterEntity maEntity = getMitarbeiterEntity(userName);
        return Mitarbeiter.mapEntityToDTO(maEntity);
    }

    public MitarbeiterEntity getMitarbeiterEntity(String userName) {
        return mitarbeiterRepo.findByEmail(userName);
    }

    public MitarbeiterEntity getMitarbeiterEntityById(int id) {
        return mitarbeiterRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
    }

    public void createMitarbeiter(MitarbeiterDTO mitarbeiter) {
        AbteilungEntity abteilungEntity = abteilungsRepo.findById(mitarbeiter.getAbteilung());
        ZugangEntity zugang = zugangsRepo.findByUsername(mitarbeiter.getEmail()).orElseThrow();
        mitarbeiterRepo.save(Mitarbeiter.mapDTOToEntity(mitarbeiter, abteilungEntity, zugang));
    }

    public MitarbeiterDTO updateEmployee(MitarbeiterDTO mitarbeiterDTO) {
        System.out.println("in update employee:" + mitarbeiterDTO.toString());
        AbteilungEntity abteilungEntity = abteilungsRepo.findById(mitarbeiterDTO.getAbteilung());
        ZugangEntity zugang = zugangsRepo.findByUsername(mitarbeiterDTO.getEmail()).orElseThrow();
        System.out.println("abteilung: " + abteilungEntity.toString());
        MitarbeiterEntity me = Mitarbeiter.mapDTOToEntity(mitarbeiterDTO, abteilungEntity, zugang);
        System.out.println("MAEntity: " + me.toString());
        MitarbeiterEntity updatedMitarbeiter = mitarbeiterRepo.save(me);
        return Mitarbeiter.mapEntityToDTO(updatedMitarbeiter);
    }

    public void checkIsAdminOrCorrectUser(Authentication authentication, String email) throws Exception {
        SimpleGrantedAuthority roleAdmin = new SimpleGrantedAuthority("ROLE_ADMIN");
        if (!authentication.getAuthorities().contains(roleAdmin)) {
            if (!authentication.getName().equals(email)) {
                throw new Exception("You can only update your own user information");
            }
        }
    }

    public Set<MitarbeiterEntity> getMitarbeiterEntities(Set<String> userNames) {
        Set<MitarbeiterEntity> ma = new HashSet<>();
        userNames.forEach(s -> ma.add(mitarbeiterRepo.findByEmail(s)));
        return ma;
    }

    public Set<MitarbeiterDTO> getAllEmployees() {
        return Mitarbeiter.mapEntitiesToDTOs(new HashSet<>(mitarbeiterRepo.findAll()));
    }

    public Set<MitarbeiterEntity> getEmployeeEntities(Set<String> emailsOfEmployees){
        return new HashSet<MitarbeiterEntity>(mitarbeiterRepo.findAllByEmail(emailsOfEmployees));
    }
}
