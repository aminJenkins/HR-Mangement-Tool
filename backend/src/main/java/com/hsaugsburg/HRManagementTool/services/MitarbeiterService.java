package com.hsaugsburg.HRManagementTool.services;

import com.hsaugsburg.HRManagementTool.database.entity.AbteilungEntity;
import com.hsaugsburg.HRManagementTool.database.entity.MitarbeiterEntity;
import com.hsaugsburg.HRManagementTool.database.entity.ZugangEntity;
import com.hsaugsburg.HRManagementTool.database.repository.AbteilungsRepo;
import com.hsaugsburg.HRManagementTool.database.repository.MitarbeiterRepo;
import com.hsaugsburg.HRManagementTool.database.repository.ZugangsRepo;
import com.hsaugsburg.HRManagementTool.dto.MitarbeiterDTO;
import com.hsaugsburg.HRManagementTool.dto.mitarbeiter.CreateEmployeeDTO;
import com.hsaugsburg.HRManagementTool.models.Mitarbeiter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
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

    @Autowired
    private PasswordEncoder passwordEncoder;

    public MitarbeiterDTO getMitarbeiterDTO(String userName) {
        MitarbeiterEntity maEntity = getMitarbeiterEntity(userName);
        return Mitarbeiter.mapEntityToDTO(maEntity);
    }

    public Set<MitarbeiterDTO> getAllEmaployees() {
        return Mitarbeiter.mapEntitiesToDTOs(new HashSet<MitarbeiterEntity>(mitarbeiterRepo.findAll()));
    }


    public MitarbeiterEntity getMitarbeiterEntity(String userName) {
        return mitarbeiterRepo.findByEmail(userName);
    }

    public MitarbeiterEntity getMitarbeiterEntityById(Integer id) {
        return mitarbeiterRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
    }

    public void delete(int employeeID) {
        MitarbeiterEntity mitarbeiterEntity = mitarbeiterRepo.findById(employeeID);
        zugangsRepo.deleteByUsername(mitarbeiterEntity.getEmail());
        mitarbeiterRepo.deleteById(mitarbeiterEntity.getId());
    }

    public MitarbeiterDTO createEmployee(CreateEmployeeDTO createEmployeeDTO) {
        MitarbeiterEntity mitarbeiterEntity = new MitarbeiterEntity();
        ZugangEntity zugangEntity = new ZugangEntity();
        AbteilungEntity abteilungEntity = abteilungsRepo.findById(createEmployeeDTO.getAbteilung());

        mitarbeiterEntity.setAbteilung(abteilungEntity);
        mitarbeiterEntity.setTelnr(createEmployeeDTO.getTelnr());
        mitarbeiterEntity.setName(createEmployeeDTO.getName());
        mitarbeiterEntity.setNachname(createEmployeeDTO.getNachname());
        mitarbeiterEntity.setEmail(createEmployeeDTO.getEmail());
        mitarbeiterEntity.setAnschrift(createEmployeeDTO.getAnschrift());

        MitarbeiterDTO me = Mitarbeiter.mapEntityToDTO(mitarbeiterRepo.save(mitarbeiterEntity));

        zugangEntity.setAuthority(createEmployeeDTO.getAuthority());
        zugangEntity.setUsername(createEmployeeDTO.getEmail());
        zugangEntity.setPassword(passwordEncoder.encode(createEmployeeDTO.getPassword()));
        zugangsRepo.save(zugangEntity);
        return me;

    }

    public MitarbeiterDTO updateEmployee(MitarbeiterDTO mitarbeiterDTO) {
        AbteilungEntity abteilungEntity = abteilungsRepo.findById(mitarbeiterDTO.getAbteilung());
        ZugangEntity zugang = zugangsRepo.findByUsername(mitarbeiterDTO.getEmail()).orElseThrow();
        MitarbeiterEntity me = Mitarbeiter.mapDTOToEntity(mitarbeiterDTO, abteilungEntity, zugang);
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

    public Set<MitarbeiterEntity> getEmployeeEntities(Set<String> emailsOfEmployees) {
        return new HashSet<MitarbeiterEntity>(mitarbeiterRepo.findAllByEmail(emailsOfEmployees));
    }
}
