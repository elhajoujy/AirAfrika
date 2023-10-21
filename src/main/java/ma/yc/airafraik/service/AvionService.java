package ma.yc.airafraik.service;

import ma.yc.airafraik.entities.AvionEntity;

import java.util.Collection;

public interface AvionService {

    public Collection<AvionEntity> consulterAvions();
    public AvionEntity consulterAvion(String id);

    public void ajouterAvion(AvionEntity avionEntity);
}
