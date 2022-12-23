package com.hsaugsburg.HRManagementTool.database.repos;

import com.hsaugsburg.HRManagementTool.database.DAO.AbteilungDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbteilungsRepo extends JpaRepository<AbteilungDAO,Integer> {
}
