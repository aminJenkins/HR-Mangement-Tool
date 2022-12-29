package com.hsaugsburg.HRManagementTool.database.repository;

import com.hsaugsburg.HRManagementTool.database.entity.TerminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TerminRepo extends JpaRepository<TerminEntity,Integer> {
//    @Query("DELETE a.teilnehmer FROM TerminEntity a where a.id =: terminId " )
//    void deleteAllTeilnehmer(int terminId);


}
