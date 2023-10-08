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
@Table(name = "VOLE")
public class VolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code ;
    @Column(name = "heure_depart")
    private String heureDepart ;

    @Column(name = "heure_arrivee")
    private String heureArrivee;

    @Column(name = "date_depart")
    private String dateDepart ;
    @Column(name = "date_arrivee")
    private String dateArrive ;
    @Column(name = "ville_depart")
    private String villeDepart ;
    @Column(name = "ville_arrivee")
    private String villeArrivee ;
    @Column(name = "nombre_de_places")
    private int nomberDePlaces ;

    private double prix ;

    @ManyToOne
    @JoinColumn(name = "societe_aerienne_id")
    private SocieteAerienneEntity societeAerienneEntity ;

    @OneToMany(mappedBy ="VOLE", cascade = CascadeType.ALL)
    private Collection<VolExtrasEntity> volExtrasEntities = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "reservation_vol",
            joinColumns = { @JoinColumn(name = "vol_id") },
            inverseJoinColumns = { @JoinColumn(name = "reservation_code") }
    )
    private Collection<ReservationEntity> reservationEntities = new ArrayList<>();

    //TODO : JE PEUX ENRGISTER  LES VILLE DEPART ET ARRIVE ETQ OBJET
    //TODO : AUSSI LES INFORMATION DE AERPORT ;

}
