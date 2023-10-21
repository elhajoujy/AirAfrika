package ma.yc.airafraik.service;

import ma.yc.airafraik.entities.VolEntity;

public interface VolService {
    public boolean ajouterVol(VolEntity vol);

    boolean supprimerVol(String id);
}
