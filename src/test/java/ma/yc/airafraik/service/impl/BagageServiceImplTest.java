package ma.yc.airafraik.service.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagageServiceImplTest {


    @Test
    void calculerPrixBagage() {
        BagageServiceImpl bagageService = new BagageServiceImpl();
        double prix = bagageService.calculerPrixBagage(10);
        assertEquals(250, prix);
    }
}