package es.nextdigital.demo.repository;

import es.nextdigital.demo.model.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;

    @Test
    public void testSaveTransaction() {
        Transaction transaction = new Transaction();
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setAmount(new BigDecimal("50.00"));
        transaction.setTransactionType("DEPOSITO");

        Transaction savedTransaction = transactionRepository.save(transaction);
        assertNotNull(savedTransaction.getId());
        assertEquals("DEPOSITO", savedTransaction.getTransactionType());
    }
}
