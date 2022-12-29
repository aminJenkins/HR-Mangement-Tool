package com.hsaugsburg.HRManagementTool.services;

import com.hsaugsburg.HRManagementTool.database.entity.AbteilungEntity;
import com.hsaugsburg.HRManagementTool.database.entity.MitarbeiterEntity;
import com.hsaugsburg.HRManagementTool.database.repository.AbteilungsRepo;
import com.hsaugsburg.HRManagementTool.database.repository.MitarbeiterRepo;
import com.hsaugsburg.HRManagementTool.dto.MitarbeiterDTO;
import com.hsaugsburg.HRManagementTool.models.Mitarbeiter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MitarbeiterService {
    @Autowired
    MitarbeiterRepo mitarbeiterRepo;
    @Autowired
    AbteilungsRepo abteilungsRepo;

    public MitarbeiterDTO getMitarbeiterDTO(String userName) {
        MitarbeiterEntity maEntity = getMitarbeiterEntity(userName);
        return Mitarbeiter.mapEntityToDTO(maEntity);
    }

    public MitarbeiterEntity getMitarbeiterEntity(String userName) {
        return mitarbeiterRepo.findByEmail(userName);
    }

    public void createMitarbeiter(MitarbeiterDTO mitarbeiter) {
        AbteilungEntity abteilungEntity = abteilungsRepo.findById(mitarbeiter.getAbteilung());
        mitarbeiterRepo.save(Mitarbeiter.mapDTOToEntity(mitarbeiter, abteilungEntity));
    }

    public MitarbeiterDTO updateEmployee(MitarbeiterDTO mitarbeiterDTO) {
        System.out.println("in update employee:" + mitarbeiterDTO.toString());
        AbteilungEntity abteilungEntity = abteilungsRepo.findById(mitarbeiterDTO.getAbteilung());
        System.out.println("abteilung: " + abteilungEntity.toString());
        MitarbeiterEntity me = Mitarbeiter.mapDTOToEntity(mitarbeiterDTO, abteilungEntity);
        System.out.println("MAEntity: "+ me.toString());
        MitarbeiterEntity updatedMitarbeiter = mitarbeiterRepo.save(me);
        return Mitarbeiter.mapEntityToDTO(updatedMitarbeiter);
    }

    public void checkAuthority(Authentication authentication, String email) throws Exception {
        SimpleGrantedAuthority roleAdmin = new SimpleGrantedAuthority("ROLE_ADMIN");
        if (!authentication.getAuthorities().contains(roleAdmin)) {
            if (!authentication.getName().equals(email)) {
                System.out.println("darf nicht updaten");
                throw new Exception("You can only update your own user information");
            }
        }
    }
}
