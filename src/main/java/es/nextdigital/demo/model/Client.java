package es.nextdigital.demo.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String dni; // Identificador univoco

    @OneToMany(mappedBy = "client")
    private List<Account> accounts;

    @OneToMany(mappedBy = "client")
    private List<Card> cards;

}