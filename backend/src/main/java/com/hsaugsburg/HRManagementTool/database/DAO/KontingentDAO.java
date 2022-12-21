package com.hsaugsburg.HRManagementTool.database.DAO;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="KONTINGENT")
public class KontingentDAO {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private int id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "KONTINGENT_PROJEKT",
            joinColumns = {@JoinColumn(name = "KONTINGENT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PROJEKT_ID")})
    private Set<ProjektDAO> projekte;

    @ManyToMany
    @JoinTable(name = "KONTINGENTE_ZEITERFASSUNG",
            joinColumns = {@JoinColumn(name = "KONTINGENT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "ZEITERFASSUNG_ID")})
    private Set<ZeiterfassungDAO> zeiterfassungen;

    @Column(name = "BEZEICHNUNG", nullable = false)
    private String bezeichnung;
}
