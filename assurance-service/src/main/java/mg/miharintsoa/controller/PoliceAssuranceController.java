package mg.miharintsoa.controller;

import mg.miharintsoa.entity.CompanyAssurance;
import mg.miharintsoa.entity.PoliceAssurance;
import mg.miharintsoa.service.PoliceAssuranceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/polices")
public class PoliceAssuranceController {

    private final PoliceAssuranceService service;

    public PoliceAssuranceController(PoliceAssuranceService service) {
        this.service = service;
    }

    @GetMapping
    public List<PoliceAssurance> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PoliceAssurance> getById(@PathVariable String id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PoliceAssurance> create(@RequestBody PoliceAssurance police) {
        if (police.getCompanyAssurance() != null && police.getCompanyAssurance().getIdCompany() != null) {
            CompanyAssurance ca = service.findCompanyById(police.getCompanyAssurance().getIdCompany())
                    .orElseThrow(() -> new RuntimeException("CompanyAssurance not found"));
            police.setCompanyAssurance(ca);
        }
        return ResponseEntity.ok(service.save(police));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable String id, @RequestBody PoliceAssurance police) {
        return ResponseEntity.ok(service.update(id, police));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
