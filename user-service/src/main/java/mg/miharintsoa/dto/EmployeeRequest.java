package mg.miharintsoa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class EmployeeRequest {
    private String number_employee;
    private String nom_employee;
    private String address_employee;
    private String password;
    private String confirmPassword;
    private String number_assurance;
    private Set<Integer> userRoleIds;
}
