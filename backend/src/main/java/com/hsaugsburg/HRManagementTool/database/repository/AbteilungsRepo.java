package com.hsaugsburg.HRManagementTool.database.repository;

import java.util.List;

import com.hsaugsburg.HRManagementTool.database.entity.AbteilungEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbteilungsRepo extends JpaRepository<AbteilungEntity,Integer> {
    AbteilungEntity findById(int id);
    List<AbteilungEntity> findAll();
}
