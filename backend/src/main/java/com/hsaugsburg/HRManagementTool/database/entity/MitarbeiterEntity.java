package com.hsaugsburg.HRManagementTool.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "MITARBEITER")
@Table(name = "MITARBEITER")
public class MitarbeiterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @JoinColumn(name = "ABTEILUNG", nullable = false)
    private AbteilungEntity abteilung;

    @OneToMany(mappedBy = "leiter", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ProjektEntity> projekteInFuehrung = new HashSet<>();

    @OneToMany(mappedBy = "ersteller", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<TerminEntity> hostTermine = new HashSet<>();

    @OneToMany(mappedBy = "mitarbeiter", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ZeiterfassungEntity> zeiterfassungen;

    @OneToMany(mappedBy = "leiter", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<AbteilungEntity> abteilungenInLeitung = new HashSet<>();

    @ManyToMany(mappedBy = "terminTeilnehmer")
    private Set<TerminEntity> teilnehmerTermine;

    @ManyToMany(mappedBy = "projektbeteiligte")
    private Set<ProjektEntity> projekte;

}