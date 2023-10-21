package ma.yc.airafraik.dao.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import ma.yc.airafraik.connection.HyperJpa;
import ma.yc.airafraik.core.Print;
import ma.yc.airafraik.dao.VolDao;
import ma.yc.airafraik.entities.VolEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class VolDaoImpl implements VolDao {

    private VolEntity vol;
    private Collection<VolEntity> vols ;
    HyperJpa hyperJpa = HyperJpa.getInstance();
    EntityManager entityManager = hyperJpa.getEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();

    public VolDaoImpl() {
    }

    public VolDaoImpl(VolEntity vol , HyperJpa hyperJpa) {
        this.vol = vol;
        this.hyperJpa = hyperJpa;
    }

    public VolDaoImpl(HyperJpa hyperJpa) {
        this.hyperJpa = hyperJpa;
    }

    @Override
    public boolean ajouterVol() {
        if (this.vol == null) return false;
        try {
            hyperJpa.beginTransaction();


            this.entityManager.persist(this.vol);
            this.transaction.commit();

            hyperJpa.commitTransaction();

        } finally {
            hyperJpa.rollbackTransaction();
            hyperJpa.close();
        }


        return true;
    }

    @Override
    public boolean ajouterVol(VolEntity vol) {

        if (vol == null) return false;
        try {
            hyperJpa.beginTransaction();


//            this.entityManager.persist(vol.getSocieteAerienneEntity());


            this.entityManager.persist(vol.getAvion());

            this.entityManager.persist(vol);
            this.transaction.commit();

            return true;

        }catch (Exception e){
            if (transaction != null && transaction.isActive()) {
                transaction.rollback(); // Rollback the transaction in case of an exception
            }
            else {
                e.printStackTrace();
                transaction.rollback();
            }
        }

        return false;
    }

    @Override
    public boolean ajouterVols() {
        if (this.vols == null) return false;
        try {
            hyperJpa.beginTransaction();

            for (VolEntity vol : this.vols) {
                this.entityManager.persist(vol);
            }
            this.transaction.commit();

            hyperJpa.commitTransaction();

        } finally {
            hyperJpa.rollbackTransaction();
            hyperJpa.close();
        }

        return false;
    }

    @Override
    public boolean ajouterVols(VolEntity[] vols) {
        if (this.vols == null) return false;
        try {
            hyperJpa.beginTransaction();

            for (VolEntity vol : vols) {
                this.entityManager.persist(vol);
            }
            this.transaction.commit();

            hyperJpa.commitTransaction();

        } finally {
            hyperJpa.rollbackTransaction();
            hyperJpa.close();
        }
        return false;
    }

    @Override
    public boolean modifierVols() {
        return false;
    }

    @Override
    public boolean modifierVols(VolEntity[] vols) {
        return false;
    }

    @Override
    public boolean modifierVol() {
        return false;
    }

    @Override
    public boolean modifierVol(VolEntity vol) {
        try{
            this.transaction.begin();


            this.entityManager.merge(vol);

            this.transaction.commit();
            Print.log("Vol modifié avec succès");
            return true;

        }catch (Exception e){
            if (transaction != null && transaction.isActive()) {
                transaction.rollback(); // Rollback the transaction in case of an exception
            }
        }finally {
            this.entityManager.close();
        }

        return false;
    }

    @Override
    public boolean supprimerVol() {
        return false;
    }


    @Override
    public boolean supprimerVol(VolEntity vol) {
        try{
            transaction.begin();
            Query query = entityManager.createQuery("DELETE FROM VolEntity v WHERE v.code = :code");
            query.setParameter("code", vol.getCode());

            if (query.executeUpdate() > 0) {
                Print.log("Vol supprimé avec succès");
                transaction.commit();
                return true;
            }
            Print.log("Erreur lors de la suppression du vol");
            transaction.rollback();
        }catch (Exception e){
            if (transaction != null && transaction.isActive()) {
                transaction.rollback(); // Rollback the transaction in case of an exception
            }
        }finally {
            this.entityManager.close();
        }

        return false;
    }

    @Override
    public boolean supprimerVols() {
        return false;
    }

    @Override
    public boolean supprimerVols(VolEntity[] vols) {
        return false;
    }

    @Override
    public VolEntity consulterVol(String id) {
        Integer volId = Integer.parseInt(id);
        return this.entityManager.find(VolEntity.class, volId);
    }

    @Override
    public ArrayList<VolEntity> consulterVols(HashMap<String, String> conditions) {
//        EntityManager entityManager = this.hyperJpa.getEntityManager();
        String jpql = "SELECT v FROM VolEntity v WHERE ";
        for (String key : conditions.keySet()) {
            jpql += "v." + key + " = '" + conditions.get(key) + "' AND ";
        }
        //remove the last AND
        jpql = jpql.substring(0, jpql.length() - 4);

        TypedQuery<VolEntity> query = entityManager.createQuery(jpql, VolEntity.class);
        ArrayList<VolEntity> volEntities = (ArrayList<VolEntity>) query.getResultList();

        return volEntities;
    }

    @Override
    public Collection<VolEntity> consulterVols() {
//        EntityManager entityManager = this.hyperJpa.getEntityManager();
        String jpql = "SELECT v FROM VolEntity v";
        TypedQuery<VolEntity> query = entityManager.createQuery(jpql, VolEntity.class);
        Collection<VolEntity> volEntities = query.getResultList();
        return volEntities;
    }


}
