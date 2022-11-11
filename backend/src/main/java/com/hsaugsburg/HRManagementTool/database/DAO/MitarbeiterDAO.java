package com.hsaugsburg.HRManagementTool.database.DAO;

import java.util.List;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@NoArgsConstructor
@Entity(name = "mitarbeiter")
public class MitarbeiterDAO {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "mitarbeiter_id", unique = true, nullable = false, updatable = false, columnDefinition = "BINARY(16)")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "nachname", nullable = false)
    private String nachname;

    @ManyToOne
    @JoinColumn(name="abteilung_id")
    //@Column(name = "abteilung", nullable = false, updatable = true, columnDefinition = "BINARY(16)")
    private AbteilungDAO abteilung;

    @OneToMany(mappedBy="mitarbeiter")
    private Set<TerminDAO> termine;

//    @OneToMany(mappedBy = "mitarbeiter")
//    private Set<ZeiterfassungDAO> zeiterfassungEinträge;

    @Column(name = "telnr", nullable = false, updatable = true, columnDefinition = "VARCHAR(15)")
    private String telnr;

    @Column(name = "email", nullable = false, updatable = true, columnDefinition = "VARCHAR(50)")
    private String email;

    @Column(name = "anschrift", nullable = false, updatable = true, columnDefinition = "VARCHAR(100)")
    private String anschrift;

    @ManyToOne
    //@JoinColumn(name="mitarbeiter_id")
    //@Column(name = "vorgesetzer", nullable = true, updatable = true)
    private MitarbeiterDAO vorgesetzer;

    @OneToMany(mappedBy="vorgesetzer")
    //@Column(name = "untergeordneteMitarbeiter", nullable = true, updatable = true)
    private Set<MitarbeiterDAO> untergeordneteMitarbeiter;

    @Column(name = "rolle", nullable = false, updatable = true)
    private String rolle;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "mitarbeiter_projekt",
            joinColumns = { @JoinColumn(name = "mitarbeiter_id") },
            inverseJoinColumns = { @JoinColumn(name = "projekt_id") }
    )
    private List<ProjektDAO> projekte;



}