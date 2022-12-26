package com.hsaugsburg.HRManagementTool;

import com.hsaugsburg.HRManagementTool.database.repository.MitarbeiterRepo;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MitarbeiterEntityTest {
    @Autowired
    MitarbeiterRepo repo;

    @Before
    public void setup(){
  /*      MitarbeiterDAO mitarbeiterDAO=new MitarbeiterDAO();
        mitarbeiterDAO.setTelnr();
        mitarbeiterDAO.setName();
        mitarbeiterDAO.setNachname();
        mitarbeiterDAO.setEmail();
        mitarbeiterDAO.setAnschrift();
        mitarbeiterDAO.setAbteilung();
        mitarbeiterDAO.set
        repo.*/
    }
}
