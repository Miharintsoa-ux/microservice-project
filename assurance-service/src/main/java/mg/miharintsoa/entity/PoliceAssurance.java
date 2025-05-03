package mg.miharintsoa.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class PoliceAssurance {

    @Id
    private String idPolice;
    private String benefactorName;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdDate;
    private String employeeNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    private CompanyAssurance companyAssurance;
}
