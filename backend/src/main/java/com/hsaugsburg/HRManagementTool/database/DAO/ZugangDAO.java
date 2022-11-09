package com.hsaugsburg.HRManagementTool.database.DAO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.hsaugsburg.HRManagementTool.database.keys.ZugangsPK;

@Entity(name="zugang")
@IdClass(ZugangsPK.class)
public class ZugangDAO {
    @Id
    private String email;
    @Id
    private String password;
}
