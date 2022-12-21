package com.hsaugsburg.HRManagementTool.database.repos;

import com.hsaugsburg.HRManagementTool.database.DAO.KontingentDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KontingentRepo extends JpaRepository<KontingentDAO,Integer> {
}
