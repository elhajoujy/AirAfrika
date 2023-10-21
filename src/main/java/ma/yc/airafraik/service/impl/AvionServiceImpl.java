package ma.yc.airafraik.service.impl;

import ma.yc.airafraik.dao.AvionDao;
import ma.yc.airafraik.dao.Impl.AvionDaoImpl;
import ma.yc.airafraik.entities.AvionEntity;
import ma.yc.airafraik.service.AvionService;

import java.util.Collection;

public class AvionServiceImpl implements AvionService {

    private AvionDao avionDao;

    public AvionServiceImpl() {
        this.avionDao = new AvionDaoImpl();
    }

    @Override
    public Collection<AvionEntity> consulterAvions() {
        return this.avionDao.consulterAvions();
    }

    @Override
    public AvionEntity consulterAvion(String id) {
        if (id == null) return null;
      return   this.avionDao.consulterAvion(id);
    }

    @Override
    public void ajouterAvion(AvionEntity avionEntity) {

    }
}
