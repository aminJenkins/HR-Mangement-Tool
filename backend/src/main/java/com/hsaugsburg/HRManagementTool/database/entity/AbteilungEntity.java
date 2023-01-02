package com.hsaugsburg.HRManagementTool.database.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

import javax.persistence.*;

@Getter
@Setter
@Entity(name="abteilung")
@Table(name = "ABTEILUNG")
public class AbteilungEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private int id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "LEITER", referencedColumnName = "ID")
    private MitarbeiterEntity leiter;

    @OneToMany(mappedBy="abteilung", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<MitarbeiterEntity> zugeteilteMitarbeiter;
}
