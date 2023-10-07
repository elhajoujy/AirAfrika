package ma.yc.airafraik.entites;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "vol", schema = "public", catalog = "AIRAFRIK")
public class VolEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "code")
    private String code;
    @Basic
    @Column(name = "heure_depart")
    private String heureDepart;
    @Basic
    @Column(name = "heure_arrivee")
    private String heureArrivee;
    @Basic
    @Column(name = "date_depart")
    private String dateDepart;
    @Basic
    @Column(name = "date_arrivee")
    private String dateArrivee;
    @Basic
    @Column(name = "ville_depart")
    private String villeDepart;
    @Basic
    @Column(name = "ville_arrivee")
    private String villeArrivee;
    @Basic
    @Column(name = "nombre_de_places")
    private Integer nombreDePlaces;
    @Basic
    @Column(name = "prix")
    private String prix;
    @Basic
    @Column(name = "aeroport_id")
    private int aeroportId;
    @Basic
    @Column(name = "societe_aerienne_id")
    private int societeAerienneId;
    @Basic
    @Column(name = "ville_id")
    private Integer villeId;
    @OneToMany(mappedBy = "volByVolId")
    private Collection<ReservationVolEntity> reservationVolsById;
    @ManyToOne
    @JoinColumn(name = "aeroport_id", referencedColumnName = "id", nullable = false)
    private AeroportEntity aeroportByAeroportId;
    @ManyToOne
    @JoinColumn(name = "societe_aerienne_id", referencedColumnName = "id", nullable = false)
    private SocieteAerienneEntity societeAerienneBySocieteAerienneId;
    @ManyToOne
    @JoinColumn(name = "ville_id", referencedColumnName = "id")
    private VilleEntity villeByVilleId;
    @OneToMany(mappedBy = "volByVolId")
    private Collection<VolExtrasEntity> volExtrasById;

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

    public String getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(String heureDepart) {
        this.heureDepart = heureDepart;
    }

    public String getHeureArrivee() {
        return heureArrivee;
    }

    public void setHeureArrivee(String heureArrivee) {
        this.heureArrivee = heureArrivee;
    }

    public String getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(String dateDepart) {
        this.dateDepart = dateDepart;
    }

    public String getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(String dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

    public String getVilleArrivee() {
        return villeArrivee;
    }

    public void setVilleArrivee(String villeArrivee) {
        this.villeArrivee = villeArrivee;
    }

    public Integer getNombreDePlaces() {
        return nombreDePlaces;
    }

    public void setNombreDePlaces(Integer nombreDePlaces) {
        this.nombreDePlaces = nombreDePlaces;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public int getAeroportId() {
        return aeroportId;
    }

    public void setAeroportId(int aeroportId) {
        this.aeroportId = aeroportId;
    }

    public int getSocieteAerienneId() {
        return societeAerienneId;
    }

    public void setSocieteAerienneId(int societeAerienneId) {
        this.societeAerienneId = societeAerienneId;
    }

    public Integer getVilleId() {
        return villeId;
    }

    public void setVilleId(Integer villeId) {
        this.villeId = villeId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        VolEntity volEntity = (VolEntity) object;

        if (id != volEntity.id) return false;
        if (aeroportId != volEntity.aeroportId) return false;
        if (societeAerienneId != volEntity.societeAerienneId) return false;
        if (code != null ? !code.equals(volEntity.code) : volEntity.code != null) return false;
        if (heureDepart != null ? !heureDepart.equals(volEntity.heureDepart) : volEntity.heureDepart != null)
            return false;
        if (heureArrivee != null ? !heureArrivee.equals(volEntity.heureArrivee) : volEntity.heureArrivee != null)
            return false;
        if (dateDepart != null ? !dateDepart.equals(volEntity.dateDepart) : volEntity.dateDepart != null) return false;
        if (dateArrivee != null ? !dateArrivee.equals(volEntity.dateArrivee) : volEntity.dateArrivee != null)
            return false;
        if (villeDepart != null ? !villeDepart.equals(volEntity.villeDepart) : volEntity.villeDepart != null)
            return false;
        if (villeArrivee != null ? !villeArrivee.equals(volEntity.villeArrivee) : volEntity.villeArrivee != null)
            return false;
        if (nombreDePlaces != null ? !nombreDePlaces.equals(volEntity.nombreDePlaces) : volEntity.nombreDePlaces != null)
            return false;
        if (prix != null ? !prix.equals(volEntity.prix) : volEntity.prix != null) return false;
        if (villeId != null ? !villeId.equals(volEntity.villeId) : volEntity.villeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (heureDepart != null ? heureDepart.hashCode() : 0);
        result = 31 * result + (heureArrivee != null ? heureArrivee.hashCode() : 0);
        result = 31 * result + (dateDepart != null ? dateDepart.hashCode() : 0);
        result = 31 * result + (dateArrivee != null ? dateArrivee.hashCode() : 0);
        result = 31 * result + (villeDepart != null ? villeDepart.hashCode() : 0);
        result = 31 * result + (villeArrivee != null ? villeArrivee.hashCode() : 0);
        result = 31 * result + (nombreDePlaces != null ? nombreDePlaces.hashCode() : 0);
        result = 31 * result + (prix != null ? prix.hashCode() : 0);
        result = 31 * result + aeroportId;
        result = 31 * result + societeAerienneId;
        result = 31 * result + (villeId != null ? villeId.hashCode() : 0);
        return result;
    }

    public Collection<ReservationVolEntity> getReservationVolsById() {
        return reservationVolsById;
    }

    public void setReservationVolsById(Collection<ReservationVolEntity> reservationVolsById) {
        this.reservationVolsById = reservationVolsById;
    }

    public AeroportEntity getAeroportByAeroportId() {
        return aeroportByAeroportId;
    }

    public void setAeroportByAeroportId(AeroportEntity aeroportByAeroportId) {
        this.aeroportByAeroportId = aeroportByAeroportId;
    }

    public SocieteAerienneEntity getSocieteAerienneBySocieteAerienneId() {
        return societeAerienneBySocieteAerienneId;
    }

    public void setSocieteAerienneBySocieteAerienneId(SocieteAerienneEntity societeAerienneBySocieteAerienneId) {
        this.societeAerienneBySocieteAerienneId = societeAerienneBySocieteAerienneId;
    }

    public VilleEntity getVilleByVilleId() {
        return villeByVilleId;
    }

    public void setVilleByVilleId(VilleEntity villeByVilleId) {
        this.villeByVilleId = villeByVilleId;
    }

    public Collection<VolExtrasEntity> getVolExtrasById() {
        return volExtrasById;
    }

    public void setVolExtrasById(Collection<VolExtrasEntity> volExtrasById) {
        this.volExtrasById = volExtrasById;
    }
}
