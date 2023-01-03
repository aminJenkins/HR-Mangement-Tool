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

    @Query(value = "SELECT t FROM TERMIN t join t.terminTeilnehmer d WHERE (t.ersteller.id = ?2 OR d.id = ?2) AND t.datum = ?1  ORDER BY t.beginn ASC")
    public List<TerminEntity> findAppointmentsByDate(LocalDate startDate, int userId);


}
