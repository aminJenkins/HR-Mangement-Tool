package com.hsaugsburg.HRManagementTool.database.repository;

import com.hsaugsburg.HRManagementTool.database.entity.MitarbeiterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Repository
public interface MitarbeiterRepo extends JpaRepository<MitarbeiterEntity,Integer> {
    MitarbeiterEntity findByEmail(String userMail);

    @Query(value="SELECT * FROM MITARBEITER M  WHERE M.MAIL IN :emails",nativeQuery = true)
    List<MitarbeiterEntity> findAllByEmail(Set<String> emails);

    List<MitarbeiterEntity> findAll();

    MitarbeiterEntity findById(int id);

//    @Transactional
//    @Modifying
//    @Query(value="DELETE FROM MITARBEITER M  WHERE M.ID= :id",nativeQuery = true)
//    Integer deleteById(int id);
    @Transactional
    void deleteById(int id);
}
