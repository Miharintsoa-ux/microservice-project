package mg.miharintsoa.service;

import mg.miharintsoa.entity.DemandeModification;
import mg.miharintsoa.entity.PoliceAssurance;
import mg.miharintsoa.repository.DemandeModificationRepository;
import mg.miharintsoa.repository.PoliceAssuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class DemandeModificationService {

    @Autowired
    private DemandeModificationRepository repository;
    @Autowired
    private WebClient webClient;
    @Autowired
    private PoliceAssuranceRepository policeAssuranceRepository;

    public DemandeModification save(DemandeModification demande) {
        return repository.save(demande);
    }

    public List<DemandeModification> findAll() {
        return repository.findAll();
    }

    public DemandeModification findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public DemandeModification update(Long id, DemandeModification updatedDemande) {
        DemandeModification existing = findById(id);
        if (existing != null) {
            existing.setDateModification(updatedDemande.getDateModification());
            existing.setNewBenefactorName(updatedDemande.getNewBenefactorName());
            existing.setValidate(updatedDemande.isValidate());
            return repository.save(existing);
        }
        return null;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }


    public void validation(Long id, boolean validated){

        if(validated == false){
            String json = """
            {
              "to": "utilisateur@example.com",
              "subject": "Confirmation de votre demande",
              "body": "Bonjour,\\nChangement du nom invalide\\nMerci."
            }
            """;

            String result = webClient.post()
                    .uri("http://localhost:8080/api/email")
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .bodyValue(json)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            repository.deleteById(id);

            System.out.println(result);

        }else{

            DemandeModification demande = repository.findById(id).orElse(null);
            PoliceAssurance policeAssurance = policeAssuranceRepository.findById(demande.getIdPolice()).get();
            policeAssurance.setBenefactorName(demande.getNewBenefactorName());
            policeAssuranceRepository.save(policeAssurance);

            String json = """
            {
              "to": "company@example.com",
              "subject": "Confirmation de votre demande",
              "body": "Bonjour,\\nChangement du nom du beneficiaire\\nMerci."
            }
            """;

            String result = webClient.post()
                    .uri("http://localhost:8080/api/email")
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .bodyValue(json)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();



        }
    }
}
