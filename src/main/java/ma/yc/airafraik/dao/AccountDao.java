package ma.yc.airafraik.dao;

import ma.yc.airafraik.dto.Account;

public interface AccountDao {

    public Account checkLoginAccount(String username, String password);

}
