package com.hsaugsburg.HRManagementTool.database.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "MITARBEITER")
public class Mitarbeiter {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    private int id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "NACHNAME", nullable = false)
    private String nachname;

    @OneToOne(mappedBy = "leiter")
    private Abteilung abteilungenInLeitung;

    @Column(name = "TELNR", nullable = false, updatable = true, columnDefinition = "VARCHAR(15)")
    private String telnr;

    @Column(name = "MAIL", nullable = false, updatable = true, columnDefinition = "VARCHAR(50)")
    private String email;

    @Column(name = "ANSCHRIFT", nullable = false, updatable = true, columnDefinition = "VARCHAR(100)")
    private String anschrift;

    @OneToMany(mappedBy = "leiter")
    @Column(name = "PROJEKT_IN_FUEHRUNG", nullable = true, updatable = true)
    private Set<Projekt> projekteInFuehrung;

    @OneToMany(mappedBy = "mitarbeiter")
    //@Column(name = "PROJEKT_IN_FUEHRUNG", nullable = true, updatable = true)
    private Set<Zeiterfassung> zeiterfassungen;

    @ManyToMany
    @JoinTable(name = "TERMIN_TEILNEHMER",
            joinColumns = {@JoinColumn(name = "MITARBEITER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "TERMIN_ID")})
    private Set<Termin> termine;

    @ManyToMany
    @JoinTable(name = "PROJEKTVERTEILUNG",
            joinColumns = {@JoinColumn(name = "MITARBEITER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PROJEKT_ID")})
    private Set<Projekt> projekte;

    @ManyToOne
    @JoinColumn(name="ABTEILUNG", nullable = false)
    private Abteilung abteilung;


}