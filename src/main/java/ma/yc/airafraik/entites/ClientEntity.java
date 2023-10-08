package ma.yc.airafraik.entites;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Log
@Entity(name = "client")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String code ;
    private String prenom ;
    private String nom ;
    private String adresse;
    @Email
    private String email ;
    @Pattern(regexp="(^$|[0-9]{10})")
    private String telephone;
    private String password ;
    private String profile_image;

    @OneToMany(mappedBy = "CLIENT",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Collection<ReservationEntity> reservationEntities = new ArrayList<>();

}
