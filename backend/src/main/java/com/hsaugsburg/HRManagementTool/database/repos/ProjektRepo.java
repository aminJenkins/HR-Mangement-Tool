package com.hsaugsburg.HRManagementTool.database.repos;

import com.hsaugsburg.HRManagementTool.database.DAO.ProjektDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjektRepo extends JpaRepository<ProjektDAO,Integer> {
}
