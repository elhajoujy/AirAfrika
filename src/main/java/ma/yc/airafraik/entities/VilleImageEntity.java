package ma.yc.airafraik.entities;


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
@Table(name = "VILLE_IMAGE")
public class VilleImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String image ;
    @ManyToOne
    @JoinColumn(name = "ville_id") // Specify the join column
    private VilleEntity ville ;
}
