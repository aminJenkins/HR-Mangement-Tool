package com.hsaugsburg.HRManagementTool.services;

import com.hsaugsburg.HRManagementTool.database.repository.AbteilungsRepo;
import com.hsaugsburg.HRManagementTool.dto.AbteilungDTO;
import com.hsaugsburg.HRManagementTool.models.Abteilung;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AbteilungService {

    @Autowired
    AbteilungsRepo abteilungsRepo;

    public Set<AbteilungDTO> getDepartments() {
        return Abteilung.parseEntitiesToDTOs(new HashSet<>(abteilungsRepo.findAll()));
    }
}
