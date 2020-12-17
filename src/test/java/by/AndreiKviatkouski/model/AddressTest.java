package by.AndreiKviatkouski.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {


    @Test
    void testGettersSetter(){
        Address adr= new Address();

        adr.setId(1L);
        adr.setCity("Minsk");
        adr.setFlat(494);
        adr.setStreet("Lenina");

        assertEquals(1l, adr.getId());
        assertEquals("Minsk",adr.getCity() );



    }
}