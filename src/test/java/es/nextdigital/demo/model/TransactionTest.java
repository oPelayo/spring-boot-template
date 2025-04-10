package es.nextdigital.demo.model;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {

    @Test
    public void testTransactionCreation() {
        Transaction transaction = new Transaction();
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setAmount(new BigDecimal("50.00"));
        transaction.setTransactionType("DEPOSITO");
        transaction.setDescription("Depósito en efectivo");

        assertNotNull(transaction.getTransactionDate());
        assertEquals(new BigDecimal("50.00"), transaction.getAmount());
        assertEquals("DEPOSITO", transaction.getTransactionType());
        assertEquals("Depósito en efectivo", transaction.getDescription());
    }
}