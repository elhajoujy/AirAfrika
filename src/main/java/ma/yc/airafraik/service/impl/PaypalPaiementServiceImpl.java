package ma.yc.airafraik.service.impl;

import ma.yc.airafraik.service.PaiementService;

public class PaypalPaiementServiceImpl implements PaiementService{
    double fakeAccountSolde = 1000;
    @Override
    public boolean payer(double montant) {
//        System.out.println("Paiement Paypal de "+montant+" effectué avec succès");
//        System.out.println("Solde restant : "+(fakeAccountSolde-montant));
        return true;

    }

    @Override
    public double verifierSolde() {
        return    this.fakeAccountSolde;
    }
}
