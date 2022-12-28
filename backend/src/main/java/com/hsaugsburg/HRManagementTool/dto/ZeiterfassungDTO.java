package com.hsaugsburg.HRManagementTool.dto;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hsaugsburg.HRManagementTool.database.entity.KontingentEntity;
import com.hsaugsburg.HRManagementTool.database.entity.MitarbeiterEntity;
import com.hsaugsburg.HRManagementTool.database.entity.ProjektEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ZeiterfassungDTO {
    private int id;
    private MitarbeiterEntity mitarbeiter;
    private Set<ProjektEntity> projekte;
    private Set<KontingentEntity> kontingente;
    private String kommentar;
    private double dauer;
    private Date datum;

}
