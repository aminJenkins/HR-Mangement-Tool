package com.hsaugsburg.HRManagementTool.database.entity;

import com.hsaugsburg.HRManagementTool.models.Priority;
import lombok.Getter;
import lombok.Setter;
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

    @Column(name = "TITEL", nullable = false)
    private String titel;

    @Column(name = "BESCHREIBUNG", nullable = false)
    private String beschreibung;

    @ManyToOne
    @JoinColumn(name = "PROJEKT_ID", referencedColumnName = "ID")
    private ProjektEntity projekt;

    @ManyToOne
    @JoinColumn(name = "ERSTELLER", updatable = false)
    private MitarbeiterEntity ersteller;

    @ManyToMany(mappedBy = "teilnehmerTermine")
    private Set<MitarbeiterEntity> terminTeilnehmern;

    @Column(name = "BEGINN", nullable = false)
    private LocalTime beginn;

    @Column(name = "ENDE", nullable = false)
    private LocalTime ende;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATUM", nullable = false)
    private Date datum;

    @Enumerated(EnumType.STRING)
    @Column(name = "PRIORITY", nullable = false)
    private Priority priority;

}
