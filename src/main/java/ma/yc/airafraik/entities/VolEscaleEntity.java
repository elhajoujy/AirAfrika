package ma.yc.airafraik.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.java.Log;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Log
@Entity
@Table(name = "vol_escale")
public class VolEscaleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ville_escale")
    private String villeEscale ;

    @Column(name = "heure_depart")
    private String heureEscaleDepart ;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vol_id")
    private VolEntity vol = null ;


}
