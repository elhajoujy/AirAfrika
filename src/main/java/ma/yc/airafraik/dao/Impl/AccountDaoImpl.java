package ma.yc.airafraik.dao.Impl;

import jakarta.persistence.EntityManager;
import ma.yc.airafraik.connection.HyperJpa;
import ma.yc.airafraik.core.Util;
import ma.yc.airafraik.dao.AccountDao;
import ma.yc.airafraik.dto.Account;
import ma.yc.airafraik.entities.AdministrateurEntity;

public class AccountDaoImpl implements AccountDao {


    private EntityManager em = HyperJpa.getInstance().getEntityManager();

    @Override
    public Account checkLoginAccount(String username, String password) {
        Account account = new Account();
        AdministrateurEntity administrateurEntity = em.createQuery("SELECT a FROM AdministrateurEntity a WHERE a.email = :email ", AdministrateurEntity.class)
                .setParameter("email", username)
                .getSingleResult();
        if (administrateurEntity != null) {
            if (administrateurEntity.getPassword().equals(password)) {
                account.setUsername(administrateurEntity.getEmail());
                account.setPassword(administrateurEntity.getPassword());
                return account;
            } else {
                return null;
            }
        }

        return null;

    }

}
