package ma.yc.airafraik.FunctionalTest.Admin;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import ma.yc.airafraik.connection.HyperJpa;
import ma.yc.airafraik.core.Print;
import ma.yc.airafraik.core.Util;
import ma.yc.airafraik.dao.Impl.VolDaoImpl;
import ma.yc.airafraik.dao.VolDao;
import ma.yc.airafraik.entities.SocieteAerienneEntity;
import ma.yc.airafraik.entities.VolEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class AdminCrudVol {


    public static void main(String[] args) {
        VolDao volDao = new VolDaoImpl();

        //  ajouterVol(volDao);



//        consulterVols(volDao.consulterVols());


      //  suprimmerVol("VOL-65450904");

//        modifierVol(volDao);



//        ajouterDesAscale(volDao);

            AfficheLesEsclaeDeCestVol();








    }

    public static void AfficheLesEsclaeDeCestVol(){

        EntityManager em = HyperJpa.getInstance().getEntityManager();

        try{

            em.getTransaction().begin();

            VolEntity vol = em.find(VolEntity.class,8);

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(vol.getVilleDepart());

            boolean isEnd = false;
            VolEntity volEntity = vol;
            do {
                if (volEntity.getVol() == null){
                    isEnd = true;
                }

                stringBuilder.append("===>").append(volEntity.getVilleArrivee());
                volEntity = volEntity.getVol();
            }while (!isEnd);

            Print.log(stringBuilder.toString());

        }catch (Exception e) {
            e.printStackTrace();
            Print.log(e.getMessage());
            em.getTransaction().rollback();
        }finally {
            em.close();
        }






    }

    public static  void  ajouterDesAscale(VolDao volDao){
        EntityManager em = HyperJpa.getInstance().getEntityManager();

        try{
            em.getTransaction().begin();
            VolEntity vol = em.find(VolEntity.class,8);
            VolEntity volScale = em.find(VolEntity.class,9);

            vol.setVol(volScale);

            em.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
            Print.log(e.getMessage());
            em.getTransaction().rollback();
        }finally {
            em.close();
        }




    }

    public static void modifierVol(VolDao volDao){
        HashMap<String,String> conditions = new HashMap<>();
        conditions.put("code","VOL-48358601");
        ArrayList<VolEntity> vol = volDao.consulterVols(conditions);
        if (vol.isEmpty()){
            Print.log("Aucun vol trouvé");
            return;
        }


        VolEntity volEntity = vol.get(0);
        volEntity.setPrix(1000);
        volEntity.setHeureArrivee("14:00");
        volEntity.setHeureDepart("09:00");
        volEntity.setVilleDepart("SAFI");
        volEntity.setVilleArrivee("CASABLANCA");
        volDao.modifierVol(volEntity);

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
