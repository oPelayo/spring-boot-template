package es.nextdigital.demo.service;

import es.nextdigital.demo.model.Card;
import es.nextdigital.demo.repository.CardRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CardServiceTest {

    @Mock
    private CardRepository cardRepository;

    @InjectMocks
    private CardService cardService;

    @Test
    public void testActivateCard() throws Exception {
        Card card = new Card();
        when(cardRepository.findByCardNumber("1234567890123456")).thenReturn(card);

        cardService.activateCard("1234567890123456", "1234");

        assertTrue(card.isActivated());
        assertEquals("1234", card.getPin());
        verify(cardRepository, times(1)).save(card);
    }
}
