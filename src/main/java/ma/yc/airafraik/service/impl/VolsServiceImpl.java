package ma.yc.airafraik.service.impl;

import ma.yc.airafraik.dao.Impl.VolDaoImpl;
import ma.yc.airafraik.dao.VolDao;
import ma.yc.airafraik.entities.VolEntity;
import ma.yc.airafraik.service.VolsService;

import java.util.Collection;
import java.util.HashMap;

public class VolsServiceImpl implements VolsService {

    private VolDao volDao ;

    public VolsServiceImpl() {
        this.volDao = new VolDaoImpl();
    }

    @Override
    public Collection<VolEntity> searchVols(String villeDepart, String villeArrivee, String dateDepart, String dateArrivee, String nombrePassagers) {
        //TODO : implement searchVols BY FILTERING THE DATA FROM THE CONTROLLER AND RETURNING THE RESULT FROM THE DAO
        HashMap<String,String> conditions = new HashMap<>();
        conditions.put("villeDepart",villeDepart);
//        conditions.put("villeArrivee",villeArrivee);
//        conditions.put("dateDepart",dateDepart);
//        conditions.put("dateArrive",dateArrivee);
//        conditions.put("nombrePassagers",nombrePassagers);

        return this.volDao.consulterVols(conditions);
    }

    @Override
    public VolEntity searchVolParId(String id) {
        if (id == null) return null;
       VolEntity vol =  this.volDao.consulterVol(id);


       return  vol;


    }

    @Override
    public Collection<VolEntity> consulterVols() {
        return this.volDao.consulterVols();
    }

    @Override
    public boolean deleteVol(String idVol) {

        if (idVol == null) return false;
        return this.volDao.deleteVol(idVol);
    }
}
