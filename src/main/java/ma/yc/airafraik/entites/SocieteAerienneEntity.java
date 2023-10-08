package ma.yc.airafraik.entites;

import jakarta.persistence.*;
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
@Entity
@Table(name = "SOCIETE_AERINNE")
public class SocieteAerienneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id ;
    private String code ;
    private String adresse ;
    private String telephone;
    private String logo;

    @OneToMany(mappedBy ="SOCIETE_AERINNE", cascade = CascadeType.ALL)
    private Collection<VolEntity> volEntities = new ArrayList<>();
}
