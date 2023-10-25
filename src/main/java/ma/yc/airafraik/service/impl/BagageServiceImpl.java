package ma.yc.airafraik.service.impl;

import ma.yc.airafraik.service.BagageService;

public class BagageServiceImpl implements BagageService {
    @Override
    public double calculerPrixBagage(double poids) {
        double prix = 0;

        if (poids <= 10) {
            prix = poids * 25; // Chaque 1 KG vaut 25 Euros
        } else if (poids > 10 && poids <= 15) {
            prix = 10 * 25 + (poids - 10) * 18; // Au-delà de 10 Kg, 1 KG vaut 18 Euros
        } else {
            prix = 10 * 25 + 5 * 18 + (poids - 15) * 18; // Au-delà de 15 Kg, 1 KG vaut toujours 18 Euros
        }

        return prix;
    }

}
