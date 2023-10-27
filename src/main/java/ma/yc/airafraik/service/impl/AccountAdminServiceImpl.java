package ma.yc.airafraik.service.impl;

import ma.yc.airafraik.dao.AccountDao;
import ma.yc.airafraik.dao.Impl.AccountDaoImpl;
import ma.yc.airafraik.dto.Account;
import ma.yc.airafraik.service.AccountService;

import java.io.InputStream;

public class AccountAdminServiceImpl implements AccountService {

    private AccountDao accountDao;

    public AccountAdminServiceImpl() {
        this.accountDao = new AccountDaoImpl();
    }

    @Override
    public Account checkLoginAccount(String username, String password) {
        if (username.isBlank() || password.isBlank()){
            return null;
        }
        Account account = this.accountDao.checkLoginAccount(username,password);

        if (account == null){
            return null;
        }else {
            return account;
        }
    }

    @Override
    public boolean checkUsernameExists(String username) {
        return false;
    }

    @Override
    public void createAccount(String username, String password, InputStream inputStream) {

    }
}
