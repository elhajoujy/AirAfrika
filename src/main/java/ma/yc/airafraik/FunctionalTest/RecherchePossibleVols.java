package ma.yc.airafraik.FunctionalTest;


import ma.yc.airafraik.core.Print;
import ma.yc.airafraik.dao.Impl.VolDaoImpl;
import ma.yc.airafraik.dao.VolDao;
import ma.yc.airafraik.entities.VolEntity;
import pl.mjaron.etudes.Arr;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class RecherchePossibleVols {

    static String  villeDepart = "SAFI";
    static  String villeArrivee = "RABAT";

    public static void main(String[] args) {
        VolDao volDao = new VolDaoImpl();
        System.out.println("Hello World!");


    }



    public static ArrayList<VolEntity> filterVolsParPourLesConditions(){
        HashMap<String , String> conditions = new HashMap<>();
        VolDao volDao = new VolDaoImpl();

        conditions.put("villeDepart" , villeDepart);
        conditions.put("villeArrivee" , villeArrivee);
        ArrayList<VolEntity> vols =  volDao.consulterVols(conditions);

        ArrayList<VolEntity> filteredVols = new ArrayList<>();
        Print.log(vols.size());

        // Filter vols BY dateDepart NEED TO BE THE SAME AS THE
        for (VolEntity volDepart : vols) {
            if (Objects.equals(volDepart.getVilleDepart(), villeDepart)){
                for (VolEntity volEscale : vols) {
                    if (Objects.equals(volEscale.getVilleDepart(), volDepart.getVilleArrivee()) ){
                        LocalTime localTimeVolDepart = LocalTime.parse(volDepart.getHeureArrivee());
                        LocalTime localTimeVolEscale = LocalTime.parse(volEscale.getHeureDepart());

                        if (localTimeVolDepart.isBefore(localTimeVolEscale)){
                            filteredVols.add(volEscale);
                            Print.log("Vol Depart : "  + volDepart.getVilleDepart()+ " => " + volDepart.getHeureDepart() + " Vol Escale : " + volEscale.getHeureDepart()+ " ||  "
                                    + volEscale.getVilleDepart() + " => " + volEscale.getVilleArrivee() + " :  " + volEscale.getHeureArrivee());

                        }


                    }
                }
            }
        }
        return filteredVols;
    }
}
