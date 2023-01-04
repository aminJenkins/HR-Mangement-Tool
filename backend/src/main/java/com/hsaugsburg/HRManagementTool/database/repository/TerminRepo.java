package com.hsaugsburg.HRManagementTool.database.repository;

import com.hsaugsburg.HRManagementTool.database.entity.TerminEntity;
import net.bytebuddy.asm.Advice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TerminRepo extends JpaRepository<TerminEntity,Integer> {

    @Query(value = "SELECT * FROM TERMIN WHERE ERSTELLER_ID = :userId AND DATUM = :startDate UNION ( SELECT T.* FROM TERMIN T JOIN TERMIN_TEILNEHMER TD  ON T.ID = TD.TERMIN_ID WHERE MITARBEITER_ID =:userId AND T.DATUM = :startDate )",nativeQuery = true)
    public List<TerminEntity> findAppointmentsByDate(LocalDate startDate, int userId);


}
