package es.nextdigital.demo.model;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    public void testAccountCreation() {
        Account account = new Account();
        account.setAccountNumber("ES12345678901234567890");
        account.setBalance(new BigDecimal("1000.00"));

        assertEquals("ES12345678901234567890", account.getAccountNumber());
        assertEquals(new BigDecimal("1000.00"), account.getBalance());
    }
}