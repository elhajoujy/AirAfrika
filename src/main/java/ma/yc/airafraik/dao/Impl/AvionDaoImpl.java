package ma.yc.airafraik.dao.Impl;

import ma.yc.airafraik.connection.HyperJpa;
import ma.yc.airafraik.dao.AvionDao;
import ma.yc.airafraik.entities.AvionEntity;

import java.util.Collection;

public class AvionDaoImpl implements AvionDao {
    HyperJpa hyperJpa ;

    public AvionDaoImpl() {
        this.hyperJpa = HyperJpa.getInstance();
    }

    @Override
    public boolean ajouterAvion(AvionEntity avion) {
        return false;
    }

    @Override
    public boolean supprimerAvion(String id) {
        return false;
    }

    @Override
    public boolean modifierAvion(AvionEntity avion) {
        return false;
    }

    @Override
    public AvionEntity consulterAvion(String id) {
        Integer idInt = Integer.parseInt(id);
        try{
            this.hyperJpa.beginTransaction();
            AvionEntity avionEntity = this.hyperJpa.getEntityManager().
                    createQuery("select a from AvionEntity a where a.id = :id", AvionEntity.class).
                    setParameter("id", idInt).getSingleResult();

            this.hyperJpa.commitTransaction();
            return avionEntity;
        }catch (Exception e){
            e.printStackTrace();
            this.hyperJpa.rollbackTransaction();
        }
        return null;
    }

    @Override
    public Collection<AvionEntity> consulterAvions() {
        try{
            this.hyperJpa.beginTransaction();
            Collection<AvionEntity> avionEntities = this.hyperJpa.getEntityManager().
                    createQuery("select a from AvionEntity a", AvionEntity.class).getResultList();

            this.hyperJpa.commitTransaction();
            return avionEntities;

        }catch (Exception e){
            e.printStackTrace();
            this.hyperJpa.rollbackTransaction();
        }
        finally {
//            this.hyperJpa.close();
        }
        return null;
    }
}
