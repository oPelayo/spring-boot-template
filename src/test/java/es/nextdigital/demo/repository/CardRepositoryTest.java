package es.nextdigital.demo.repository;

import es.nextdigital.demo.model.Card;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CardRepositoryTest {

    @Autowired
    private CardRepository cardRepository;

    @Test
    public void testFindByCardNumber() {
        Card card = new Card();
        card.setCardNumber("1234567890123456");
        cardRepository.save(card);

        Card foundCard = cardRepository.findByCardNumber("1234567890123456");
        assertNotNull(foundCard);
        assertEquals("1234567890123456", foundCard.getCardNumber());
    }
}