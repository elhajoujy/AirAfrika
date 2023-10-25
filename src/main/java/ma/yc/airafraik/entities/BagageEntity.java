package ma.yc.airafraik.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bagage")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BagageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private double poids ;
    private double prix ;
    @ManyToOne
    private ReservationEntity reservation ;


}
