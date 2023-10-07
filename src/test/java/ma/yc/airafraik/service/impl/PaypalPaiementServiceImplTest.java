package ma.yc.airafraik.service.impl;

import ma.yc.airafraik.service.PaiementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaypalPaiementServiceImplTest {

    double fakeAccountSolde = 1000;
    PaiementService paiementService  ;
    @BeforeEach
    void setUp() {
        paiementService = new PaypalPaiementServiceImpl();
    }

    @Test
    void payer() {
        boolean payer = paiementService.payer(100);
        assertTrue(payer);
    }

    @Test
    void verifierSolde() {
        assertEquals(1000,paiementService.verifierSolde());
    }
}