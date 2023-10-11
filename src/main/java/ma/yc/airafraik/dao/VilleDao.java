package ma.yc.airafraik.dao;

import ma.yc.airafraik.entities.ClientEntity;
import ma.yc.airafraik.entities.VilleEntity;

import java.util.ArrayList;
import java.util.HashMap;

public interface VilleDao {

    public boolean ajouterVille();

    public boolean ajouterVille(VilleEntity ville);

    public boolean supprimerVille();
    public boolean supprimerVille(VilleEntity ville);


    public boolean modifierVille();
    public boolean modifierVille(VilleEntity ville);

    public VilleEntity consulterVille();
    public VilleEntity consulterVille(VilleEntity ville);
    public ArrayList<VilleEntity> consulterVille(HashMap<String, String> conditions);





}
