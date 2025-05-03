package mg.miharintsoa.controller;

import mg.miharintsoa.entity.UserRole;
import mg.miharintsoa.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-roles")
public class UserRoleController {

    @Autowired
    private UserRoleService service;

    @PostMapping
    public ResponseEntity<UserRole> create(@RequestBody UserRole role) {
        return ResponseEntity.ok(service.save(role));
    }

    @GetMapping
    public ResponseEntity<List<UserRole>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRole> getById(@PathVariable int id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserRole> update(@PathVariable int id, @RequestBody UserRole updatedRole) {
        return ResponseEntity.ok(service.update(id, updatedRole));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
