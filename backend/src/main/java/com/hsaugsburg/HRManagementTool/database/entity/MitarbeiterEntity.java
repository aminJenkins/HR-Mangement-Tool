package com.hsaugsburg.HRManagementTool.database.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "MITARBEITER")
@Table(name = "MITARBEITER")
public class MitarbeiterEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    private int id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "NACHNAME", nullable = false)
    private String nachname;

    @Column(name = "TELNR", nullable = false, columnDefinition = "VARCHAR(15)")
    private String telnr;

    @Column(name = "MAIL", unique = true, nullable = false, columnDefinition = "VARCHAR(50)")
    private String email;

    @Column(name = "ANSCHRIFT", nullable = false, columnDefinition = "VARCHAR(100)")
    private String anschrift;

    @ManyToOne
    @JoinColumn(name="ABTEILUNG", nullable = false)
    private AbteilungEntity abteilung;

//    @OneToOne(fetch = FetchType.LAZY, targetEntity = ZugangEntity.class)
//    @JoinColumn(name = "MAIL", referencedColumnName = "USERNAME", unique = true)
//    private ZugangEntity zugangEntity;

    @OneToMany(mappedBy = "leiter", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ProjektEntity> projekteInFuehrung = new HashSet<>();

    @OneToMany(mappedBy = "ersteller", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<TerminEntity> hostTermine = new HashSet<>();

    @OneToMany(mappedBy = "mitarbeiter", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@Column(name = "PROJEKT_IN_FUEHRUNG", nullable = true, updatable = true)
    private Set<ZeiterfassungEntity> zeiterfassungen;

    @OneToMany(mappedBy = "leiter", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<AbteilungEntity> abteilungenInLeitung = new HashSet<>();

    @ManyToMany(mappedBy = "terminTeilnehmer")
    private Set<TerminEntity> teilnehmerTermine;

    @ManyToMany
    @JoinTable(name = "PROJEKTVERTEILUNG",
            joinColumns = {@JoinColumn(name = "MITARBEITER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PROJEKT_ID")})
    private Set<ProjektEntity> projekte;

}