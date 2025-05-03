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
public class DemandeModification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDemande;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateModification;
    private String newBenefactorName;
    private boolean validate;
    private String idPolice;

}
