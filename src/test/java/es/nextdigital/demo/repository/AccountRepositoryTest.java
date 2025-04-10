package es.nextdigital.demo.repository;

import es.nextdigital.demo.model.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void testSaveAccount() {
        Account account = new Account();
        account.setAccountNumber("ES12345678901234567890");
        account.setBalance(new BigDecimal("1000.00"));

        Account savedAccount = accountRepository.save(account);
        assertNotNull(savedAccount.getId());
        assertEquals("ES12345678901234567890", savedAccount.getAccountNumber());
    }
}
