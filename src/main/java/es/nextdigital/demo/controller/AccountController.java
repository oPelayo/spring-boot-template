package es.nextdigital.demo.controller;

import es.nextdigital.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping("/{accountId}/transactions")
    public ResponseEntity<?> getAccountTransactions(@PathVariable Long accountId) {
        return ResponseEntity.ok(accountService.getAccountTransactions(accountId));
    }

    @PostMapping("/{accountId}/withdraw")
    public ResponseEntity<?> withdraw(@PathVariable Long accountId, @RequestBody BigDecimal amount) {
        try {
            accountService.withdraw(accountId, amount);
            return ResponseEntity.ok("Retiro realizado con éxito");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/{accountId}/deposit")
    public ResponseEntity<?> deposit(@PathVariable Long accountId, @RequestBody BigDecimal amount) {
        try {
            accountService.deposit(accountId, amount);
            return ResponseEntity.ok("Depósito realizado con éxito");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/{fromAccountId}/transfer/{toAccountId}")
    public ResponseEntity<?> transfer(@PathVariable Long fromAccountId, @PathVariable Long toAccountId, @RequestBody BigDecimal amount) {
        try {
            accountService.transfer(fromAccountId, toAccountId, amount);
            return ResponseEntity.ok("Transferencia realizada con éxito");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}