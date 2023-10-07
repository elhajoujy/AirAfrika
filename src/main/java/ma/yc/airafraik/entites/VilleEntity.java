package ma.yc.airafraik.entites;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "ville", schema = "public", catalog = "AIRAFRIK")
public class VilleEntity {
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
    @Column(name = "code_postal")
    private String codePostal;
    @OneToMany(mappedBy = "villeByVilleId")
    private Collection<VilleImagEntity> villeImagsById;
    @OneToMany(mappedBy = "villeByVilleId")
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

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        VilleEntity that = (VilleEntity) object;

        if (id != that.id) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (codePostal != null ? !codePostal.equals(that.codePostal) : that.codePostal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (codePostal != null ? codePostal.hashCode() : 0);
        return result;
    }

    public Collection<VilleImagEntity> getVilleImagsById() {
        return villeImagsById;
    }

    public void setVilleImagsById(Collection<VilleImagEntity> villeImagsById) {
        this.villeImagsById = villeImagsById;
    }

    public Collection<VolEntity> getVolsById() {
        return volsById;
    }

    public void setVolsById(Collection<VolEntity> volsById) {
        this.volsById = volsById;
    }
}
