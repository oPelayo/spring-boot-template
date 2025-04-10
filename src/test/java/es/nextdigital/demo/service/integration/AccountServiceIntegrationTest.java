package es.nextdigital.demo.service.integration;

import es.nextdigital.demo.model.Account;
import es.nextdigital.demo.repository.AccountRepository;
import es.nextdigital.demo.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AccountServiceIntegrationTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void testWithdrawIntegration() throws Exception {
        Account account = new Account();
        account.setBalance(new BigDecimal("100.00"));
        account = accountRepository.save(account);

        accountService.withdraw(account.getId(), new BigDecimal("50.00"));

        Account updatedAccount = accountRepository.findById(account.getId()).orElse(null);
        assertNotNull(updatedAccount);
        assertEquals(new BigDecimal("50.00"), updatedAccount.getBalance());
    }
}
