package com.hsaugsburg.HRManagementTool.database.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="KONTINGENT")
public class KontingentEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private int id;

    @Column(name = "BEZEICHNUNG", nullable = false)
    private String bezeichnung;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    @JoinTable(name = "KONTINGENT_PROJEKT",
            joinColumns = {@JoinColumn(name = "KONTINGENT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PROJEKT_ID")})
    private Set<ProjektEntity> projekte;

    @OneToMany(mappedBy = "kontingent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ZeiterfassungEntity> zeiterfassungen;
}
