package ma.yc.airafraik.service.impl;

import ma.yc.airafraik.service.PaiementService;
import ma.yc.airafraik.service.ReservationService;

public class ReservationServiceImpl implements ReservationService {

    private PaiementService paiementService ;

    public ReservationServiceImpl(PaiementService paiementService) {
        this.paiementService = paiementService;
    }
    @Override
    public double confirmationReservation(Object object) {
        //TODO : une réduction de 19% s'applique pour les clients qui réservant aller/retour
        return this.confirmationReservation("");
    }

    @Override
    public double annulationReservation(Object object) {
        //TODO : annuler sa réservation après la confirmation de son vol dans le cas d'annulation:
        // 8% des frais est retenue pour la société AirAfrika > 24h avant le vol

        return 1;
    }
}
