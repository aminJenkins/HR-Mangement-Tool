package com.hsaugsburg.HRManagementTool.database.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "PROJECT")
public class Projekt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROJEKT_LEITER", referencedColumnName = "ID",
            insertable = false, updatable = true, nullable = false)
    private Mitarbeiter leiter;

    @ManyToMany(mappedBy = "projekte")
    //@Column(name = "ZEITERFASSUNG", nullable = true, updatable = true)
    private Set<Zeiterfassung> zeiterfassungen;

    @Column(name = "STUNDENSATZ", nullable = false)
    private Double stundensatz;

    @Column(name = "BUDGET_IN_ARBEITSTAGEN", nullable = false, updatable = true, columnDefinition = "DECIMAL(100,2)")
    private double budget;

    @Column(name = "AUFTRAGSGEBER", nullable = false, updatable = true)
    private String auftragsgeber;

    @Column(name = "BEZEICHNUNG", nullable = false, updatable = true)
    private String bezeichnung;

    @OneToMany(mappedBy = "projekt")
    //@Column(name = "TERMIN", insertable = false, updatable = true, nullable = true)
    private Set<Termin> termine;

    @ManyToMany(mappedBy = "projekte")
    private Set<Kontingent> kontingente;

    @ManyToMany(mappedBy = "projekte")
    private Set<Mitarbeiter> projektbeteiligte;


}
