package com.hsaugsburg.HRManagementTool.database.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "zugang")
@Table(name = "ZUGANGS_DATEN")
@NoArgsConstructor
@AllArgsConstructor
public class ZugangEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private int id;

    @Column(name = "USERNAME", unique = true, nullable = false)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "AUTHORITY", nullable = false)
    private String authority;

//    @OneToOne(mappedBy = "zugangEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private MitarbeiterEntity mitarbeiter;

    public ZugangEntity(String username, String password, String authority) {
        this.username = username;
        this.password = password;
        this.authority = authority;
    }
}
