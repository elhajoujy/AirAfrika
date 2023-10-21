package ma.yc.airafraik.service.impl;

import ma.yc.airafraik.dao.Impl.VolDaoImpl;
import ma.yc.airafraik.dao.VolDao;
import ma.yc.airafraik.entities.VolEntity;
import ma.yc.airafraik.service.SearchVolsService;
import ma.yc.airafraik.service.VolService;

public class VolServiceImpl implements VolService {

    private VolDao volDao;
    private SearchVolsService searchVolsService;


    public VolServiceImpl() {
        this.volDao = new VolDaoImpl();
        this.searchVolsService = new SearchVolsServiceImpl();
    }

    @Override
    public boolean ajouterVol(VolEntity vol) {
        if (vol == null) return false;
       return this.volDao.ajouterVol(vol);
    }

    @Override
    public boolean supprimerVol(String id) {
        VolEntity vol = this.searchVolsService.searchVolParId(id);
        return this.volDao.supprimerVol(vol);
    }
}
