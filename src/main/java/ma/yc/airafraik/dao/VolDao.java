package ma.yc.airafraik.dao;

import ma.yc.airafraik.entities.VolEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public interface VolDao {
    public boolean ajouterVol();
    public boolean ajouterVol(VolEntity vol);
    public boolean ajouterVols();
    public boolean ajouterVols(VolEntity[] vols);

    public boolean modifierVols();
    public boolean modifierVols(VolEntity[] vols);

    public boolean modifierVol();
    public boolean modifierVol(VolEntity vol);
    public boolean supprimerVol();
    public boolean supprimerVol(VolEntity vol);
    public boolean supprimerVols();
    public boolean supprimerVols(VolEntity[] vols);

    public VolEntity consulterVol(String id);
    public ArrayList<VolEntity> consulterVols(HashMap<String, String> conditions);
    public Collection<VolEntity> consulterVols();
}
