package es.nextdigital.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    private String cardNumber;
    private String pin; // ¡Importante! Encriptar antes de guardar en la bbdd
    private BigDecimal creditLimit;
    private boolean activated;
    private boolean creditCard;

}