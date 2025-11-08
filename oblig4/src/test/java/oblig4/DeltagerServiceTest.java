package oblig4;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class DeltagerServiceTest {

    @Mock
    private DeltagerRepository deltagerRepository;

    @InjectMocks
    private DeltagerService deltagerService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFinnAlleDeltagereSortert() {
        Deltager d1 = new Deltager("Kari", "Nordmann", "12345678", "hash", "salt", "kvinne");
        Deltager d2 = new Deltager("Ola", "Nordmann", "87654321", "hash", "salt", "mann");

        when(deltagerRepository.findAll()).thenReturn(Arrays.asList(d2, d1));

        List<Deltagerskjema> resultat = deltagerService.finnAlleDeltagereSortert();

        assertEquals(2, resultat.size());
        assertEquals("Kari", resultat.get(0).getFornavn(), "Kari skal komme før Ola alfabetisk");
    }

    @Test
    void testFinnDeltagerViaMobilnummer() {
        Deltager deltager = new Deltager("Lars", "Johansen", "34567890", "hash", "salt", "mann");
        when(deltagerRepository.findByMobilnummer("34567890")).thenReturn(Optional.of(deltager));

        Optional<Deltager> funnet = deltagerService.finnDeltagerViaMobilnummer("34567890");

        assertTrue(funnet.isPresent(), "Deltageren skal finnes");
        assertEquals("Lars", funnet.get().getFornavn());
    }
}