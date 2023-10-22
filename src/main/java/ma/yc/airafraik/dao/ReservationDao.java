package ma.yc.airafraik.dao;

import ma.yc.airafraik.entities.ReservationEntity;
import ma.yc.airafraik.enums.ReservationStatus;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public interface ReservationDao {


    public boolean ajouterReservation(ReservationEntity reservationEntity);

    public void modifierReservation(ReservationEntity reservationEntity);

    public void supprimerReservation(ReservationEntity reservationEntity);

    public void changerEtatReservation(ReservationEntity reservationEntity, ReservationStatus reservationStatus);

    public Collection<ReservationEntity> consulterReservations();

    public Collection<ReservationEntity> consulterReservations(String code);


    public ArrayList<ReservationEntity> AfficheLesStatistiques(HashMap<String , String> conditions, ReservationStatus reservationStatus);
    public ArrayList<ReservationEntity> lesRservationConfirmésPendantMoisOuAns(HashMap<String , String> conditions);
    public ArrayList<ReservationEntity> lesRservationAnnulésPendantMoisOuAns(HashMap<String , String> conditions);





}
