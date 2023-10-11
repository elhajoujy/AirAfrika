package ma.yc.airafraik.FunctionalTest.Client;

import jakarta.persistence.EntityManager;
import ma.yc.airafraik.connection.HyperJpa;
import ma.yc.airafraik.entities.ClientEntity;
import ma.yc.airafraik.entities.VolEntity;
import ma.yc.airafraik.entities.VolExtrasEntity;

public class AjouterDesExtrasAvecVol {
    public static void main(String[] args) {

        EntityManager em = HyperJpa.getInstance().getEntityManager();


        try{
            em.getTransaction().begin();

            ClientEntity client = em.find(ClientEntity.class,1);

            VolExtrasEntity volExtras = em.find(VolExtrasEntity.class,1);
            VolEntity vol  = em.find(VolEntity.class,8);



            volExtras.setDescription("extracs vol mehdi lksdjdlksj");
            volExtras.setPrix(100);
            volExtras.setType("type");
            volExtras.setVol(vol);







//            client.getReservationEntities().forEach(reservationEntity -> {
//                reservationEntity.getVolEntities().forEach(volEntity -> {
//                    if(volEntity.getId() == 1){
//
//
//                        volExtras.setVol(volEntity);
//                    }
//                });
//            });



//            em.persist(volExtras);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }
}
