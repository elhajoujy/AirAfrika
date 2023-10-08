package ma.yc.airafraik.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Log
@Entity(name = "administrateur")
public class AdministrateurEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id ;

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
