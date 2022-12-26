package com.hsaugsburg.HRManagementTool.database.repository;

import com.hsaugsburg.HRManagementTool.database.entity.ZugangEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ZugangsRepo extends JpaRepository<ZugangEntity, Integer> {

     Optional<ZugangEntity> findByUsername(String username);
}
