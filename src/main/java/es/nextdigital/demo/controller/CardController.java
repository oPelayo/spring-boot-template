package es.nextdigital.demo.controller;

import es.nextdigital.demo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cards")
public class CardController {

    private final CardService cardService;

    @Autowired
    private CardController(CardService cardservice){
        this.cardService = cardservice;
    }


    @PostMapping("/{cardNumber}/activate")
    public ResponseEntity<?> activateCard(@PathVariable String cardNumber, @RequestBody String pin) {
        try {
            cardService.activateCard(cardNumber, pin);
            return ResponseEntity.ok("Tarjeta activada con éxito");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/{cardNumber}/change-pin")
    public ResponseEntity<?> changePin(@PathVariable String cardNumber, @RequestBody String newPin) {
        try {
            cardService.changePin(cardNumber, newPin);
            return ResponseEntity.ok("PIN cambiado con éxito");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
