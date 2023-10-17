package ma.yc.airafraik.service;

import ma.yc.airafraik.dto.Account;

import java.io.InputStream;

public interface AccountService {

    public Account checkLoginAccount(String username, String password);

    boolean checkUsernameExists(String username);

    void createAccount(String username, String password, InputStream inputStream);
}
