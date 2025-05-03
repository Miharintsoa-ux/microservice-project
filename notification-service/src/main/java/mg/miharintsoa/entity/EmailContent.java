package mg.miharintsoa.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class EmailContent {
    private String to;
    private String subject;
    private String body;
}
