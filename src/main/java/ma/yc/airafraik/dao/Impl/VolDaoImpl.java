package ma.yc.airafraik.dao.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import ma.yc.airafraik.connection.HyperJpa;
import ma.yc.airafraik.dao.VolDao;
import ma.yc.airafraik.entites.VolEntity;

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

            this.entityManager.persist(vol.getSocieteAerienneEntity());

            this.entityManager.persist(vol);
            this.transaction.commit();

            hyperJpa.commitTransaction();

        } finally {
            hyperJpa.rollbackTransaction();
            hyperJpa.close();
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
        return false;
    }

    @Override
    public boolean supprimerVol() {
        return false;
    }

    @Override
    public boolean supprimerVol(VolEntity vol) {
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
    public VolEntity consulterVol() {
        return null;
    }

    @Override
    public Collection<VolEntity> consulterVols(HashMap<String, String> conditions) {
        return null;
    }

    @Override
    public Collection<VolEntity> consulterVols() {
        EntityManager entityManager = this.hyperJpa.getEntityManager();
        String jpql = "SELECT v FROM VolEntity v";
        TypedQuery<VolEntity> query = entityManager.createQuery(jpql, VolEntity.class);
        Collection<VolEntity> volEntities = query.getResultList();
        return volEntities;
    }


}
