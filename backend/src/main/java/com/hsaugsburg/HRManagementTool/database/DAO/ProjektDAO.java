package com.hsaugsburg.HRManagementTool.database.DAO;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "PROJEKT")
public class ProjektDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROJEKT_LEITER", referencedColumnName = "ID",
            insertable = false, updatable = true, nullable = false)
    private MitarbeiterDAO leiter;

    @ManyToMany(mappedBy = "projekte")
    //@Column(name = "ZEITERFASSUNG", nullable = true, updatable = true)
    private Set<ZeiterfassungDAO> zeiterfassungen;

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
    private Set<TerminDAO> termine;

    @ManyToMany(mappedBy = "projekte")
    private Set<KontingentDAO> kontingente;

    @ManyToMany(mappedBy = "projekte")
    private Set<MitarbeiterDAO> projektbeteiligte;


}
