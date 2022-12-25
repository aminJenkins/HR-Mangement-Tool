package com.hsaugsburg.HRManagementTool.database.repository;

import com.hsaugsburg.HRManagementTool.database.entity.Termin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerminRepo extends JpaRepository<Termin,Integer> {
}
