package es.nextdigital.demo.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {

    @Test
    public void testClientCreation() {
        Client client = new Client();
        client.setName("John");
        client.setSurname("Doe");
        client.setDni("12345678A");

        assertEquals("John", client.getName());
        assertEquals("Doe", client.getSurname());
        assertEquals("12345678A", client.getDni());
    }
}