package es.nextdigital.demo.service;

import es.nextdigital.demo.model.Account;
import es.nextdigital.demo.model.Transaction;
import es.nextdigital.demo.repository.AccountRepository;
import es.nextdigital.demo.repository.TransactionRepository;
import es.nextdigital.demo.service.Interface.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    // Search account transactions
    public List<Transaction> getAccountTransactions(Long accountId) {
        return transactionRepository.findByAccountId(accountId);
    }

    public BigDecimal getAccountBalance(Long accountId) throws Exception {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new Exception("Cuenta no encontrada"));
        return account.getBalance();
    }

    // Create withdrawal transaction
    public void withdraw(Long accountId, BigDecimal amount) throws Exception {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new Exception("Account not found"));
        if (account.getBalance().compareTo(amount) < 0) {
            throw new Exception("Insufficient Balance");
        }
        account.setBalance(account.getBalance().subtract(amount));
        accountRepository.save(account);
    }

    // Create deposit transaction
    public void deposit(Long accountId, BigDecimal amount) throws Exception {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new Exception("Account not found"));
        account.setBalance(account.getBalance().add(amount));
        accountRepository.save(account);
    }

    // Create transfer transactions
    public void transfer(Long fromAccountId, Long toAccountId, BigDecimal amount) throws Exception {
        Account fromAccount = accountRepository.findById(fromAccountId).orElseThrow(() -> new Exception("Source account not found"));
        Account toAccount = accountRepository.findById(toAccountId).orElseThrow(() -> new Exception("Destination account not found"));
        if (fromAccount.getBalance().compareTo(amount) < 0) {
            throw new Exception("Insufficient balance");
        }
        fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
        toAccount.setBalance(toAccount.getBalance().add(amount));
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

    }


}
