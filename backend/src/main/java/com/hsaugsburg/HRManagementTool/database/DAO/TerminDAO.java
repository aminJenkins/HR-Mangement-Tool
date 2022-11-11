package com.hsaugsburg.HRManagementTool.database.DAO;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "termin")
public class TerminDAO {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "termin_id", unique = true, nullable = false, updatable = false, columnDefinition = "BINARY(16)")
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", nullable = false)
    private Date dateTime;

    @ManyToOne
    @JoinColumn(name="mitarbeiter")
    private MitarbeiterDAO mitarbeiter;
}
