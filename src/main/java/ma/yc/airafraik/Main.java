package ma.yc.airafraik;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import ma.yc.airafraik.entites.LogEntity;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try{
            transaction.begin();
//            LogEntity logEntity = new LogEntity();
//            logEntity.setLogDate(new java.sql.Timestamp(new java.util.Date().getTime()));
//            logEntity.setLogKey("key");
//            logEntity.setLogMessage("this is the second message trying to log everything to database");
//            logEntity.setLogLevel("level");
//            entityManager.persist(logEntity);
            LogEntity logEntity = entityManager.find(LogEntity.class, 1);
            System.out.println(logEntity.getLogMessage());
            List<LogEntity> logEntities = entityManager.createQuery("SELECT l FROM LogEntity l", LogEntity.class).getResultList();
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
