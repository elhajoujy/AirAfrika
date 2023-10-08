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
@Table(name = "VILLE")
public class VilleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String code ;
    private String nom;
    @Column(name = "code_postal")
    private String codePostal;

    @OneToMany(mappedBy = "ville", cascade = CascadeType.ALL)
    private Collection<VilleImageEntity> imageEntities = new ArrayList<>();
}
