package com.hsaugsburg.HRManagementTool.database.repository;

import com.hsaugsburg.HRManagementTool.database.entity.AbteilungEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbteilungsRepo extends JpaRepository<AbteilungEntity, Integer> {
    AbteilungEntity findById(int id);

    List<AbteilungEntity> findAll();
}
