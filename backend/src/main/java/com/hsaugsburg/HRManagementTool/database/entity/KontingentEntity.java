package com.hsaugsburg.HRManagementTool.database.entity;

import lombok.Getter;
import lombok.Setter;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name="KONTINGENT")
public class KontingentEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private int id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "KONTINGENT_PROJEKT",
            joinColumns = {@JoinColumn(name = "KONTINGENT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PROJEKT_ID")})
    private Set<ProjektEntity> projekte;

    @OneToMany(mappedBy = "kontingent")
    private Set<ZeiterfassungEntity> zeiterfassungen;

    @Column(name = "BEZEICHNUNG", nullable = false)
    private String bezeichnung;
}
