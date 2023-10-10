package ma.yc.airafraik.dao.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import ma.yc.airafraik.connection.HyperJpa;
import ma.yc.airafraik.dao.VilleDao;
import ma.yc.airafraik.entities.VilleEntity;
import ma.yc.airafraik.entities.VolEntity;

import java.util.ArrayList;
import java.util.HashMap;

public class VilleDaoImpl implements VilleDao {

    HyperJpa hyperJpa = HyperJpa.getInstance();
    EntityManager entityManager = hyperJpa.getEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    @Override
    public boolean ajouterVille() {
        return false;
    }

    @Override
    public boolean ajouterVille(VilleEntity ville) {
        return false;
    }

    @Override
    public boolean supprimerVille() {
        return false;
    }

    @Override
    public boolean supprimerVille(VilleEntity ville) {
        return false;
    }

    @Override
    public boolean modifierVille() {
        return false;
    }

    @Override
    public boolean modifierVille(VilleEntity ville) {
        return false;
    }

    @Override
    public VilleEntity consulterVille() {
        return null;
    }

    @Override
    public VilleEntity consulterVille(VilleEntity ville) {
        return null;
    }

    @Override
    public ArrayList<VilleEntity> consulterVille(HashMap<String, String> conditions) {

        String jpql = "SELECT v FROM VilleEntity v WHERE ";

        for (String key : conditions.keySet()) {
            jpql += "v." + key + " = '" + conditions.get(key) + "' AND ";
        }
        //remove the last AND
        jpql = jpql.substring(0, jpql.length() - 4);

        TypedQuery<VilleEntity> query = entityManager.createQuery(jpql, VilleEntity.class);

        ArrayList<VilleEntity> villeEntities = (ArrayList<VilleEntity>) query.getResultList();

        return villeEntities;
    }
}
