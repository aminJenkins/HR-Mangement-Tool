package com.hsaugsburg.HRManagementTool.database.repository;

import java.util.List;
import java.util.Set;

import com.hsaugsburg.HRManagementTool.database.entity.ZeiterfassungEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ZeiterfassungRepo extends JpaRepository<ZeiterfassungEntity,Integer> {
    @Query(value = "SELECT * FROM ZEITERFASSUNG WHERE MITARBEITER_ID= :id", nativeQuery = true)
    Set<ZeiterfassungEntity> findTimeTracksForEmploye(@Param("id") Integer id);

}
