package ma.yc.airafraik.service;

import ma.yc.airafraik.entities.VolEntity;

import java.util.Collection;

public interface VolsService {


    public Collection<VolEntity> searchVols(String villeDepart, String villeArrivee, String dateDepart, String dateArrivee, String nombrePassagers);

    VolEntity searchVolParId(String id);

    Collection<VolEntity> consulterVols();

    boolean deleteVol(String idVol);
}
