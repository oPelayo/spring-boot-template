package es.nextdigital.demo.model;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    @Test
    public void testCardCreation() {
        Card card = new Card();
        card.setCardNumber("1234567890123456");
        card.setPin("1234"); // Recuerda, esto se encriptará en la realidad
        card.setCreditLimit(new BigDecimal("1000.00"));
        card.setActivated(true);
        card.setCreditCard(false);

        assertEquals("1234567890123456", card.getCardNumber());
        assertEquals("1234", card.getPin());
        assertEquals(new BigDecimal("1000.00"), card.getCreditLimit());
        assertTrue(card.isActivated());
        assertFalse(card.isCreditCard());
    }
}
