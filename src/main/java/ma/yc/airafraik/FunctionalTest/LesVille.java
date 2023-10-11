package ma.yc.airafraik.FunctionalTest;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import ma.yc.airafraik.Helper.FakeEntitesHelper;
import ma.yc.airafraik.connection.HyperJpa;
import ma.yc.airafraik.dao.Impl.VilleDaoImpl;
import ma.yc.airafraik.dao.VilleDao;
import ma.yc.airafraik.entities.VilleEntity;
import ma.yc.airafraik.entities.VilleImageEntity;

import java.util.HashMap;
import java.util.List;

public class LesVille {



    public static void main(String[] args) {
        VilleDao villeDao = new VilleDaoImpl();
        EntityManager entityManager = HyperJpa.getInstance().getEntityManager();

        System.out.println("Hello Ville");

        HashMap<String, String > conditions = new HashMap<>();

        conditions.put("id", "112");


        List<VilleEntity> villeEntities = villeDao.consulterVille(conditions);


        //add image to ville
        try{
            HyperJpa.getInstance().beginTransaction();

            for (VilleImageEntity imageEntity : FakeEntitesHelper.getVilleEntity().getImageEntities()) {
                imageEntity.setVille(villeEntities.get(0));
                villeEntities.get(0).getImageEntities().add(imageEntity);
            }

            entityManager.persist(villeEntities.get(0));

            HyperJpa.getInstance().commitTransaction();
        }catch (Exception e){
            HyperJpa.getInstance().rollbackTransaction();
        }finally {
            HyperJpa.getInstance().close();
        }




    }
}
