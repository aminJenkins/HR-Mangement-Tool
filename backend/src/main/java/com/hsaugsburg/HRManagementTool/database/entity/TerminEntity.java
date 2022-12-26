package com.hsaugsburg.HRManagementTool.database.entity;

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

    @Column(name = "BETREFF", nullable = false)
    private String betreff;

    @Column(name = "BESCHREIBUNG", nullable = false)
    private String beschreibung;

    @ManyToOne
    @JoinColumn(name = "PROJEKT_ID", referencedColumnName = "ID",
            insertable = false, updatable = true, nullable = false)
    private ProjektEntity projekt;

    @ManyToMany(mappedBy = "termine")
    private Set<MitarbeiterEntity> teilnehmern;

    @Column(name = "BEGINN", nullable = false)
    private LocalTime beginn;

    @Column(name = "ENDE", nullable = false)
    private LocalTime ende;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATUM", nullable = false)
    private Date datum;
}
