package com.hsaugsburg.HRManagementTool.database.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "TERMIN")
public class TerminEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "PROJEKT_ID", referencedColumnName = "ID",
            insertable = false, updatable = true, nullable = false)
    private ProjektEntity projekt;

    @ManyToMany(mappedBy = "termine")
    private Set<MitarbeiterEntity> teilnehmern;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "VON", nullable = false)
    private Date von;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "BIS", nullable = false)
    private Date bis;
}
