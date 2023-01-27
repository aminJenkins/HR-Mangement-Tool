package com.hsaugsburg.HRManagementTool.database.repository;

import com.hsaugsburg.HRManagementTool.database.entity.ZeiterfassungEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ZeiterfassungRepo extends JpaRepository<ZeiterfassungEntity, Integer> {
    @Query(value = "SELECT * FROM ZEITERFASSUNG WHERE MITARBEITER_ID= (SELECT U.ID FROM MITARBEITER U WHERE U.MAIL = :email)", nativeQuery = true)
    Set<ZeiterfassungEntity> findTimeTracksForEmploye(@Param("email") String userMail);

    @Query(value = "SELECT * FROM ZEITERFASSUNG WHERE MITARBEITER_ID= (SELECT U.ID FROM MITARBEITER U WHERE U.MAIL = :email) ORDER BY DATUM DESC", nativeQuery = true)
    Set<ZeiterfassungEntity> getAllSortedByDate(@Param("email") String userMail);
}
