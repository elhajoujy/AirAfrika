package ma.yc.airafraik.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "AVION")
public class AvionEntity {
    @Id
    private int id;
    @Column(name = "nom_avion")
    private String nomAvion;

    @Column(name = "nomber_place")
    private int nombrePlace;

//    @ManyToOne

//    private SocieteAerienneEntity societeAerienneEntity;
    @OneToMany
    @JoinColumn(name = "avion_id")
    Collection <VolEntity> vols = new ArrayList<>();
}
