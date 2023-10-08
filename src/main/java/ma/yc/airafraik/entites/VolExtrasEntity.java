package ma.yc.airafraik.entites;


import jakarta.persistence.*;
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
@Entity
@Table(name = "vol_extras")
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
