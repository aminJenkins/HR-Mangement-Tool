package com.hsaugsburg.HRManagementTool.services;

import com.hsaugsburg.HRManagementTool.database.entity.AbteilungEntity;
import com.hsaugsburg.HRManagementTool.database.entity.MitarbeiterEntity;
import com.hsaugsburg.HRManagementTool.database.entity.ZugangEntity;
import com.hsaugsburg.HRManagementTool.database.repository.AbteilungsRepo;
import com.hsaugsburg.HRManagementTool.database.repository.MitarbeiterRepo;
import com.hsaugsburg.HRManagementTool.database.repository.ZugangsRepo;
import com.hsaugsburg.HRManagementTool.dto.MitarbeiterDTO;
import com.hsaugsburg.HRManagementTool.dto.ZugangDTO;
import com.hsaugsburg.HRManagementTool.dto.mitarbeiter.CreateEmployeeDTO;
import com.hsaugsburg.HRManagementTool.models.Mitarbeiter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
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

    @Autowired
    private PasswordEncoder passwordEncoder;

    public MitarbeiterDTO getMitarbeiterDTO(String userName) {
        MitarbeiterEntity maEntity = getMitarbeiterEntity(userName);
        return Mitarbeiter.mapEntityToDTO(maEntity);
    }

    public Set<MitarbeiterDTO> getAllEmaployees() {
        return Mitarbeiter.parseEntitiestoDTOs(new HashSet<MitarbeiterEntity>(mitarbeiterRepo.findAll()));
    }


    public MitarbeiterEntity getMitarbeiterEntity(String userName) {
        return mitarbeiterRepo.findByEmail(userName);
    }

    public void createMitarbeiter(MitarbeiterDTO mitarbeiter) {
        AbteilungEntity abteilungEntity = abteilungsRepo.findById(mitarbeiter.getAbteilung());
        ZugangEntity zugang = zugangsRepo.findByUsername(mitarbeiter.getEmail()).orElseThrow();
        mitarbeiterRepo.save(Mitarbeiter.mapDTOToEntity(mitarbeiter, abteilungEntity, zugang));
    }

    public void delete(int employeeID){
        MitarbeiterEntity mitarbeiterEntity = mitarbeiterRepo.findById(employeeID);
//        zugangsRepo.deleteByEmail(mitarbeiterEntity.getEmail());
//
//        System.out.print("ID "+employeeID);
        zugangsRepo.deleteByEmail(mitarbeiterEntity.getEmail());
        mitarbeiterRepo.deleteById(mitarbeiterEntity.getId());


    }

    public void createEmployee(CreateEmployeeDTO createEmployeeDTO){
        MitarbeiterEntity mitarbeiterEntity = new MitarbeiterEntity();
        ZugangEntity zugangEntity= new ZugangEntity();
        AbteilungEntity abteilungEntity = abteilungsRepo.findById(createEmployeeDTO.getAbteilung());

        mitarbeiterEntity.setAbteilung(abteilungEntity);
        mitarbeiterEntity.setTelnr(createEmployeeDTO.getTelnr());
        mitarbeiterEntity.setName(createEmployeeDTO.getName());
        mitarbeiterEntity.setNachname(createEmployeeDTO.getNachname());
        mitarbeiterEntity.setEmail(createEmployeeDTO.getEmail());
        mitarbeiterEntity.setAnschrift(createEmployeeDTO.getAnschrift());

        mitarbeiterRepo.save(mitarbeiterEntity);

        zugangEntity.setAuthority(createEmployeeDTO.getAuthority());
        zugangEntity.setUsername(createEmployeeDTO.getEmail());
        zugangEntity.setPassword(passwordEncoder.encode(createEmployeeDTO.getPassword()));
        zugangsRepo.save(zugangEntity);
    }

    public MitarbeiterDTO updateEmployee(MitarbeiterDTO mitarbeiterDTO) {
        System.out.println("in update employee:" + mitarbeiterDTO.toString());
        AbteilungEntity abteilungEntity = abteilungsRepo.findById(mitarbeiterDTO.getAbteilung());
        ZugangEntity zugang = zugangsRepo.findByUsername(mitarbeiterDTO.getEmail()).orElseThrow();
        System.out.println("abteilung: " + abteilungEntity.toString());
        MitarbeiterEntity me = Mitarbeiter.mapDTOToEntity(mitarbeiterDTO, abteilungEntity, zugang);
        System.out.println("MAEntity: "+ me.toString());
        MitarbeiterEntity updatedMitarbeiter = mitarbeiterRepo.save(me);
        return Mitarbeiter.mapEntityToDTO(updatedMitarbeiter);
    }

    public void checkIsAdminOrCorrectUser(Authentication authentication, String email) throws Exception {
        SimpleGrantedAuthority roleAdmin = new SimpleGrantedAuthority("ROLE_ADMIN");
        if (!authentication.getAuthorities().contains(roleAdmin)) {
            if (!authentication.getName().equals(email)) {
                System.out.println("darf nicht updaten");
                throw new Exception("You can only update your own user information");
            }
        }
    }

    public Set<MitarbeiterEntity> getEmployees(Set<String> emailsOfEmployees){
        return new HashSet<MitarbeiterEntity>(mitarbeiterRepo.findAllByEmail(emailsOfEmployees));
    }

}
