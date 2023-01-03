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

    @Query(value = " SELECT * FROM TERMIN WHERE ERSTELLER_ID = :userId AND (DATUM BETWEEN :startDate AND :endDate)", nativeQuery = true)
    public List<TerminEntity> findAppointmentsByDateRange(LocalDate startDate, LocalDate endDate, int userId);

    @Query(value = "SELECT * FROM TERMIN WHERE ERSTELLER_ID = :userId AND DATUM = :startDate ORDER BY BEGINN ASC", nativeQuery = true)
    public List<TerminEntity> findAppointmentsByDate(LocalDate startDate, int userId);


}
