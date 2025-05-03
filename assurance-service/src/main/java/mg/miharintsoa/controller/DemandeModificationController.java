package mg.miharintsoa.controller;

import mg.miharintsoa.entity.DemandeModification;
import mg.miharintsoa.service.DemandeModificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/demandes")
public class DemandeModificationController {

    @Autowired
    private DemandeModificationService service;

    @PostMapping
    public DemandeModification create(@RequestBody DemandeModification demande) {
        return service.save(demande);
    }

    @GetMapping
    public List<DemandeModification> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public DemandeModification getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public DemandeModification update(@PathVariable Long id, @RequestBody DemandeModification demande) {
        return service.update(id, demande);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }


    @GetMapping("/valide/{id}/{valide}")
    public void validation(@PathVariable("id") Long id,@PathVariable("valide") boolean valide){
            System.out.println(id);
             System.out.println(valide);

            service.validation(id, valide);
    }
}
