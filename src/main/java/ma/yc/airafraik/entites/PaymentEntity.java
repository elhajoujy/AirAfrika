package ma.yc.airafraik.entites;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "payment", schema = "public", catalog = "AIRAFRIK")
public class PaymentEntity {
    @Basic
    @Column(name = "paymentid")
    @Id
    private int paymentid;
    @Basic
    @Column(name = "reservation_code")
    private String reservationCode;
    @Basic
    @Column(name = "paymentamount")
    private BigDecimal paymentamount;
    @Basic
    @Column(name = "paymentdate")
    private Timestamp paymentdate;
    @Basic
    @Column(name = "paymentstatus")
    private String paymentstatus;
    @Basic
    @Column(name = "paymentmethod")
    private String paymentmethod;

    public int getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(int paymentid) {
        this.paymentid = paymentid;
    }

    public String getReservationCode() {
        return reservationCode;
    }

    public void setReservationCode(String reservationCode) {
        this.reservationCode = reservationCode;
    }

    public BigDecimal getPaymentamount() {
        return paymentamount;
    }

    public void setPaymentamount(BigDecimal paymentamount) {
        this.paymentamount = paymentamount;
    }

    public Timestamp getPaymentdate() {
        return paymentdate;
    }

    public void setPaymentdate(Timestamp paymentdate) {
        this.paymentdate = paymentdate;
    }

    public String getPaymentstatus() {
        return paymentstatus;
    }

    public void setPaymentstatus(String paymentstatus) {
        this.paymentstatus = paymentstatus;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        PaymentEntity that = (PaymentEntity) object;

        if (paymentid != that.paymentid) return false;
        if (reservationCode != null ? !reservationCode.equals(that.reservationCode) : that.reservationCode != null)
            return false;
        if (paymentamount != null ? !paymentamount.equals(that.paymentamount) : that.paymentamount != null)
            return false;
        if (paymentdate != null ? !paymentdate.equals(that.paymentdate) : that.paymentdate != null) return false;
        if (paymentstatus != null ? !paymentstatus.equals(that.paymentstatus) : that.paymentstatus != null)
            return false;
        if (paymentmethod != null ? !paymentmethod.equals(that.paymentmethod) : that.paymentmethod != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = paymentid;
        result = 31 * result + (reservationCode != null ? reservationCode.hashCode() : 0);
        result = 31 * result + (paymentamount != null ? paymentamount.hashCode() : 0);
        result = 31 * result + (paymentdate != null ? paymentdate.hashCode() : 0);
        result = 31 * result + (paymentstatus != null ? paymentstatus.hashCode() : 0);
        result = 31 * result + (paymentmethod != null ? paymentmethod.hashCode() : 0);
        return result;
    }
}
