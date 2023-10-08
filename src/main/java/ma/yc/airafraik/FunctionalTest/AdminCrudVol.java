package ma.yc.airafraik.FunctionalTest;

import ma.yc.airafraik.core.Util;
import ma.yc.airafraik.dao.Impl.VolDaoImpl;
import ma.yc.airafraik.dao.VolDao;
import ma.yc.airafraik.entites.SocieteAerienneEntity;
import ma.yc.airafraik.entites.VolEntity;

public class AdminCrudVol {


    public static void main(String[] args) {
        VolDao volDao = new VolDaoImpl();

        ajouterVol(volDao);

        //TODO : ENGS : VOL


    }


    public  static boolean ajouterVol(VolDao volDao ){
        VolEntity vol = Util.getVolEntity();
        SocieteAerienneEntity societeAerienneEntity = Util.getSocieteAerienneEntity();
        vol.setSocieteAerienneEntity(societeAerienneEntity);

        try{
            volDao.ajouterVol(vol);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("DONE !");

        return true;

    }
}
