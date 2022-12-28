package com.hsaugsburg.HRManagementTool.database.repository;

import java.util.Set;

import com.hsaugsburg.HRManagementTool.database.entity.MitarbeiterEntity;
import com.hsaugsburg.HRManagementTool.database.entity.ZeiterfassungEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MitarbeiterRepo extends JpaRepository<MitarbeiterEntity,Integer> {
    @Query(value = "SELECT * FROM MITARBEITER U WHERE U.MAIL = :email", nativeQuery = true)
    MitarbeiterEntity findMitarbeiterByMail(@Param("email") String userMail);
}
