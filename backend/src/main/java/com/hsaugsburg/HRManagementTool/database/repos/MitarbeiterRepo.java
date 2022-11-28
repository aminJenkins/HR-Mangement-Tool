package com.hsaugsburg.HRManagementTool.database.repos;

import com.hsaugsburg.HRManagementTool.database.DAO.MitarbeiterDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MitarbeiterRepo extends JpaRepository<MitarbeiterDAO,Integer> {
}
