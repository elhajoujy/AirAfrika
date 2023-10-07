package ma.yc.airafraik.entites;

import jakarta.persistence.*;

@Entity
@Table(name = "reservation_vol", schema = "public", catalog = "AIRAFRIK")
public class ReservationVolEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "reservation_code")
    private String reservationCode;
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

    public String getReservationCode() {
        return reservationCode;
    }

    public void setReservationCode(String reservationCode) {
        this.reservationCode = reservationCode;
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

        ReservationVolEntity that = (ReservationVolEntity) object;

        if (id != that.id) return false;
        if (volId != that.volId) return false;
        if (reservationCode != null ? !reservationCode.equals(that.reservationCode) : that.reservationCode != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (reservationCode != null ? reservationCode.hashCode() : 0);
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
