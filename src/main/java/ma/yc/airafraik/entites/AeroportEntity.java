package ma.yc.airafraik.entites;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "aeroport", schema = "public", catalog = "AIRAFRIK")
public class AeroportEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "code")
    private String code;
    @Basic
    @Column(name = "nom")
    private String nom;
    @Basic
    @Column(name = "adresse")
    private String adresse;
    @Basic
    @Column(name = "telephone")
    private String telephone;
    @OneToMany(mappedBy = "aeroportByAeroportId")
    private Collection<VolEntity> volsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        AeroportEntity that = (AeroportEntity) object;

        if (id != that.id) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (adresse != null ? !adresse.equals(that.adresse) : that.adresse != null) return false;
        if (telephone != null ? !telephone.equals(that.telephone) : that.telephone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (adresse != null ? adresse.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        return result;
    }

    public Collection<VolEntity> getVolsById() {
        return volsById;
    }

    public void setVolsById(Collection<VolEntity> volsById) {
        this.volsById = volsById;
    }
}
