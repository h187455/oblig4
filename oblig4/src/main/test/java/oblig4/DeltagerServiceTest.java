package oblig4;

import static org.junit.jupiter.api.Assertions.*;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DeltagerServiceTest {

    private Validator validator;
    private DeltagerService service;

    @BeforeEach
    void setup() {
        // Kjøres før hver test
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        service = new DeltagerService(); // ny service for hver test
    }

    @Test
    void gyldigDeltager_skalBeståValidering() {
        Deltager d = new Deltager("Ola", "Nordmann", "12345678", "hemmelig1", "mann");
        Set<?> feil = validator.validate(d);
        assertTrue(feil.isEmpty(), "Gyldig deltager skal ikke gi valideringsfeil");
    }

    @Test
    void ugyldigFornavn_skalGiFeil() {
        Deltager d = new Deltager("ola", "Nordmann", "12345678", "hemmelig1", "mann");
        Set<?> feil = validator.validate(d);
        assertFalse(feil.isEmpty(), "Fornavn som ikke starter med stor bokstav skal gi valideringsfeil");
    }

    @Test
    void ugyldigMobilnummer_skalGiFeil() {
        Deltager d = new Deltager("Per", "Persen", "1234", "hemmelig1", "mann");
        Set<?> feil = validator.validate(d);
        assertFalse(feil.isEmpty(), "Mobilnummer med feil antall siffer skal gi valideringsfeil");
    }

    @Test
    void forKortPassord_skalGiFeil() {
        Deltager d = new Deltager("Kari", "Nordmann", "87654321", "kort", "kvinne");
        Set<?> feil = validator.validate(d);
        assertFalse(feil.isEmpty(), "For kort passord skal gi valideringsfeil");
    }

    @Test
    void ugyldigKjonn_skalGiFeil() {
        Deltager d = new Deltager("Per", "Persen", "99998888", "passord123", "annet");
        Set<?> feil = validator.validate(d);
        assertFalse(feil.isEmpty(), "Kjønn som ikke er 'mann' eller 'kvinne' skal gi valideringsfeil");
    }

    @Test
    void programmatiskValidering_iService_skalHindreDuplikatMobil() {
        Deltager ny = new Deltager("Ola", "Nordmann", "12345678", "passord123", "mann");
        boolean lagtTil = service.leggTil(ny);

        assertFalse(lagtTil, "Service skal ikke tillate to deltakere med samme mobilnummer");
    }
}
