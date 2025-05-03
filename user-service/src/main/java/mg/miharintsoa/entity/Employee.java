package mg.miharintsoa.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Employee {


    @Id
    private String number_employee;
    private String nom_employee;
    private String address_employee;
    private String password;
    private String number_assurance;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<UserRole> userRoles;
}
