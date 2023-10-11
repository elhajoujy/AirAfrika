package ma.yc.airafraik.FunctionalTest.Client;

import jakarta.persistence.EntityManager;
import ma.yc.airafraik.Helper.FakeEntitesHelper;
import ma.yc.airafraik.connection.HyperJpa;
import ma.yc.airafraik.core.Print;
import ma.yc.airafraik.dao.ClientDao;
import ma.yc.airafraik.dao.Impl.ClientDaoImpl;
import ma.yc.airafraik.entities.*;
import ma.yc.airafraik.enums.ReservationStatus;

import java.util.ArrayList;
import java.util.HashMap;

public class MainReservation {


        public static void main(String[] args) {
            ClientDao clientDao = new ClientDaoImpl();

//            HashMap<String , String> conditions = new HashMap<>();
//            conditions.put("id","1");
//            ArrayList<ClientEntity> clientEntities  = clientDao.consulterClients(conditions);
//
//            clientEntities.forEach(client -> {
//               client.getReservationEntities().forEach(reservationEntity -> {
//                   Print.log("client avec Reservation =>" + reservationEntity.getCode());
//                   Print.log("Vol =>" + reservationEntity.getVolEntities().toString());
//               });
//            });
//
//            System.out.println("Hello World!");


            confirmationReservation();
        }

        public static void confirmationReservation(){
            //todo : client remplir les infrmations de base nom prenom email telephone  ;
            HyperJpa jpa = HyperJpa.getInstance();
            EntityManager em = jpa.getEntityManager();

            try{

                jpa.beginTransaction();

                ClientEntity client = em.find(ClientEntity.class, 1);
                ReservationEntity reservationEntity = em.find(ReservationEntity.class, 89);


                reservationEntity.setClient(client);



                VolEntity vol = em.find(VolEntity.class, 8);



//                VolExtrasEntity volExtras = new VolExtrasEntity();
//                volExtras.setType("REPASS");
//                volExtras.setDescription("REPASS you will like it");
//                volExtras.setPrix(100);
//                volExtras.setVol(vol);
//                vol.getVolExtrasEntities().add(volExtras);
//                Print.log(vol.toString());
//                reservationEntity.getVolEntities().add(vol);

//                vol.getReservationEntities().add(reservationEntity);

                vol.getReservationEntities().forEach(reservationEntity1 -> {
                    Print.log(reservationEntity1.getCode());
                });



                  //TODO : SEARCH FOR POSSIBLE VOLS IN THIS DATE
                //ArrayList<VolEntity> volEntities = FakeEntitesHelper.VolsPossibleParVilleDepartEtVilleArrivee("SAFI" , "RABAT");
//                ADD EXTRACTS FOR EACH VOL
//                volEntities.forEach(volEntity -> {
//                    volEntity.getReservationEntities().add(reservationEntity);
//                    volEntity.getVolExtrasEntities().addAll(FakeEntitesHelper.getVolExtrasEntities());
//                });

//                Print.log(reservationEntity.getVolEntities());
//                if (reservationEntity.getVolEntities() != null ){
//
//                    reservationEntity.getVolEntities().add(vol);
//                }else{
//                    reservationEntity.setVolEntities(new ArrayList<>());
//                    reservationEntity.getVolEntities().add(vol);
//                }
//
//                client.getReservationEntities().add(reservationEntity);



                //TODO : et le processus de paiement
                PaymentEntity paymentEntity = new PaymentEntity();

                //
                //TODO : CONFIRMATION
                if (false){
                    reservationEntity.setStatus(ReservationStatus.CONFIRMED);

                }








                jpa.commitTransaction();
            }catch (Exception e){
                jpa.rollbackTransaction();
                Print.log(e.getMessage());

            }finally {
                jpa.close();
            }




        }
}
