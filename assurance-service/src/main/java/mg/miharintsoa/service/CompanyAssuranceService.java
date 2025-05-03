package mg.miharintsoa.service;

import mg.miharintsoa.entity.CompanyAssurance;
import mg.miharintsoa.repository.CompanyAssuranceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyAssuranceService {

    private final CompanyAssuranceRepository repository;

    public CompanyAssuranceService(CompanyAssuranceRepository repository) {
        this.repository = repository;
    }

    public List<CompanyAssurance> findAll() {
        return repository.findAll();
    }

    public Optional<CompanyAssurance> findById(Long idCompany) {
        return repository.findById(idCompany);
    }

    public CompanyAssurance save(CompanyAssurance company) {
        return repository.save(company);
    }

    public CompanyAssurance update(Long idCompany, CompanyAssurance updated) {
        if (!repository.existsById(idCompany)) throw new RuntimeException("Company not found");
        updated.setIdCompany(idCompany);

        return repository.save(updated);
    }

    public void delete(Long idCompany) {
        repository.deleteById(idCompany);
    }
}
