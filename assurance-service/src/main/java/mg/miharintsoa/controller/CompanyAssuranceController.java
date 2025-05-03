package mg.miharintsoa.controller;

import mg.miharintsoa.entity.CompanyAssurance;
import mg.miharintsoa.service.CompanyAssuranceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyAssuranceController {

    private final CompanyAssuranceService service;

    public CompanyAssuranceController(CompanyAssuranceService service) {
        this.service = service;
    }

    @GetMapping
    public List<CompanyAssurance> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyAssurance> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CompanyAssurance create(@RequestBody CompanyAssurance company) {
        return service.save(company);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyAssurance> update(@PathVariable Long id, @RequestBody CompanyAssurance company) {
        try {
            return ResponseEntity.ok(service.update(id, company));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
