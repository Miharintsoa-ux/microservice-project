package mg.miharintsoa.service;

import mg.miharintsoa.entity.CompanyAssurance;
import mg.miharintsoa.entity.DemandeModification;
import mg.miharintsoa.entity.PoliceAssurance;
import mg.miharintsoa.repository.CompanyAssuranceRepository;
import mg.miharintsoa.repository.PoliceAssuranceRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PoliceAssuranceService {

    private final PoliceAssuranceRepository policeRepo;
    private final CompanyAssuranceRepository companyRepo;
    private final DemandeModificationService demandeModificationService;

    public PoliceAssuranceService(PoliceAssuranceRepository policeRepo, CompanyAssuranceRepository companyRepo, DemandeModificationService demandeModificationService) {
        this.policeRepo = policeRepo;
        this.companyRepo = companyRepo;
        this.demandeModificationService = demandeModificationService;
    }

    public List<PoliceAssurance> findAll() {
        return policeRepo.findAll();
    }

    public Optional<PoliceAssurance> findById(String id) {
        return policeRepo.findById(id);
    }

    public PoliceAssurance save(PoliceAssurance police) {
        return policeRepo.save(police);
    }

    public String update(String id, PoliceAssurance updated) {
        if (!policeRepo.existsById(id)) throw new RuntimeException("Not found");

        DemandeModification modification = DemandeModification.builder()
                        .dateModification(new Date())
                        .newBenefactorName(updated.getBenefactorName())
                        .validate(false)
                .idPolice(updated.getIdPolice())
                        .build();
        demandeModificationService.save(modification);
        return "en attente";
    }

    public PoliceAssurance updateValidated(String id, PoliceAssurance updated) {
        if (!policeRepo.existsById(id)) throw new RuntimeException("Not found");
        updated.setIdPolice(id);
        return policeRepo.save(updated);
    }
    public void delete(String id) {
        policeRepo.deleteById(id);
    }

    public Optional<CompanyAssurance> findCompanyById(Long id) {
        return companyRepo.findById(id);
    }
}
