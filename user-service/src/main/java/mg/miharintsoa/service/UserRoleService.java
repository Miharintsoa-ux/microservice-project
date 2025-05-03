package mg.miharintsoa.service;


import lombok.AllArgsConstructor;
import mg.miharintsoa.entity.UserRole;
import mg.miharintsoa.repository.UserRoleRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserRoleService {

    private UserRoleRepository repository;

    public List<UserRole> findByIds(Set<Integer> ids) {
        return repository.findAllById(ids);

    }

    public UserRole save(UserRole role) {
        return repository.save(role);
    }

    public List<UserRole> getAll() {
        return repository.findAll();
    }

    public Optional<UserRole> getById(int id) {
        return repository.findById(id);
    }

    public UserRole update(int id, UserRole newRole) {
        return repository.findById(id)
                .map(role -> {
                    role.setRole(newRole.getRole());
                    return repository.save(role);
                })
                .orElseThrow(() -> new RuntimeException("Role not found"));
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

}
