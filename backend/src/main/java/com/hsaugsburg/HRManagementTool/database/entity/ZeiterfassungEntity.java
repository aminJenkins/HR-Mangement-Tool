package com.hsaugsburg.HRManagementTool.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "ZEITERFASSUNG")
public class ZeiterfassungEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "MITARBEITER_ID", nullable = false, referencedColumnName = "ID")
    private MitarbeiterEntity mitarbeiter;

    @ManyToOne
    @JoinColumn(name = "Projekt_ID", referencedColumnName = "ID")
    private ProjektEntity projekt;

    @ManyToOne
    @JoinColumn(name = "KONTINGENT_ID", nullable = false, referencedColumnName = "ID")
    private KontingentEntity kontingent;

    @Column(name = "KOMMENTAR", nullable = false)
    private String kommentar;

    @Column(name = "DAUER", nullable = false)
    private double dauer;

    @Column(name = "DATUM", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime datum;
}
