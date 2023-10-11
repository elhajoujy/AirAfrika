package ma.yc.airafraik.FunctionalTest.Client;

import ma.yc.airafraik.core.Print;
import ma.yc.airafraik.dao.ClientDao;
import ma.yc.airafraik.dao.Impl.ClientDaoImpl;
import ma.yc.airafraik.entities.ClientEntity;

import java.util.ArrayList;
import java.util.HashMap;

public class MainReservation {


        public static void main(String[] args) {
            ClientDao clientDao = new ClientDaoImpl();

            HashMap<String , String> conditions = new HashMap<>();
            conditions.put("id","1");
            ArrayList<ClientEntity> clientEntities  = clientDao.consulterClients(conditions);

            clientEntities.forEach(client -> {
               client.getReservationEntities().forEach(reservationEntity -> {
                   Print.log("client avec Reservation =>" + reservationEntity.getCode());
                   Print.log("Vol =>" + reservationEntity.getVolEntities().toString());
               });
            });

            System.out.println("Hello World!");
        }
}
