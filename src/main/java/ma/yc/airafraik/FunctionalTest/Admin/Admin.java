package ma.yc.airafraik.FunctionalTest.Admin;

import jakarta.persistence.EntityManager;
import ma.yc.airafraik.connection.HyperJpa;
import ma.yc.airafraik.core.Print;
import ma.yc.airafraik.entities.AdministrateurEntity;

public class Admin {
    public static void main(String[] args) {
        EntityManager em = HyperJpa.getInstance().getEntityManager();


        try{
            HyperJpa.getInstance().beginTransaction();

            AdministrateurEntity admin = em.find(AdministrateurEntity.class, 1);
            //YOU CAN DO ANYTHING YOU WANT HERE
            admin.setNom("jhskjhdsh");
            Print.log("admin => " + admin.toString());



            HyperJpa.getInstance().commitTransaction();
        }catch (Exception e){
            Print.log("Exception => " + e.getMessage());
            HyperJpa.getInstance().rollbackTransaction();
        }finally {
            HyperJpa.getInstance().close();
        }
    }

}
