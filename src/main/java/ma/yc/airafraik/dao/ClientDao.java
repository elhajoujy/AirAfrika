package ma.yc.airafraik.dao;

import ma.yc.airafraik.entities.ClientEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public interface ClientDao {
    public boolean ajouterClient();
    public boolean ajouterClient(ClientEntity client);
    public boolean ajouterClients();
    public boolean ajouterClients(ClientEntity[] clients);

    public boolean modifierClients();
    public boolean modifierClients(ClientEntity[] clients);

    public boolean modifierClient();
    public boolean modifierClient(ClientEntity client);
    public boolean supprimerClient();
    public boolean supprimerClient(ClientEntity client);
    public boolean supprimerClients();
    public boolean supprimerClients(ClientEntity[] clients);

    public ClientEntity consulterClient();
    public ArrayList<ClientEntity> consulterClients(HashMap<String, String> conditions);
    public Collection<ClientEntity> consulterClients();
}
