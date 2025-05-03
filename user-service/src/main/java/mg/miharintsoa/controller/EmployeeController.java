package mg.miharintsoa.controller;

import lombok.AllArgsConstructor;
import mg.miharintsoa.dto.EmployeeRequest;
import mg.miharintsoa.entity.Employee;
import mg.miharintsoa.service.EmployeeService;
import mg.miharintsoa.service.UserRoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService service;
    private UserRoleService userRoleService;
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public List<Employee> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable String id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody EmployeeRequest request) {
        if (!request.getPassword().equals(request.getConfirmPassword())) {
            return ResponseEntity.badRequest().body("Passwords do not match");
        }

        Employee employee = Employee.builder()
                .number_employee(request.getNumber_employee())
                .nom_employee(request.getNom_employee())
                .address_employee(request.getAddress_employee())
                .password(passwordEncoder.encode(request.getPassword()))
                .number_assurance(request.getNumber_assurance())
                .userRoles(userRoleService.findByIds(request.getUserRoleIds()))
                .build();

        return ResponseEntity.ok(service.save(employee));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable String id, @RequestBody Employee updated) {
        return service.findById(id).map(existing -> {
            updated.setNumber_employee(id); // on garde l'ID
            return ResponseEntity.ok(service.save(updated));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (service.findById(id).isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
