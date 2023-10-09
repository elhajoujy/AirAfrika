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
@Log
@Entity
@Table(name = "societe_aerienne")
public class SocieteAerienneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id ;
    private String code ;
    private String adresse ;
    private String telephone;
    private String nom;
    private String logo;

    @OneToMany(mappedBy ="societeAerienneEntity", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Collection<VolEntity> volEntities = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SocieteAerienneEntity{");
        sb.append("Id=").append(Id);
        sb.append(", code='").append(code).append('\'');
        sb.append(", adresse='").append(adresse).append('\'');
        sb.append(", telephone='").append(telephone).append('\'');
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", logo='").append(logo).append('\'');

        // Manually format the output for associated entities (avoid calling toString())
        sb.append(", volEntities=[");
        if (volEntities != null) {
            for (VolEntity volEntity : volEntities) {
                sb.append("{id=").append(volEntity.getId()).append(", code='").append(volEntity.getCode()).append("'}, ");
            }
        }
        sb.append("]");

        sb.append('}');
        return sb.toString();
    }

}
