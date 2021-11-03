package tn.esprit.spring.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.DataBaseConnection;
import tn.esprit.spring.services.EntrepriseServiceImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseServiceImplTest {

    @Autowired
    EntrepriseServiceImpl es;

    @Test
    public void testRetrieveAllEntreprises() throws SQLException {
        Connection con
                = DataBaseConnection.getConnection();
        Statement s = con.createStatement();
        ResultSet r = s.executeQuery("SELECT COUNT(*) AS rowcount FROM Entreprise");
        r.next();

        int count = r.getInt("rowcount");
        r.close();


        List<Entreprise> listEntreprises = es.retrieveAllEntreprises();
        System.out.println(count);
        Assert.assertEquals(count, listEntreprises.size());
    }

    @Test
    public void testAddEntreprise(){
        Entreprise e = new Entreprise("ESPRIT","SARL");
        Entreprise entrepriseAdded = es.addEntreprise(e);
        Assert.assertEquals(e.getName(),entrepriseAdded.getName());
    }

    @Test
    public void testModifyEntreprise() {
        Entreprise e = new Entreprise("ESPRIT","SARL");
        Entreprise entrepriseUpdated = es.updateEntreprise(e);
        Assert.assertEquals(e.getName(),entrepriseUpdated.getName());
    }

    @Test
    public void testRetrieveEntreprise() {
        Entreprise entrepriseRetrieved = es.retrieveEntreprise(128L);
        Assert.assertEquals(128L, entrepriseRetrieved.getId().longValue());
    }

    @Test
    public void testDeleteEntreprise() throws SQLException {
        Connection con
                = DataBaseConnection.getConnection();
        Statement s = con.createStatement();
        ResultSet r = s.executeQuery("SELECT * FROM entreprise ORDER BY id DESC LIMIT 1");
        r.next();
        Long id = r.getLong("id");
        es.deleteEntreprise(id);
        Assert.assertNull(es.retrieveEntreprise(id));
    }
}
