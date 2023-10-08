package ma.yc.airafraik;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import ma.yc.airafraik.Helper.FakeEntitesHelper;
import ma.yc.airafraik.entites.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();

//            LogEntity logEntity = FakeEntitesHelper.getLogEntity();
//
//            ClientEntity clientEntity = FakeEntitesHelper.getClientEntity();
//
//            AdministrateurEntity administrateurEntity = FakeEntitesHelper.getAdministrateurEntity();
//
//            VilleEntity ville = FakeEntitesHelper.getVilleEntity();
//
//            entityManager.persist(ville);
//
//            for (VilleImageEntity imageEntity : ville.getImageEntities()) {
//                entityManager.persist(imageEntity);
//            }

            //TODO : ENGS : SOCIETE



            transaction.commit();

        }finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
