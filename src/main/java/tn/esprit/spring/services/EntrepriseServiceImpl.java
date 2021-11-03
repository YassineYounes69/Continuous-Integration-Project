package tn.esprit.spring.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.EntrepriseRepository;

import java.util.List;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService{

    @Autowired
    EntrepriseRepository entrepriseRepository;

    private static final Logger l = LogManager.getLogger(EntrepriseServiceImpl.class);

    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository) {
        this.entrepriseRepository = entrepriseRepository;
    }

    public EntrepriseServiceImpl() {
    }

    @Override
    public List<Entreprise> retrieveAllEntreprises() {
        List<Entreprise> entreprises = null;
        try {

            l.info("In retrieveAllEntreprises() : ");
            entreprises = (List<Entreprise>) entrepriseRepository.findAll();
            for (Entreprise entreprise : entreprises) {
                l.info("Entreprise +++ : " + entreprise.toString());

            }
            l.info("Out of retrieveAllEntreprises() : ");
        }catch (Exception e) {
            l.error("Error in retrieveAllEntreprises() : " + e);
        }

        return entreprises;
    }

    public Entreprise addEntreprise(Entreprise e) {
        l.info("fired method Entreprise.addEntreprise");
        l.info("adding the entreprise : "+e.toString());
        return entrepriseRepository.save(e);
    }

    @Override
    public void deleteEntreprise(Long id) {
        l.info("fired method Entreprise.deleteEntreprise");
        l.info("deleting the entreprise with id  : "+id);
        entrepriseRepository.deleteById(id);
    }

    public void deleteAllEntreprises(){
        l.info("fired method Entreprise.deleteAllEntreprises");
        l.info("deleting all the entreprises  : ");
        entrepriseRepository.deleteAll();
    }

    @Override
    public Entreprise updateEntreprise(Entreprise e) {
        l.info("fired method Entreprise.updateEntreprise");
        l.info("updating entreprise with ID "+e.getId()+" , New object is : "+e.toString());
        return entrepriseRepository.save(e);
    }

    @Override
    public Entreprise retrieveEntreprise(Long id) throws NullPointerException{
        l.info("in  retrieveEntreprise id = " + id);
        Entreprise e = entrepriseRepository.findById(id).orElse(null);
        return e;
    }
}
