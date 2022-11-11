package com.hsaugsburg.HRManagementTool.database.DAO;

import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;


@Entity(name = "abteilung")
public class AbteilungDAO {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "abteilung_id", unique = true, nullable = false, updatable = false, columnDefinition = "BINARY(16)")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "abteilung_projekt",
            joinColumns = { @JoinColumn(name = "abteilung_id") },
            inverseJoinColumns = { @JoinColumn(name = "projekt_id") }
    )
    private Set<ProjektDAO> projekte;

    @OneToMany(mappedBy="abteilung")
    //@Column(name = "mitarbeiter", nullable = false)
    private Set<MitarbeiterDAO> mitarbeitern;
}
