package com.hsaugsburg.HRManagementTool.database.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "PROJEKT")
public class ProjektEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROJEKT_LEITER", referencedColumnName = "ID",
            insertable = false, updatable = true, nullable = false)
    private MitarbeiterEntity leiter;

    @OneToMany(mappedBy = "projekt")
    //@Column(name = "ZEITERFASSUNG", nullable = true, updatable = true)
    private Set<ZeiterfassungEntity> zeiterfassungen;

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
    private Set<TerminEntity> termine;

    @ManyToMany(mappedBy = "projekte")
    private Set<KontingentEntity> kontingente;

    @ManyToMany(mappedBy = "projekte")
    private Set<MitarbeiterEntity> projektbeteiligte;


}
