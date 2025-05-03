package mg.miharintsoa.service;

import lombok.AllArgsConstructor;
import mg.miharintsoa.entity.Employee;
import mg.miharintsoa.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {

    private EmployeeRepository repository;


    public List<Employee> findAll() {
        return repository.findAll();
    }

    public Optional<Employee> findById(String id) {
        return repository.findById(id);
    }

    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
