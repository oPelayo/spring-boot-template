package es.nextdigital.demo.repository;

import es.nextdigital.demo.model.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void testSaveClient() {
        Client client = new Client();
        client.setName("John");
        client.setSurname("Doe");
        client.setDni("12345678A");

        Client savedClient = clientRepository.save(client);
        assertNotNull(savedClient.getId());
        assertEquals("John", savedClient.getName());
    }
}