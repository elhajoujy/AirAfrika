package ma.yc.airafraik.service;

import ma.yc.airafraik.entities.ReservationEntity;
import ma.yc.airafraik.enums.ReservationStatus;

import java.util.HashMap;

public interface ReservationService {
    public double confirmationReservation(ReservationEntity reservationEntity);
    public ReservationEntity annulationReservation(ReservationEntity reservationEntity);
    public boolean annulationReservation(String numeroReservation);
    public boolean envoyerEmail(ReservationEntity reservationEntity);

    int  statisticsReservation(ReservationStatus reservationStatus, HashMap<String, String> conditions);
}
