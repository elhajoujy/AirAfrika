package ma.yc.airafraik.service;

import ma.yc.airafraik.entities.ReservationEntity;

public interface ReservationService {
    public double confirmationReservation(ReservationEntity reservationEntity);
    public double annulationReservation(ReservationEntity reservationEntity);
    public boolean envoyerEmail(ReservationEntity reservationEntity);
}
