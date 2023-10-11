package ma.yc.airafraik.dao.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import ma.yc.airafraik.connection.HyperJpa;
import ma.yc.airafraik.dao.ClientDao;
import ma.yc.airafraik.entities.ClientEntity;
import ma.yc.airafraik.entities.VolEntity;
import org.hibernate.Session;
import pl.mjaron.etudes.Arr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class ClientDaoImpl implements ClientDao {

    HyperJpa hyperJpa = HyperJpa.getInstance();
    EntityManager entityManager = hyperJpa.getEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    Session session = entityManager.unwrap(Session.class);

    private ArrayList<ClientEntity> clientEntities  = new ArrayList<>();
    private ClientEntity client = null;
    @Override
    public boolean ajouterClient() {
        return false;
    }

    @Override
    public boolean ajouterClient(ClientEntity client) {
        return false;
    }

    @Override
    public boolean ajouterClients() {
        return false;
    }

    @Override
    public boolean ajouterClients(ClientEntity[] clients) {
        return false;
    }

    @Override
    public boolean modifierClients() {
        return false;
    }

    @Override
    public boolean modifierClients(ClientEntity[] clients) {
        return false;
    }

    @Override
    public boolean modifierClient() {
        return false;
    }

    @Override
    public boolean modifierClient(ClientEntity client) {
        return false;
    }

    @Override
    public boolean supprimerClient() {
        return false;
    }

    @Override
    public boolean supprimerClient(ClientEntity client) {
        return false;
    }

    @Override
    public boolean supprimerClients() {
        return false;
    }

    @Override
    public boolean supprimerClients(ClientEntity[] clients) {
        return false;
    }

    @Override
    public ClientEntity consulterClient() {

        return null;
    }

    @Override
    public ArrayList<ClientEntity> consulterClients(HashMap<String, String> conditions) {
        String jpql = "SELECT c FROM ma.yc.airafraik.entities.ClientEntity c WHERE  ";
        for (String key : conditions.keySet()) {
            jpql += "c." + key + " = '" + conditions.get(key) + "' AND ";
        }
        //remove the last AND
        jpql = jpql.substring(0, jpql.length() - 4);

        TypedQuery<ClientEntity> query = entityManager.createQuery(jpql, ClientEntity.class);

        return (ArrayList<ClientEntity>) query.getResultList();
    }

    @Override
    public Collection<ClientEntity> consulterClients() {
        return null;
    }
}
