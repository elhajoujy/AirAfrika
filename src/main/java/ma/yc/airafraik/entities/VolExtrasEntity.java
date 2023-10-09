package ma.yc.airafraik.entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.extern.java.Log;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Log
@Entity
@Table(name = "vol_extras")
@ToString
public class VolExtrasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String type ;
    private double prix ;
    private String description ;

    @ManyToOne
    @JoinColumn(name = "vol_id")
    private VolEntity vol ;
}
