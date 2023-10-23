package ma.yc.airafraik.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "bagage")
public class BagageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private double poids ;
    @ManyToOne
    private ReservationEntity reservation ;


}
