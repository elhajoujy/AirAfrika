package ma.yc.airafraik.entites;

import jakarta.persistence.*;

@Entity
@Table(name = "ville_imag", schema = "public", catalog = "AIRAFRIK")
public class VilleImagEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "image")
    private String image;
    @Basic
    @Column(name = "ville_id")
    private int villeId;
    @ManyToOne
    @JoinColumn(name = "ville_id", referencedColumnName = "id", nullable = false)
    private VilleEntity villeByVilleId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getVilleId() {
        return villeId;
    }

    public void setVilleId(int villeId) {
        this.villeId = villeId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        VilleImagEntity that = (VilleImagEntity) object;

        if (id != that.id) return false;
        if (villeId != that.villeId) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + villeId;
        return result;
    }

    public VilleEntity getVilleByVilleId() {
        return villeByVilleId;
    }

    public void setVilleByVilleId(VilleEntity villeByVilleId) {
        this.villeByVilleId = villeByVilleId;
    }
}
