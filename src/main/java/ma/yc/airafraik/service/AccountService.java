package ma.yc.airafraik.service;

import ma.yc.airafraik.dto.Account;

public interface AccountService {

    public Account checkLoginAccount(String username, String password);
    
}
