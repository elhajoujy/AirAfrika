package ma.yc.airafraik.Helper;

import ma.yc.airafraik.core.Util;
import ma.yc.airafraik.entities.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

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
}
