package com.hsaugsburg.HRManagementTool.database.DAO;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "TERMIN")
public class TerminDAO {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "PROJEKT_ID", referencedColumnName = "ID",
            insertable = false, updatable = true, nullable = false)
    private ProjektDAO projekt;

    @ManyToMany(mappedBy = "termine")
    private Set<MitarbeiterDAO> teilnehmern;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "VON", nullable = false)
    private Date von;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "BIS", nullable = false)
    private Date bis;
}
