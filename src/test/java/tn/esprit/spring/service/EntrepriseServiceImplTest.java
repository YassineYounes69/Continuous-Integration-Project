package tn.esprit.spring.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.EntrepriseServiceImpl;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseServiceImplTest {

    @Autowired
    EntrepriseServiceImpl es;

    @Test
    public void testRetrieveAllEntreprises(){
        List<Entreprise> listEntreprises = es.retrieveAllEntreprises();
        Assert.assertEquals(3, listEntreprises.size());
    }

    @Test
    public void testAddEntreprise(){
        Entreprise e = new Entreprise("ESPRIT","SARL");
        Entreprise entrepriseAdded = es.addEntreprise(e);
        Assert.assertEquals(e.getName(),entrepriseAdded.getName());
    }

    @Test
    public void testModifyUser() {
        Entreprise e = new Entreprise("ESPRIT","SARL");
        Entreprise entrepriseUpdated = es.updateEntreprise(e);
        Assert.assertEquals(e.getName(),entrepriseUpdated.getName());
    }

    @Test
    public void testRetrieveEntreprise() {
        Entreprise entrepriseRetrieved = es.retrieveEntreprise(1L);
        Assert.assertEquals(1L, entrepriseRetrieved.getId().longValue());
    }

    @Test
    public void testDeleteEntreprise() {
        es.deleteEntreprise(3L);
        Assert.assertNull(es.retrieveEntreprise(3L));
    }

}
