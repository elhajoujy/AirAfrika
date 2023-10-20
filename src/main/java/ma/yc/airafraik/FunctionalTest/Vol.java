package ma.yc.airafraik.FunctionalTest;

import ma.yc.airafraik.dao.Impl.VolDaoImpl;
import ma.yc.airafraik.entities.VolEntity;

import java.util.Collection;

public class Vol {
    public static void main(String[] args) {

        Collection<VolEntity> vols = new VolDaoImpl().consulterVols();
        vols.forEach(volEntity -> {
            System.out.println(volEntity.getVol().getId());
        });


    }
}
