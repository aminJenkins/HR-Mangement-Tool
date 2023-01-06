package com.hsaugsburg.HRManagementTool.database.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "PROJECT")
public class ProjektEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    private int id;

    @Column(name = "STUNDENSATZ", nullable = false)
    private double stundensatz;

    @Column(name = "BUDGET_IN_ARBEITSTAGEN", nullable = false, columnDefinition = "DECIMAL(100,2)")
    private double budget;

    @Column(name = "AUFTRAGSGEBER", nullable = false)
    private String auftragsgeber;

    @Column(name = "BEZEICHNUNG", nullable = false)
    private String bezeichnung;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.REMOVE)
    @JoinColumn(name = "PROJEKT_LEITER", referencedColumnName = "ID", nullable = false)
    private MitarbeiterEntity leiter;

    @OneToMany(mappedBy = "projekt", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ZeiterfassungEntity> zeiterfassungen;

    @OneToMany(mappedBy = "projekt", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<TerminEntity> termine;


    @ManyToMany
    @JoinTable(name = "KONTINGENT_PROJEKT",
            joinColumns = {@JoinColumn(name = "PROJEKT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "KONTINGENT_ID")})
    private Set<KontingentEntity> kontingente;


    @ManyToMany
    @JoinTable(name = "PROJEKTVERTEILUNG",
            joinColumns = {@JoinColumn(name = "PROJEKT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "MITARBEITER_ID")})
    private Set<MitarbeiterEntity> projektbeteiligte;


}
