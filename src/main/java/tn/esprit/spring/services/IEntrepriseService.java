package tn.esprit.spring.services;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.User;

import java.util.List;

public interface IEntrepriseService {
    List<Entreprise> retrieveAllEntreprises();
    Entreprise addEntreprise(Entreprise e);
    void deleteEntreprise(Long id);
    Entreprise updateEntreprise(Entreprise e);
    Entreprise retrieveEntreprise(Long id);
}
