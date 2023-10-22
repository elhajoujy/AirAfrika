package ma.yc.airafraik.service.impl;

import ma.yc.airafraik.FunctionalTest.Client.ConfirmationReservationEtEnvoyeEmail;
import ma.yc.airafraik.core.Util;
import ma.yc.airafraik.dao.Impl.ReservationDaoImpl;
import ma.yc.airafraik.dao.ReservationDao;
import ma.yc.airafraik.entities.ReservationEntity;
import ma.yc.airafraik.enums.ReserveType;
import ma.yc.airafraik.service.PaiementService;
import ma.yc.airafraik.service.ReservationService;

public class ReservationServiceImpl implements ReservationService {

    private PaiementService paiementService ;
    private ConfirmationReservationEtEnvoyeEmail confirmationReservationEtEnvoyeEmail;
    private ReservationDao reservationDao;

    public ReservationServiceImpl() {
        this.reservationDao = new ReservationDaoImpl();
    }

    public ReservationServiceImpl(PaiementService paiementService) {
        this.paiementService = paiementService;
    }
    @Override
    public double confirmationReservation(ReservationEntity reservationEntity) {
        if (reservationEntity == null) {
            // Handle the case where the reservation is null
            return 0;
        }

        reservationEntity.setCode(Util.generateFlightTicketCode(Util.generateRandomCode(),
                Util.generatedLong()
                )
        );


        reservationEntity.setFlightType(ReserveType.ALLER_RETOUR);


        double totalCost = reservationEntity.getPrixTotal();

        if (reservationEntity.getFlightType() == ReserveType.ALLER) {
            // This reservation is for an "aller" (one-way) flight
        } else if (reservationEntity.getFlightType() == ReserveType.RETOUR) {
            // This reservation is for a "retour" (round-trip) flight
        } else if (reservationEntity.getFlightType() == ReserveType.ALLER_RETOUR) {
            // This reservation is for an "aller_retour" (round-trip) flight
            double discount = 0.10 * totalCost;
            totalCost -= discount;
            reservationEntity.setPrixTotal(totalCost);
        } else {
            // Handle the case where the flight type is none of the specified values
        }

        boolean save = this.reservationDao.ajouterReservation(reservationEntity);
        if (!save) {
            // Handle the case where the reservation could not be saved
            return 0;
        }else {
            //TODO : SEEND EMAIL TO CLIENT WITH HIS RESERVATION CODE AND PDF FILE
            this.envoyerEmail(reservationEntity);

        }

        return totalCost;
    }

    @Override
    public double annulationReservation(ReservationEntity reservationEntity) {
        //TODO : annuler sa réservation après la confirmation de son vol dans le cas d'annulation:
        // 8% des frais est retenue pour la société AirAfrika > 24h avant le vol

        return 1;
    }

    @Override
    public boolean envoyerEmail(ReservationEntity reservationEntity) {

        return false;
    }
}
