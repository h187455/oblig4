package oblig4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValidatorServiceTest {

    private ValidatorService validator;

    @BeforeEach
    void setup() {
        validator = new ValidatorService();
    }

    @Test
    void testGyldigPassord() {
        assertTrue(validator.isValidPassord("Abcdef12"), "Gyldig passord skal gi true");
    }

    @Test
    void testUgyldigPassord() {
        assertFalse(validator.isValidPassord("abc"), "For kort passord skal gi false");
    }

    @Test
    void testGyldigMobilnummer() {
        assertTrue(validator.isValidmoblinummer("12345678"), "Gyldig mobilnummer skal gi true");
    }

    @Test
    void testUgyldigMobilnummer() {
        assertFalse(validator.isValidmoblinummer("1234"), "Ugyldig mobilnummer skal gi false");
    }

    @Test
    void testPassordMatch() {
        assertTrue(validator.passordMatch("Abc12345", "Abc12345"), "Like passord skal gi true");
        assertFalse(validator.passordMatch("Abc12345", "Def67890"), "Ulike passord skal gi false");
    }
}