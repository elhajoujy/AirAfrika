package ma.yc.airafraik.entites;

import jakarta.persistence.*;

@Entity
@Table(name = "vol_extras", schema = "public", catalog = "AIRAFRIK")
public class VolExtrasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "type")
    private String type;
    @Basic
    @Column(name = "prix")
    private String prix;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "vol_id")
    private int volId;
    @ManyToOne
    @JoinColumn(name = "vol_id", referencedColumnName = "id", nullable = false)
    private VolEntity volByVolId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getVolId() {
        return volId;
    }

    public void setVolId(int volId) {
        this.volId = volId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        VolExtrasEntity that = (VolExtrasEntity) object;

        if (id != that.id) return false;
        if (volId != that.volId) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (prix != null ? !prix.equals(that.prix) : that.prix != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (prix != null ? prix.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + volId;
        return result;
    }

    public VolEntity getVolByVolId() {
        return volByVolId;
    }

    public void setVolByVolId(VolEntity volByVolId) {
        this.volByVolId = volByVolId;
    }
}
