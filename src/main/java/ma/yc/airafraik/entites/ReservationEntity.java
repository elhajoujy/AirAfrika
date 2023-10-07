package ma.yc.airafraik.entites;

import jakarta.persistence.*;

@Entity
@Table(name = "reservation", schema = "public", catalog = "AIRAFRIK")
public class ReservationEntity {
    @Basic
    @Column(name = "id")
    @Id
    private int id;
    @Basic
    @Column(name = "code")
    private String code;
    @Basic
    @Column(name = "price_total")
    private String priceTotal;
    @Basic
    @Column(name = "date_reservation")
    private String dateReservation;
    @Basic
    @Column(name = "client_id")
    private int clientId;
    @Basic
    @Column(name = "date_depart")
    private String dateDepart;
    @Basic
    @Column(name = "number_de_adulets")
    private Integer numberDeAdulets;
    @Basic
    @Column(name = "number_de_enfants")
    private Integer numberDeEnfants;
    @Basic
    @Column(name = "number_de_bebes")
    private Integer numberDeBebes;
    @Basic
    @Column(name = "lheure_depart")
    private String lheureDepart;
    @Basic
    @Column(name = "lheure_arrivee")
    private String lheureArrivee;
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
    @Column(name = "confirmed")
    private Boolean confirmed;
    @Basic
    @Column(name = "cancled")
    private Boolean cancled;
    @ManyToOne
    @JoinColumn(name = "code", referencedColumnName = "reservation_code", nullable = false)
    private PaymentEntity paymentByCode;
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    private ClientEntity clientByClientId;
    @ManyToOne
    @JoinColumn(name = "code", referencedColumnName = "reservation_code", nullable = false)
    private ReservationVolEntity reservationVolByCode;

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

    public String getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(String priceTotal) {
        this.priceTotal = priceTotal;
    }

    public String getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(String dateReservation) {
        this.dateReservation = dateReservation;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(String dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Integer getNumberDeAdulets() {
        return numberDeAdulets;
    }

    public void setNumberDeAdulets(Integer numberDeAdulets) {
        this.numberDeAdulets = numberDeAdulets;
    }

    public Integer getNumberDeEnfants() {
        return numberDeEnfants;
    }

    public void setNumberDeEnfants(Integer numberDeEnfants) {
        this.numberDeEnfants = numberDeEnfants;
    }

    public Integer getNumberDeBebes() {
        return numberDeBebes;
    }

    public void setNumberDeBebes(Integer numberDeBebes) {
        this.numberDeBebes = numberDeBebes;
    }

    public String getLheureDepart() {
        return lheureDepart;
    }

    public void setLheureDepart(String lheureDepart) {
        this.lheureDepart = lheureDepart;
    }

    public String getLheureArrivee() {
        return lheureArrivee;
    }

    public void setLheureArrivee(String lheureArrivee) {
        this.lheureArrivee = lheureArrivee;
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

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Boolean getCancled() {
        return cancled;
    }

    public void setCancled(Boolean cancled) {
        this.cancled = cancled;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        ReservationEntity that = (ReservationEntity) object;

        if (id != that.id) return false;
        if (clientId != that.clientId) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (priceTotal != null ? !priceTotal.equals(that.priceTotal) : that.priceTotal != null) return false;
        if (dateReservation != null ? !dateReservation.equals(that.dateReservation) : that.dateReservation != null)
            return false;
        if (dateDepart != null ? !dateDepart.equals(that.dateDepart) : that.dateDepart != null) return false;
        if (numberDeAdulets != null ? !numberDeAdulets.equals(that.numberDeAdulets) : that.numberDeAdulets != null)
            return false;
        if (numberDeEnfants != null ? !numberDeEnfants.equals(that.numberDeEnfants) : that.numberDeEnfants != null)
            return false;
        if (numberDeBebes != null ? !numberDeBebes.equals(that.numberDeBebes) : that.numberDeBebes != null)
            return false;
        if (lheureDepart != null ? !lheureDepart.equals(that.lheureDepart) : that.lheureDepart != null) return false;
        if (lheureArrivee != null ? !lheureArrivee.equals(that.lheureArrivee) : that.lheureArrivee != null)
            return false;
        if (dateArrivee != null ? !dateArrivee.equals(that.dateArrivee) : that.dateArrivee != null) return false;
        if (villeDepart != null ? !villeDepart.equals(that.villeDepart) : that.villeDepart != null) return false;
        if (villeArrivee != null ? !villeArrivee.equals(that.villeArrivee) : that.villeArrivee != null) return false;
        if (confirmed != null ? !confirmed.equals(that.confirmed) : that.confirmed != null) return false;
        if (cancled != null ? !cancled.equals(that.cancled) : that.cancled != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (priceTotal != null ? priceTotal.hashCode() : 0);
        result = 31 * result + (dateReservation != null ? dateReservation.hashCode() : 0);
        result = 31 * result + clientId;
        result = 31 * result + (dateDepart != null ? dateDepart.hashCode() : 0);
        result = 31 * result + (numberDeAdulets != null ? numberDeAdulets.hashCode() : 0);
        result = 31 * result + (numberDeEnfants != null ? numberDeEnfants.hashCode() : 0);
        result = 31 * result + (numberDeBebes != null ? numberDeBebes.hashCode() : 0);
        result = 31 * result + (lheureDepart != null ? lheureDepart.hashCode() : 0);
        result = 31 * result + (lheureArrivee != null ? lheureArrivee.hashCode() : 0);
        result = 31 * result + (dateArrivee != null ? dateArrivee.hashCode() : 0);
        result = 31 * result + (villeDepart != null ? villeDepart.hashCode() : 0);
        result = 31 * result + (villeArrivee != null ? villeArrivee.hashCode() : 0);
        result = 31 * result + (confirmed != null ? confirmed.hashCode() : 0);
        result = 31 * result + (cancled != null ? cancled.hashCode() : 0);
        return result;
    }

    public PaymentEntity getPaymentByCode() {
        return paymentByCode;
    }

    public void setPaymentByCode(PaymentEntity paymentByCode) {
        this.paymentByCode = paymentByCode;
    }

    public ClientEntity getClientByClientId() {
        return clientByClientId;
    }

    public void setClientByClientId(ClientEntity clientByClientId) {
        this.clientByClientId = clientByClientId;
    }

    public ReservationVolEntity getReservationVolByCode() {
        return reservationVolByCode;
    }

    public void setReservationVolByCode(ReservationVolEntity reservationVolByCode) {
        this.reservationVolByCode = reservationVolByCode;
    }
}
