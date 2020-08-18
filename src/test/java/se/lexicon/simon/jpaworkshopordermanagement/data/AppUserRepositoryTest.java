package se.lexicon.simon.jpaworkshopordermanagement.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.simon.jpaworkshopordermanagement.entity.AppUser;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AppUserRepositoryTest {

    AppUser testObject;

    @Autowired
    AppUserRepository appUserRepository;

    @BeforeEach
    void setUp() {
        testObject = appUserRepository.save(new AppUser("Test", "Testsson", "test@test.se"));

        appUserRepository.save(new AppUser("Erik", "Svensson", "erik@svensson.se"));
    }

    @Test
    void SuccessfullyCreated() {
        List<AppUser> foundAppUsers = appUserRepository.findAll();

        assertFalse(foundAppUsers.isEmpty());
        assertEquals(2, foundAppUsers.size());
        assertTrue(foundAppUsers.contains(testObject));
    }

    @Test
    void Successfully_findByEmailIgnoreCase() {
        // Arrange
        String email = "TeSt@TeSt.sE";
        AppUser expected = testObject;

        // Act
        Optional<AppUser> found = appUserRepository.findByEmailIgnoreCase(email);

        //Assert
        assertTrue(found.isPresent());
        assertEquals(Optional.of(expected),found);
    }

    @Test
    void UnSuccessfully_findByEmailIgnoreCase() {
        // Arrange
        String email = "TeSt@TeSt";

        // Act
        Optional<AppUser> found = appUserRepository.findByEmailIgnoreCase(email);

        //Assert
        assertFalse(found.isPresent());
        assertEquals(Optional.empty(), found);
    }
}