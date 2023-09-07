package ma.project.hospital.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @NotBlank 
    @Size(min=4,max = 20)
    private String nom ;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth ;
    private boolean sick ;
    @Min(100)
    private int score;
}
