package com.hsaugsburg.HRManagementTool.database.entity;

import com.hsaugsburg.HRManagementTool.models.Priority;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "TERMIN")
public class Termin {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "PROJEKT_ID", referencedColumnName = "ID",
            insertable = false, updatable = true, nullable = false)
    private Projekt projekt;

    @ManyToMany(mappedBy = "termine")
    private Set<Mitarbeiter> teilnehmern;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "VON", nullable = false)
    private Date von;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "BIS", nullable = false)
    private Date bis;

    @Column(name = "BESCHREIBUNG", nullable = false, updatable = true)
    private String beschreibung;

    @Enumerated(EnumType.STRING)
    @Column(name = "PRIORITY", nullable = false, updatable = true)
    private Priority priority;
}
