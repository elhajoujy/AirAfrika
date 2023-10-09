package ma.yc.airafraik.FunctionalTest;

import ma.yc.airafraik.core.Print;
import ma.yc.airafraik.core.Util;
import ma.yc.airafraik.dao.Impl.VolDaoImpl;
import ma.yc.airafraik.dao.VolDao;
import ma.yc.airafraik.entites.SocieteAerienneEntity;
import ma.yc.airafraik.entites.VolEntity;
import pl.mjaron.etudes.Table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class AdminCrudVol {


    public static void main(String[] args) {
        VolDao volDao = new VolDaoImpl();

//        ajouterVol(volDao);

//        consulterVols(volDao.consulterVols());

        //TODO : supprimer un vol

        //FAIRE UNE RECHERCHE DE VOL PAR ID OU CODE OU DATE OU VILLE DE DEPART OU VILLE D'ARRIVEE

        suprimmerVol("VOL-65450904");




    }

    public  static void suprimmerVol(String code){
        VolDao volDao = new VolDaoImpl();
        HashMap<String,String> conditions = new HashMap<>();
        conditions.put("code",code);
        ArrayList<VolEntity> vol = volDao.consulterVols(conditions);
        if (vol.isEmpty()){
            Print.log("Aucun vol trouvé");
            return;
        }

        volDao.supprimerVol(vol.get(0));

    }


    public static void consulterVols(Collection<VolEntity> volEntities){
        volEntities.forEach(volEntity -> {
            Print.log("--------------------------------------------------");
            Print.log(volEntity.toString());
            Print.log("--------------------------------------------------");
            Print.log(volEntity.getSocieteAerienneEntity().toString());
        });
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
