package com.hsaugsburg.HRManagementTool.database.repository;

import com.hsaugsburg.HRManagementTool.database.entity.MitarbeiterEntity;
import com.hsaugsburg.HRManagementTool.database.entity.ZugangEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ZugangsRepo extends JpaRepository<ZugangEntity, Integer> {

     Optional<ZugangEntity> findByUsername(String username);

    @Transactional
    @Modifying
    @Query(value="DELETE FROM ZUGANGS_DATEN Z WHERE Z.USERNAME=:email",nativeQuery = true)
    void deleteByEmail(String email);
}
