package es.nextdigital.demo.service;

import es.nextdigital.demo.model.Transaction;
import es.nextdigital.demo.repository.AccountRepository;
import es.nextdigital.demo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    // Métodos para crear transacciones (depósito, retiro, transferencia, comisión)
    public Transaction createDepositTransaction(Long accountId, BigDecimal amount) throws Exception {
        Transaction transaction = new Transaction();
        transaction.setAccount(accountRepository.findById(accountId).orElseThrow(() -> new Exception("Account not found")));
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setAmount(amount);
        transaction.setTransactionType("DEPOSITO");
        transaction.setDescription("Depósito en efectivo");
        return transactionRepository.save(transaction);
    }

    public Transaction createWithdrawalTransaction(Long accountId, BigDecimal amount) throws Exception {
        Transaction transaction = new Transaction();
        transaction.setAccount(accountRepository.findById(accountId).orElseThrow(() -> new Exception("Account not found")));
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setAmount(amount.negate());
        transaction.setTransactionType("RETIRO");
        transaction.setDescription("Retiro en efectivo");
        return transactionRepository.save(transaction);
    }



    public Transaction createTransferTransaction(Long fromAccountId, Long toAccountId, BigDecimal amount) throws Exception {
        Transaction transaction = new Transaction();
        transaction.setAccount(accountRepository.findById(fromAccountId).orElseThrow(() -> new Exception("Account not found")));
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setAmount(amount.negate());
        transaction.setTransactionType("TRANSFERENCIA");
        transaction.setDescription("Transferencia saliente a cuenta " + toAccountId);
        return transactionRepository.save(transaction);
    }

    public Transaction createCommissionTransaction(Long accountId, BigDecimal amount) throws Exception {
        Transaction transaction = new Transaction();
        transaction.setAccount(accountRepository.findById(accountId).orElseThrow(() -> new Exception("Account not found")));
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setAmount(amount);
        transaction.setTransactionType("COMISION");
        transaction.setDescription("Comisión por servicio");
        return transactionRepository.save(transaction);
    }
}