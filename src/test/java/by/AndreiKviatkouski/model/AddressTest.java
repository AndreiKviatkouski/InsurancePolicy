package by.AndreiKviatkouski.model;

import by.AndreiKviatkouski.service.ClientServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

//    @Mock
//    ClientServiceImpl clientService;

    @Test
    void testGettersSetter(){
        Address adr= new Address();

        adr.setId(1L);
        adr.setCity("Minsk");
        adr.setFlat(494);
        adr.setStreet("Lenina");

        assertEquals(1l, adr.getId());
        assertEquals("Minsk",adr.getCity() );

//        clientService.deleteById(10);

    }
}