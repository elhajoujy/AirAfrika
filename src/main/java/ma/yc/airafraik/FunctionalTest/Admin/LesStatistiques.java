package ma.yc.airafraik.FunctionalTest.Admin;

import ma.yc.airafraik.core.Print;
import ma.yc.airafraik.dao.Impl.ReservationDaoImpl;
import ma.yc.airafraik.dao.ReservationDao;
import ma.yc.airafraik.entities.ReservationEntity;
import ma.yc.airafraik.enums.ReservationStatus;
import org.glassfish.jaxb.core.v2.TODO;

import java.util.ArrayList;
import java.util.HashMap;

public class LesStatistiques {



    public static void main(String[] args) {
        Print.log("Show the statistics here");

        //SHOW THE STATISTICS HERE
        ReservationDao reservationDao = new ReservationDaoImpl();

        HashMap<String, String> conditions = new HashMap<>();


        //TODO : THE CLIENT WIL CHOOSE TWO DATE CALLED DATE_1 AND DATE_2 FROM THE CALENDER
        conditions.put("date_1", "2020-01-01");
        conditions.put("date_2", "2023-12-31");

        ArrayList<ReservationEntity> reservationEntities =
                reservationDao.AfficheLesStatistiques(conditions, ReservationStatus.EN_ATTENTE);
        Print.log(reservationEntities.size());


    }






}
