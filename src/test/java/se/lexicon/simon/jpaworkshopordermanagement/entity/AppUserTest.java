package se.lexicon.simon.jpaworkshopordermanagement.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppUserTest {

    AppUser testObject;

    @BeforeEach
    void setUp() {
        testObject = new AppUser("Test", "Testsson", "Test@test.test");

    }

    @Test
    void successfully_created(){

        assertNotNull(testObject);
        assertTrue(testObject.getId() == 0);
        assertEquals("Test", testObject.getFirstName());
        assertEquals("Testsson", testObject.getLastName());
        assertEquals("Test@test.test", testObject.getEmail());


    }

    @Test
    void testEquals() {
        AppUser copy = new AppUser("Test", "Testsson", "Test@test.test");

        assertTrue(testObject.equals(copy));
    }

    @Test
    void testHashcode() {
        AppUser copy = new AppUser("Test", "Testsson", "Test@test.test");

        assertEquals(copy.hashCode(), testObject.hashCode());
    }

    @Test
    void testToString() {
        String toString = testObject.toString();

        assertTrue(toString.contains("0"));
        assertTrue(toString.contains(testObject.getFirstName()));
        assertTrue(toString.contains(testObject.getLastName()));
        assertTrue(toString.contains(testObject.getEmail()));
    }
}