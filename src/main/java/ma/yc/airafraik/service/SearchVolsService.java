package ma.yc.airafraik.service;

import ma.yc.airafraik.entities.ReservationEntity;
import ma.yc.airafraik.entities.VolEntity;

import java.util.Collection;

public interface SearchVolsService {


    public Collection<VolEntity> searchVols(String villeDepart, String villeArrivee, String dateDepart, String dateArrivee, String nombrePassagers);

    VolEntity searchVolParId(String id);

    Collection<VolEntity> consulterVols();
}
