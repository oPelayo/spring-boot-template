package es.nextdigital.demo.controller;

import es.nextdigital.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/{accountId}/deposit")
    public ResponseEntity<?> createDepositTransaction(@PathVariable Long accountId, @RequestBody BigDecimal amount) throws Exception {
        return ResponseEntity.ok(transactionService.createDepositTransaction(accountId, amount));
    }

    @PostMapping("/{accountId}/withdraw")
    public ResponseEntity<?> createWithdrawalTransaction(@PathVariable Long accountId, @RequestBody BigDecimal amount) throws Exception {
        return ResponseEntity.ok(transactionService.createWithdrawalTransaction(accountId, amount));
    }

    @PostMapping("/{fromAccountId}/transfer/{toAccountId}")
    public ResponseEntity<?> createTransferTransaction(@PathVariable Long fromAccountId, @PathVariable Long toAccountId, @RequestBody BigDecimal amount) throws Exception {
        return ResponseEntity.ok(transactionService.createTransferTransaction(fromAccountId, toAccountId, amount));
    }

    @PostMapping("/{accountId}/commission")
    public ResponseEntity<?> createCommissionTransaction(@PathVariable Long accountId, @RequestBody BigDecimal amount) throws Exception {
        return ResponseEntity.ok(transactionService.createCommissionTransaction(accountId, amount));
    }

}
