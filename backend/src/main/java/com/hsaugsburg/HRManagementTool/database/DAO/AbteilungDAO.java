package com.hsaugsburg.HRManagementTool.database.DAO;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ABTEILUNG")
public class AbteilungDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private int id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "LEITER", referencedColumnName = "ID")
    private MitarbeiterDAO leiter;

    @OneToMany(mappedBy="abteilung")
    @Column(name = "MITARBEITER", nullable = false)
    private Set<MitarbeiterDAO> mitarbeitern;
}
