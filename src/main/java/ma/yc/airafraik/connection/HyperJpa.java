package ma.yc.airafraik.connection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.Getter;
import ma.yc.airafraik.presistence.CustomPresistenceUnitInfo;
import org.hibernate.Session;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;

public class HyperJpa {

    private static HyperJpa instance;
    private final EntityManagerFactory entityManagerFactory;
    @Getter
    private final EntityManager entityManager;

    private HyperJpa() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
//        entityManagerFactory = new HibernatePersistenceProvider().
//                createContainerEntityManagerFactory(new CustomPresistenceUnitInfo(), new HashMap<>());
        entityManager = entityManagerFactory.createEntityManager();
    }



    public static Session getSession(){
        return getInstance().entityManager.unwrap(Session.class);
    }

    public static HyperJpa getInstance() {
        if (instance == null) {
            instance = new HyperJpa();
        }
        return instance;
    }

    public void beginTransaction() {
        entityManager.getTransaction().begin();
    }

    public void commitTransaction() {
        entityManager.getTransaction().commit();
    }

    public void rollbackTransaction() {
        EntityTransaction transaction = entityManager.getTransaction();
        if (transaction.isActive()) {
            transaction.rollback();
        }
    }

    public void close() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }
}
