package es.nextdigital.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    private LocalDateTime transactionDate;
    private BigDecimal amount;
    private String transactionType; // "DEPOSITO", "RETIRO", "TRANSFERENCIA", "COMISION"
    private String description;

}
