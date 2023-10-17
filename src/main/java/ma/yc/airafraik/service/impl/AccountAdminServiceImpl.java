package ma.yc.airafraik.service.impl;

import ma.yc.airafraik.dto.Account;
import ma.yc.airafraik.service.AccountService;

import java.io.InputStream;

public class AccountAdminServiceImpl implements AccountService {
    @Override
    public Account checkLoginAccount(String username, String password) {
        return null;
    }

    @Override
    public boolean checkUsernameExists(String username) {
        return false;
    }

    @Override
    public void createAccount(String username, String password, InputStream inputStream) {

    }
}
