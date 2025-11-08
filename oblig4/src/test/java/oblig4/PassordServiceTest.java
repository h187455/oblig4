package oblig4;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PassordServiceTest {

    private PassordService passordService;

    @BeforeEach
    void setup() {
        passordService = new PassordService();
    }

    @Test
    void testGenererTilfeldigSalt() {
        String salt1 = passordService.genererTilfeldigSalt();
        String salt2 = passordService.genererTilfeldigSalt();
        assertNotNull(salt1);
        assertNotNull(salt2);
        assertNotEquals(salt1, salt2, "To saltverdier bør ikke være like");
    }

    @Test
    void testHashMedSaltGir64Tegn() {
        String salt = passordService.genererTilfeldigSalt();
        String hash = passordService.hashMedSalt("hemmelig", salt);
        assertEquals(64, hash.length(), "Hashen skal være 64 tegn lang");
    }

    @Test
    void testErKorrektPassordTrue() {
        String salt = passordService.genererTilfeldigSalt();
        String passord = "MittPassord123";
        String hash = passordService.hashMedSalt(passord, salt);

        assertTrue(passordService.erKorrektPassord(passord, salt, hash),
                "Riktig passord skal gi true");
    }

    @Test
    void testErKorrektPassordFalse() {
        String salt = passordService.genererTilfeldigSalt();
        String passord = "MittPassord123";
        String hash = passordService.hashMedSalt(passord, salt);

        assertFalse(passordService.erKorrektPassord("FeilPassord", salt, hash),
                "Feil passord skal gi false");
    }
}
