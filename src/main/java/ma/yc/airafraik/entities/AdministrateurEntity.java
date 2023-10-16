package ma.yc.airafraik.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.hibernate.annotations.Type;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Log
@Entity()
@Table(name = "administrateur")
public class AdministrateurEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String code ;
    private String nom ;
    private String prenom ;
    private String adresse ;
    @Email
    private String email ;
    @Pattern(regexp="(^$|[0-9]{10})")
    private String telephone ;
    private String password ;
}
