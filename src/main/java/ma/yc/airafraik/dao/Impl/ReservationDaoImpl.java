package ma.yc.airafraik.dao.Impl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import ma.yc.airafraik.connection.HyperJpa;
import ma.yc.airafraik.dao.ReservationDao;
import ma.yc.airafraik.entities.ReservationEntity;
import ma.yc.airafraik.enums.ReservationStatus;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class ReservationDaoImpl  implements ReservationDao{

    HyperJpa hyperJpa = HyperJpa.getInstance();
    EntityManager entityManager = hyperJpa.getEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    @Override
    public void ajouterReservation(ReservationEntity reservationEntity) {

    }

    @Override
    public void modifierReservation(ReservationEntity reservationEntity) {

    }

    @Override
    public void supprimerReservation(ReservationEntity reservationEntity) {

    }

    @Override
    public void changerEtatReservation(ReservationEntity reservationEntity, ReservationStatus reservationStatus) {

    }

    @Override
    public Collection<ReservationEntity> consulterReservations() {
        return null;
    }

    @Override
    public Collection<ReservationEntity> consulterReservations(String code) {
        return null;
    }



    @Override
    public ArrayList<ReservationEntity> AfficheLesStatistiques(HashMap<String, String> conditions , ReservationStatus reservationStatus) {
        Query query = entityManager.createNativeQuery("SELECT * FROM reservation WHERE date_reservation BETWEEN :date_1 AND :date_2 AND status = :etat_reservation", ReservationEntity.class);
        query.setParameter("date_1", conditions.get("date_1"));
        query.setParameter("date_2", conditions.get("date_2"));
        query.setParameter("etat_reservation", reservationStatus.toString());
        ArrayList<ReservationEntity> reservationEntities = (ArrayList<ReservationEntity>) query.getResultList();

        return reservationEntities;
    }

    @Override
    public ArrayList<ReservationEntity> lesRservationConfirmésPendantMoisOuAns(HashMap<String, String> conditions) {
        Query query = entityManager.createNativeQuery("SELECT * FROM reservation WHERE date_reservation BETWEEN :date_1 AND :date_2 AND status = :etat_reservation", ReservationEntity.class);
        query.setParameter("date_1", conditions.get("date_1"));
        query.setParameter("date_2", conditions.get("date_2"));
        query.setParameter("etat_reservation", ReservationStatus.CONFIRMED.toString());
        ArrayList<ReservationEntity> reservationEntities = (ArrayList<ReservationEntity>) query.getResultList();

        return reservationEntities;
    }

    @Override
    public ArrayList<ReservationEntity> lesRservationAnnulésPendantMoisOuAns(HashMap<String, String> conditions) {
        Query query = entityManager.createNativeQuery("SELECT * FROM reservation WHERE date_reservation BETWEEN :date_1 AND :date_2 AND status = :etat_reservation", ReservationEntity.class);
        query.setParameter("date_1", conditions.get("date_1"));
        query.setParameter("date_2", conditions.get("date_2"));
        query.setParameter("etat_reservation", ReservationStatus.CANCELLED.toString());
        ArrayList<ReservationEntity> reservationEntities = (ArrayList<ReservationEntity>) query.getResultList();
        return reservationEntities;
    }
}
