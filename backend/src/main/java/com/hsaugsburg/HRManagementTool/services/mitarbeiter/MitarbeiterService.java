package com.hsaugsburg.HRManagementTool.services.mitarbeiter;

import com.hsaugsburg.HRManagementTool.database.entity.Mitarbeiter;
import com.hsaugsburg.HRManagementTool.database.repository.MitarbeiterRepo;
import com.hsaugsburg.HRManagementTool.dto.MitarbeiterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MitarbeiterService {

    @Autowired
    private MitarbeiterRepo mitarbeiterRepo;


    public MitarbeiterDto getMaByEmail(String email) {
        Mitarbeiter ma = mitarbeiterRepo.findByEmail(email);
        if(ma != null) {
            return new MitarbeiterDto(ma);
        }
        return null;
    }
}
