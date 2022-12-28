package com.hsaugsburg.HRManagementTool.services;

import com.hsaugsburg.HRManagementTool.database.entity.ProjektEntity;
import com.hsaugsburg.HRManagementTool.database.repository.ProjektRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjektService {
    @Autowired
    private ProjektRepo projektRepo;

    public ProjektEntity getProjektEntity(int projektID){
        return projektRepo.findById(projektID);
    }
}
