package com.hsaugsburg.HRManagementTool.database.repository;

import java.util.Set;

import com.hsaugsburg.HRManagementTool.database.entity.ProjektEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProjektRepo extends JpaRepository<ProjektEntity,Integer> {

    ProjektEntity findById(int id);

    @Query(value = "SELECT * FROM PROJECT P WHERE :id IN (SELECT MITARBEITER_ID FROM PROJEKTVERTEILUNG V WHERE V.PROJEKT_ID = P.ID)", nativeQuery = true)
    Set<ProjektEntity> findByMitarbeiterID(int id);

    @Transactional
    void deleteById(int id);

}
