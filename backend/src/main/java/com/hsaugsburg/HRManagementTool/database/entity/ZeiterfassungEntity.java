package com.hsaugsburg.HRManagementTool.database.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
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
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name="ZEITERFASSUNG")
public class ZeiterfassungEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "MITARBEITER_ID", unique = true, nullable = false, referencedColumnName = "ID",
            insertable = false, updatable = false)
    private MitarbeiterEntity mitarbeiter;

    @ManyToMany
    @JoinTable(
            name = "ZEITERFASSUNG_PROJEKT",
            joinColumns = @JoinColumn(name = "ZEITERFASSUNG_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROJEKT_ID"))
    private Set<ProjektEntity> projekte;

    @ManyToMany(mappedBy = "zeiterfassungen")
    private Set<KontingentEntity> kontingente;

    @Column(name = "KOMMENTAR", nullable = false)
    private String kommentar;

    @Column(name = "DAUER", nullable = false)
    private double dauer;

    @Column(name = "DATUM", nullable = false)
    private Date datum;
}
