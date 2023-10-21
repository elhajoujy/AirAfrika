package ma.yc.airafraik.dao;

import ma.yc.airafraik.entities.AvionEntity;

import java.util.Collection;

public interface AvionDao {

    public boolean ajouterAvion(AvionEntity avion);
    public boolean supprimerAvion(String id);
    public boolean modifierAvion(AvionEntity avion);
    public AvionEntity consulterAvion(String id);
    public Collection<AvionEntity> consulterAvions();
    



}
