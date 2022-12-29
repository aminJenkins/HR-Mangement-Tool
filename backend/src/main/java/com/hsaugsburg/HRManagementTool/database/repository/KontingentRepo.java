package com.hsaugsburg.HRManagementTool.database.repository;

import java.util.List;
import java.util.Set;

import com.hsaugsburg.HRManagementTool.database.entity.KontingentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KontingentRepo extends JpaRepository<KontingentEntity,Integer> {
    KontingentEntity findById(int id);
    List<KontingentEntity> findAll();
}
