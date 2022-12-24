package com.hsaugsburg.HRManagementTool.database.repository;

import com.hsaugsburg.HRManagementTool.database.entity.Zugang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ZugangsRepo extends JpaRepository<Zugang, Integer> {

     Optional<Zugang> findByUsername(String username);
}
