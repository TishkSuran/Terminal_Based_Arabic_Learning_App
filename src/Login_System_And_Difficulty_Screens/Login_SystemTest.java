package Login_System_And_Difficulty_Screens;

import org.junit.jupiter.api.*;
import java.io.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class Login_SystemTest {
    Login_System ValidationUtils = new Login_System();

    @Test
    public void testValidFirstName() {
        assertTrue(ValidationUtils.isValidFirstName("Ibn"));
        assertTrue(ValidationUtils.isValidFirstName("Al"));
        assertFalse(ValidationUtils.isValidFirstName("123"));
        assertFalse(ValidationUtils.isValidFirstName("Ibn Sina"));
    }

    @Test
    public void testValidSecondName() {
        assertTrue(ValidationUtils.isValidSecondName("Sina"));
        assertTrue(ValidationUtils.isValidSecondName("Ghazali"));
        assertFalse(ValidationUtils.isValidSecondName("123"));
        assertTrue(ValidationUtils.isValidSecondName("Ibn"));
    }

    @Test
    public void testValidPassword() {
        assertTrue(ValidationUtils.isValidPassword("Password1"));
        assertTrue(ValidationUtils.isValidPassword("SecurePass123"));
        assertFalse(ValidationUtils.isValidPassword("short"));
        assertFalse(ValidationUtils.isValidPassword("nocapitalletter"));
        assertFalse(ValidationUtils.isValidPassword("noNumberPassword"));
    }

    @Test
    public void testValidEmail() {
        assertTrue(ValidationUtils.isValidEmail(generateRandomEmail()));
        assertTrue(ValidationUtils.isValidEmail(generateRandomEmail()));
        assertFalse(ValidationUtils.isValidEmail("invalid-email.com"));
        assertFalse(ValidationUtils.isValidEmail("user@.com"));
        assertFalse(ValidationUtils.isValidEmail("user123@gmail"));
    }

    @Test
    public void testIsEmailAlreadyRegistered() throws IOException {
        assertFalse(ValidationUtils.isEmailAlreadyRegistered(generateRandomEmail()));
        assertTrue(ValidationUtils.isEmailAlreadyRegistered("alreadyregistered@example.com"));
    }

    @Test
    public void testIsUsernameAlreadyRegistered() throws IOException {
        assertFalse(ValidationUtils.isUsernameAlreadyRegistered("newUser"));
        assertTrue(ValidationUtils.isUsernameAlreadyRegistered("existingUser"));
    }

    private String generateRandomEmail() {
        String[] domains = {"example.com", "test.com", "gmail.com", "yahoo.com"};
        String[] usernames = {"ibnsina", "alghazali", "avempace", "ibnalhaytham"};
        String domain = domains[(int) (Math.random() * domains.length)];
        String username = usernames[(int) (Math.random() * usernames.length)];
        return username + "@" + domain;
    }
}
