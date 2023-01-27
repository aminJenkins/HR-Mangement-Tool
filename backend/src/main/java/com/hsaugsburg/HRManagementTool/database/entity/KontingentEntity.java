package com.hsaugsburg.HRManagementTool.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "KONTINGENT")
public class KontingentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private int id;

    @Column(name = "BEZEICHNUNG", nullable = false)
    private String bezeichnung;

    @ManyToMany(mappedBy = "kontingente")
    private Set<ProjektEntity> projekte;

    @OneToMany(mappedBy = "kontingent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ZeiterfassungEntity> zeiterfassungen;
}
