package es.nextdigital.demo.service;

import es.nextdigital.demo.model.Card;
import es.nextdigital.demo.repository.CardRepository;
import es.nextdigital.demo.service.Interface.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private IAccountService accountService;

    public void activateCard(String cardNumber, String pin) throws Exception {
        Card card = cardRepository.findByCardNumber(cardNumber);
        if (card == null) {
            throw new Exception("Card not found");
        }
        if (card.isActivated()) {
            throw new Exception("The card is already activated");
        }
        card.setPin(pin); // Encrypt the PIN!
        card.setActivated(true);
        cardRepository.save(card);
    }

    public void changePin(String cardNumber, String newPin) throws Exception {
        Card card = cardRepository.findByCardNumber(cardNumber);
        if (card == null) {
            throw new Exception("Card not found");
        }
        card.setPin(newPin); // Encrypt the PIN!
        cardRepository.save(card);
    }

    public void validateCardWithdrawal(Card card, BigDecimal amount, boolean isSameBank) throws Exception {
        if (!card.isActivated()) {
            throw new Exception("La tarjeta no está activada");
        }

        BigDecimal availableCredit = card.getCreditLimit();
        BigDecimal accountBalance = accountService.getAccountBalance(card.getAccount().getId());

        if (card.isCreditCard()) {
            if (availableCredit.compareTo(amount) < 0) {
                throw new Exception("Límite de crédito excedido");
            }
        } else {
            if (accountBalance.compareTo(amount) < 0) {
                throw new Exception("Saldo insuficiente");
            }
        }

        if (!isSameBank) {
            BigDecimal commission = amount.multiply(new BigDecimal("0.05")); // 5% de comisión
            if (card.isCreditCard()) {
                if (availableCredit.compareTo(amount.add(commission)) < 0) {
                    throw new Exception("Límite de crédito excedido incluyendo comisión");
                }
            } else {
                if (accountBalance.compareTo(amount.add(commission)) < 0) {
                    throw new Exception("Saldo insuficiente incluyendo comisión");
                }
            }
        }
    }

}