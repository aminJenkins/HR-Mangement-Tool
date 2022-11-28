package com.hsaugsburg.HRManagementTool.database.DAO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

//ToDO Multiple PK erstellen
@Entity
@Table(name="ZUGANGSDATEN")
@IdClass(ZugangDAO.ZugangID.class)
public class ZugangDAO {
    @Id
    @Column(name = "USERNAME", unique = true, nullable = false)
    private String username;

    @Id
    @Column(name = "PASSWORD", unique = false, nullable = false)
    private String password;

    public class ZugangID implements Serializable {
        private String username;
        private String password;

        public ZugangID(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }
}
