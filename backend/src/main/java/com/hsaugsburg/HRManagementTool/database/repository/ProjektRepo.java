package com.hsaugsburg.HRManagementTool.database.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.hsaugsburg.HRManagementTool.database.entity.ProjektEntity;
import com.hsaugsburg.HRManagementTool.models.Projekt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjektRepo extends JpaRepository<ProjektEntity,Integer> {

    ProjektEntity findById(int id);

    Optional<ProjektEntity> findByBezeichnung(String bezeichnung);

    @Query(value = "SELECT * FROM PROJECT P WHERE :id IN (SELECT MITARBEITER_ID FROM PROJEKTVERTEILUNG V WHERE V.PROJEKT_ID = P.ID)", nativeQuery = true)
    Set<ProjektEntity> findByMitarbeiterID(int id);

}
