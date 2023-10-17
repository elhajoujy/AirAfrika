package ma.yc.airafraik.service.impl;

import ma.yc.airafraik.dao.ClientDao;
import ma.yc.airafraik.dao.Impl.ClientDaoImpl;
import ma.yc.airafraik.dto.Account;
import ma.yc.airafraik.entities.ClientEntity;
import ma.yc.airafraik.service.AccountService;

public class AccountClientServiceImpl implements AccountService {

    Account account = new Account();
    ClientEntity clientEntity = new ClientEntity();
    ClientDao  clientDao = new ClientDaoImpl();



    @Override
    public Account checkLoginAccount(String username, String password) {

        return null;
    }
}
