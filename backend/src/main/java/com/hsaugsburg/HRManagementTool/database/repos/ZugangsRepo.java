package com.hsaugsburg.HRManagementTool.database.repos;

import com.hsaugsburg.HRManagementTool.database.DAO.ZugangDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZugangsRepo extends JpaRepository<ZugangDAO, ZugangDAO.ZugangID> {
}
