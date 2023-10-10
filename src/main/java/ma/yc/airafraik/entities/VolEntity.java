package ma.yc.airafraik.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "VOL")
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "societe_aerienne_id")
    private SocieteAerienneEntity societeAerienneEntity = null ;

    @OneToMany(mappedBy ="vol", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private Collection<VolExtrasEntity> volExtrasEntities = new ArrayList<>();

//    @OneToMany(mappedBy ="vol", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
//    private Collection<VolEscaleEntity> volEscaleEntities = new ArrayList<>();


    @ManyToMany
    @JoinTable(
            name = "reservation_vol",
            joinColumns = { @JoinColumn(name = "vol_id") },
            inverseJoinColumns = { @JoinColumn(name = "reservation_code") }
    )
    private Collection<ReservationEntity> reservationEntities = new ArrayList<>();


    @Override
    public String toString() {
        return "VolEntity{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", heureDepart='" + heureDepart + '\'' +
                ", heureArrivee='" + heureArrivee + '\'' +
                ", dateDepart='" + dateDepart + '\'' +
                ", dateArrive='" + dateArrive + '\'' +
                ", villeDepart='" + villeDepart + '\'' +
                ", villeArrivee='" + villeArrivee + '\'' +
                ", nomberDePlaces=" + nomberDePlaces +
                ", prix=" + prix +
                ", societeAerienneEntity=" + societeAerienneEntity.toString() +
//                ", volExtrasEntities=" + volExtrasEntities +
//                ", reservationEntities=" + reservationEntities +
                '}';
    }

    //TODO : JE PEUX ENRGISTER  LES VILLE DEPART ET ARRIVE ETQ OBJET
    //TODO : AUSSI LES INFORMATION DE AERPORT ;

}
