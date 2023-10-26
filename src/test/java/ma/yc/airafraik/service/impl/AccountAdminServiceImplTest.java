package ma.yc.airafraik.service.impl;

import ma.yc.airafraik.dto.Account;
import ma.yc.airafraik.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountAdminServiceImplTest {

    private AccountService accountAdminService;
    @BeforeEach
    void setUp() {
        this.accountAdminService = new AccountAdminServiceImpl();
    }

    @Test
    void checkLoginAccount() {
        Account account = this.accountAdminService.checkLoginAccount("","");
        assertNull(account);

    }

    @Test
    void checkUsernameExists() {
    }

    @Test
    void createAccount() {
    }
}