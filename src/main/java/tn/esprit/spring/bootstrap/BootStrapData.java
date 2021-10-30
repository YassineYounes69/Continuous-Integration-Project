package tn.esprit.spring.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.EntrepriseServiceImpl;

@Component
public class BootStrapData implements CommandLineRunner {

    private final EntrepriseServiceImpl entrepriseService;

    public BootStrapData(EntrepriseServiceImpl entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello from bootstrapdata");
        Entreprise e1 = new Entreprise("Entreprise 1","SARL");
        Entreprise e2 = new Entreprise("Entreprise 2","Anonyme");
        Entreprise e3 = new Entreprise("Entreprise 3","SA");

        entrepriseService.addEntreprise(e1);
        entrepriseService.addEntreprise(e2);
        entrepriseService.addEntreprise(e3);

        entrepriseService.retrieveAllEntreprises();

        e2.setName("ESPRIT");
        entrepriseService.updateEntreprise(e2);
        entrepriseService.retrieveEntreprise((long)2);


        entrepriseService.deleteAllEntreprises();
    }
}
