package ma.yc.airafraik.Helper;

import ma.yc.airafraik.core.Print;
import ma.yc.airafraik.core.Util;
import ma.yc.airafraik.dao.Impl.VolDaoImpl;
import ma.yc.airafraik.dao.VolDao;
import ma.yc.airafraik.entities.*;
import ma.yc.airafraik.enums.ReservationStatus;

import java.time.LocalTime;
import java.util.*;

public class FakeEntitesHelper {

    public static ClientEntity getClientEntity(){
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setAdresse("84 Plantation Pointe Rd Fairhope United States ");
        clientEntity.setPrenom("ELMAHDI");
        clientEntity.setNom("ELHJOUJY");
        clientEntity.setEmail("email@example.com");
        clientEntity.setTelephone("0659707721");
        clientEntity.setPassword(Util.hasString("fakepassword"));
        clientEntity.setProfile_image("https://api.dicebear.com/7.x/micah/svg?seed=happyman");
        Long longnumber = Util.generatedLong();
        clientEntity.setCode(longnumber.toString());

        return clientEntity;
    }

    public static ArrayList<VolEntity> VolsPossibleParVilleDepartEtVilleArrivee(String villeDepart , String villeArrivee){
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



    public static ReservationEntity getReservationEntity(){
        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setCode(Util.generateRandomCode());
        reservationEntity.setPrixTotal(1000);
        reservationEntity.setDate_Reservation(new java.sql.Timestamp(new java.util.Date().getTime()));
        reservationEntity.setDateDepart("2021-09-01");
        reservationEntity.setDateArrivee("2021-09-01");
        reservationEntity.setNumberDeAdulets(2);
        reservationEntity.setNumberDeEnfants(0);
        reservationEntity.setNumberDeBebes(0);
        reservationEntity.setHeureDepart("09:00");
        reservationEntity.setHeureArrivee("14:00");
        reservationEntity.setVilleDepart("SAFI");
        reservationEntity.setVilleArrivee("RABAT");
        reservationEntity.setStatus(ReservationStatus.EN_ATTENTE);
        reservationEntity.setCancelled(false);
        //THIS WILL BE DECIDED NEXT TIME
        reservationEntity.setClient(null);
        // : WHEN WE SEARCH FOR POSSIBLE VOLS THIS WILL BE FILLED
        reservationEntity.setVolEntities(null);

        return reservationEntity;
    }
    public static AdministrateurEntity getAdministrateurEntity(){
        AdministrateurEntity administrateurEntity = new AdministrateurEntity();
        administrateurEntity.setAdresse("Admin 84 Plantation Pointe Rd Fairhope United States ");
        administrateurEntity.setPrenom("Admin ELMAHDI");
        administrateurEntity.setNom("Admin ELHJOUJY");
        administrateurEntity.setEmail("admin@example.com");
        administrateurEntity.setTelephone("0659707721");
        administrateurEntity.setPassword(Util.hasString("fakepassword"));
//        administrateurEntity.setProfile_image("https://api.dicebear.com/7.x/micah/svg?seed=happyman");
        Long longnumber = Util.generatedLong();
        administrateurEntity.setCode(longnumber.toString());

        return administrateurEntity;
    }

    public static VilleEntity getVilleEntity(){
        VilleEntity ville = new VilleEntity();
        Long longnumber = Util.generatedLong();
        ville.setCode(longnumber.toString());
        ville.setNom("SAFI");
        ville.setCodePostal("46000");
        Collection<VilleImageEntity> imageEntities  = new ArrayList<>();
        VilleImageEntity villeImageEntity = new VilleImageEntity();
        villeImageEntity.setImage("https://lh5.googleusercontent.com/p/AF1QipN0k95BmAHuCDAQoONlF75M1G7nMDbdT7JOuLs=w1080-h624-n-k-no");
        villeImageEntity.setVille(ville);

        VilleImageEntity villeImageEntity1 = new VilleImageEntity();
        villeImageEntity1.setImage("https://encrypted-tbn2.gstatic.com/licensed-image?q=tbn:ANd9GcS6n-2Z0z3oJFyqVEu8EjWv81wENNZ4El_kTVw4874T63vbsUxmnsEpKpv2rSI6neMaZoKxwu7qGqbJ1UAEI3hf4eTYrZmF");
        villeImageEntity1.setVille(ville);

        imageEntities.add(villeImageEntity);
        imageEntities.add(villeImageEntity1);

        ville.setImageEntities(imageEntities);
        return ville;
    }

    public static LogEntity getLogEntity(){
        LogEntity logEntity = new LogEntity();
        logEntity.setDate(new java.sql.Timestamp(new java.util.Date().getTime()));
        logEntity.setKey("key-name-"+Util.generatedLong().toString());
        logEntity.setMessage(" message log today is the best dday of my life");
        logEntity.setLevel("level Name");
        // LogEntity logEntity1 = entityManager.find(LogEntity.class, 1);
//        System.out.println(logEntity.getMessage());
//       List<LogEntity> logEntities = entityManager.createQuery("SELECT l FROM LogEntity l", LogEntity.class).getResultList();
        return logEntity;
    }

    public static Collection<VolExtrasEntity> getVolExtrasEntities() {

        Collection<VolExtrasEntity> volExtrasEntities = new ArrayList<>();
        VolExtrasEntity volExtras = new VolExtrasEntity();
        volExtras.setDescription("Vol Extra 1 Description");
        volExtras.setPrix(100.22);
        volExtras.setType("FOOD TYPE");
        volExtrasEntities.add(volExtras);

        VolExtrasEntity volExtras1 = new VolExtrasEntity();
        volExtras1.setDescription("Vol Extra 2 Description");
        volExtras1.setPrix(200.22);
        volExtras1.setType("ASSURANCE TYPE");
        volExtrasEntities.add(volExtras1);


        return volExtrasEntities;
    }

    public static VolEntity getVolEntity() {

        VolEntity vol = new VolEntity();
        vol.setCode("VOL-"+Util.generateRandomCode());
        vol.setPrix(86.12);
        vol.setVilleDepart("SAFI");
        vol.setVilleArrivee("RABAT");
        vol.setNomberDePlaces(33);
        vol.setDateDepart(new Date());
        vol.setHeureDepart("12:00");
        vol.setDateArrive(new Date());
        vol.setHeureArrivee("14:00");
        vol.setVilleDepart("Casablanca");
        vol.setVilleArrivee("Rabat");

        return vol;



    }
}
