package ma.yc.airafraik.service.impl;

import ma.yc.airafraik.dao.Impl.VolDaoImpl;
import ma.yc.airafraik.dao.VolDao;
import ma.yc.airafraik.entities.ReservationEntity;
import ma.yc.airafraik.entities.VolEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class SearchVolsServiceImpl implements ma.yc.airafraik.service.SearchVolsService{

    private VolDao volDao ;

    public SearchVolsServiceImpl() {
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
}
