package com.hsaugsburg.HRManagementTool.services;

import java.util.Set;

import com.hsaugsburg.HRManagementTool.database.entity.ProjektEntity;
import com.hsaugsburg.HRManagementTool.database.repository.ProjektRepo;
import com.hsaugsburg.HRManagementTool.dto.ProjektDTO;
import com.hsaugsburg.HRManagementTool.models.Projekt;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjektService {
    @Autowired
    private ProjektRepo projektRepo;
    @Autowired
    private MitarbeiterService mitarbeiterService;

    public ProjektEntity getProjektEntity(int projektID) {
        return projektRepo.findById(projektID);
    }

    public Set<ProjektDTO> getProjektDTOs(String userMail) {

        return Projekt.parseEntitiesToDTOs(
                projektRepo.findByMitarbeiterID(mitarbeiterService.getMitarbeiterDTO(userMail).getId()));
    }

}
