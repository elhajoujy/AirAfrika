package ma.yc.airafraik.dao.Impl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import ma.yc.airafraik.connection.HyperJpa;
import ma.yc.airafraik.dao.ReservationDao;
import ma.yc.airafraik.entities.ReservationEntity;
import ma.yc.airafraik.entities.VolEntity;
import ma.yc.airafraik.enums.ReservationStatus;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class ReservationDaoImpl  implements ReservationDao{

    HyperJpa hyperJpa = HyperJpa.getInstance();
    EntityManager entityManager = hyperJpa.getEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    @Override
    public boolean ajouterReservation(ReservationEntity reservationEntity) {

        try {
            transaction.begin();
            entityManager.persist(reservationEntity.getClient());
            for (VolEntity vol:reservationEntity.getVolEntities()){
                entityManager.persist(vol);
            }
            entityManager.persist(reservationEntity.getBagage());
            entityManager.persist(reservationEntity);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
        }
        return false;
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
        Query query = entityManager.createNativeQuery("SELECT * FROM reservation where code = :code",ReservationEntity.class);
        query.setParameter("code",code);
        return (Collection<ReservationEntity>) query.getResultList();
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
        query.setParameter("etat_reservation", ReservationStatus.CONFIRMER.toString());
        ArrayList<ReservationEntity> reservationEntities = (ArrayList<ReservationEntity>) query.getResultList();

        return reservationEntities;
    }

    @Override
    public ArrayList<ReservationEntity> lesRservationAnnulésPendantMoisOuAns(HashMap<String, String> conditions) {
        Query query = entityManager.createNativeQuery("SELECT * FROM reservation WHERE date_reservation BETWEEN :date_1 AND :date_2 AND status = :etat_reservation", ReservationEntity.class);
        query.setParameter("date_1", conditions.get("date_1"));
        query.setParameter("date_2", conditions.get("date_2"));
        query.setParameter("etat_reservation", ReservationStatus.ANNULER.toString());
        ArrayList<ReservationEntity> reservationEntities = (ArrayList<ReservationEntity>) query.getResultList();
        return reservationEntities;
    }

    @Override
    public int statisticsReservation(ReservationStatus reservationStatus, String mois) {
        this.entityManager.createNativeQuery("SELECT count(*) FROM reservation WHERE status = :status AND date_reservation LIKE :mois")
                .setParameter("status",reservationStatus.toString())
                .setParameter("mois",mois)
                .getSingleResult();
        return 0;
    }

    @Override
    public boolean annulerReservation(ReservationEntity reservationEntity) {
        if (reservationEntity == null){
            return false;
        }

        this.transaction.begin();
        ReservationEntity reservationEntity1 = entityManager.find(ReservationEntity.class, reservationEntity.getId());
        reservationEntity1.setStatus(ReservationStatus.ANNULER);
        this.transaction.commit();
        return false;
    }
}
