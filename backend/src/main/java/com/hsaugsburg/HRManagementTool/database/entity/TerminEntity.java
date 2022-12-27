package com.hsaugsburg.HRManagementTool.database.entity;

import com.hsaugsburg.HRManagementTool.models.Priority;
import com.hsaugsburg.HRManagementTool.models.Priority;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "TERMIN")
public class TerminEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    private int id;

    @Column(name = "TITEL", nullable = false,updatable = true)
    private String titel;

    @Column(name = "BESCHREIBUNG", nullable = false)
    private String beschreibung;

    @ManyToOne
    @JoinColumn(name = "PROJEKT_ID", referencedColumnName = "ID",
            insertable = false, updatable = true)
    private ProjektEntity projekt;

    @ManyToOne
    @JoinColumn(name = "MITARBEITER_ID", referencedColumnName = "id",updatable = false, nullable = false)
    private MitarbeiterEntity ersteller;

    @ManyToMany(mappedBy = "termine")
    private Set<MitarbeiterEntity> teilnehmern;

    @Column(name = "BEGINN", nullable = false)
    private LocalTime beginn;

    @Column(name = "ENDE", nullable = false)
    private LocalTime ende;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATUM", nullable = false)
    private Date datum;

    @Enumerated(EnumType.STRING)
    @Column(name = "PRIORITY", nullable = false, updatable = true)
    private Priority priority;

}
