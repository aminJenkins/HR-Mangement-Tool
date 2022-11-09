package com.hsaugsburg.HRManagementTool.database.DAO;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity(name="projekt")
public class ProjektDAO {
        @Id
        @GeneratedValue(generator = "uuid2")
        @GenericGenerator(name = "uuid2", strategy = "uuid2")
        @Column(name = "projekt_id", unique = true, nullable = false, updatable = false, columnDefinition = "BINARY(16)")
        private UUID id;

        @Column(name = "bezeichnung", nullable = false)
        private String bezeichnung;

        @ManyToMany(mappedBy = "projekte")
        //@JoinColumn(name="id",nullable = false , insertable = false, updatable = false)
        private List<MitarbeiterDAO> mitarbeitern;

        @ManyToMany(mappedBy = "projekte")
        //@JoinColumn(name="id", nullable=false, insertable = false, updatable = false)
        private Set<AbteilungDAO> abteilungen;

        @Column(name = "stundensatz", nullable = false, updatable = true, columnDefinition = "DECIMAL(100,2)")
        private double stundensatz;

        @Column(name = "budget", nullable = false, updatable = true, columnDefinition = "DECIMAL(100,2)")
        private double budget;

        @Column(name = "auftragsgeber", nullable = false, updatable = false)
        private String auftragsgeber;

}
