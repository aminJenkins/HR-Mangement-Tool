package com.hsaugsburg.HRManagementTool.database.repository;

import com.hsaugsburg.HRManagementTool.database.entity.MitarbeiterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MitarbeiterRepo extends JpaRepository<MitarbeiterEntity,Integer> {
    MitarbeiterEntity findByEmail(String email);
}
