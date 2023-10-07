package ma.yc.airafraik.service;

public interface PaiementService {
    boolean payer(double montant);
    double verifierSolde();
}
