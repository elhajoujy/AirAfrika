package ma.yc.airafraik.service.impl;

import ma.yc.airafraik.FunctionalTest.Client.ConfirmationReservationEtEnvoyeEmail;
import ma.yc.airafraik.core.EmailProvider;
import ma.yc.airafraik.core.Print;
import ma.yc.airafraik.core.Util;
import ma.yc.airafraik.dao.Impl.ReservationDaoImpl;
import ma.yc.airafraik.dao.ReservationDao;
import ma.yc.airafraik.entities.ReservationEntity;
import ma.yc.airafraik.entities.VolEntity;
import ma.yc.airafraik.enums.ReservationStatus;
import ma.yc.airafraik.enums.ReserveType;
import ma.yc.airafraik.service.PaiementService;
import ma.yc.airafraik.service.ReservationService;

import java.awt.font.TextHitInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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
            // : SEEND EMAIL TO CLIENT WITH HIS RESERVATION CODE AND PDF FILE
            if (this.envoyerEmail(reservationEntity))
            {
                Print.log("Email sent successfully");
            }else {
                Print.log("Email not sent");
                throw new RuntimeException("Email not sent");
            }

        }

        return totalCost;
    }

    @Override
    public ReservationEntity annulationReservation(ReservationEntity reservationEntity) {
        //TODO : annuler sa réservation après la confirmation de son vol dans le cas d'annulation:
        // 8% des frais est retenue pour la société AirAfrika > 24h avant le vol

        return null;
    }

    @Override
    public boolean annulationReservation(String numeroReservation) {

        if (numeroReservation == null){
            return false;
        }
        // : annuler sa réservation après la confirmation de son vol dans le cas d'annulation:
        // 8% des frais est retenue pour la société AirAfrika > 24h avant le vol

        Collection<ReservationEntity> reservationEntities = this.reservationDao.consulterReservations(numeroReservation);
        if (reservationEntities == null){
            return false;
        }
        for (ReservationEntity reservationEntity : reservationEntities){
            if (reservationEntity == null){
                return false;
            }
            if (reservationEntity.getStatus() == ReservationStatus.CONFIRMER || reservationEntity.getStatus() == ReservationStatus.EN_ATTENTE){
                // : THE CLIENT CAN'T CANCEL HIS RESERVATION AFTER 24H BEFORE THE FLIGHT
                reservationEntity.setStatus(ReservationStatus.ANNULER);

                for (VolEntity vol : reservationEntity.getVolEntities()){
                    if (vol == null){
                        return false;
                    }
                    if (vol.getDateDepart().before(Util.addHours(24))){
                        return false;
                    }else {
                        // : THE CLIENT WILL PAY 8% OF THE TOTAL COST OF THE FLIGHT
                        double totalCost = reservationEntity.getPrixTotal();
                        double cost = totalCost * 0.08;
                        reservationEntity.setPrixTotal(totalCost - cost);
                        return this.reservationDao.annulerReservation(reservationEntity);
                    }
                }

            }
        }


        return false;
    }

    @Override
    public boolean envoyerEmail(ReservationEntity reservationEntity) {
        if (reservationEntity == null){
            return false;
        }
        String email = "souirimehdi311@gmail.com";
        String subject = "Confirmation de votre réservation";
        String message = "Bonjour Mr/Mme "+reservationEntity.getClient().getNom()+" "+reservationEntity.getClient().getPrenom()+"\n" +
                "Nous vous confirmons votre réservation de vol avec la compagnie Air Afraik\n" +
                "Votre code de réservation est : "+reservationEntity.getCode()+"\n" +
                "Merci de votre confiance\n" +
                "Cordialement\n" +
                "Air Afraik";


        return EmailProvider.sendMail(message,subject,email);

    }

    @Override
    public int statisticsReservation(ReservationStatus reservationStatus,HashMap<String, String> conditions) {


        // : THE CLIENT WIL CHOOSE TWO DATE CALLED DATE_1 AND DATE_2 FROM THE CALENDER


        if (reservationStatus == null || conditions == null){
            return 0;
        }

        ArrayList<ReservationEntity> reservationEntities =
                reservationDao.AfficheLesStatistiques(conditions, reservationStatus);


        return reservationEntities.size();

    }
}
