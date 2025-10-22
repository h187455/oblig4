package oblig4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Service;



@Service
public class DeltagerService {

	public static List<Deltager> personer = new ArrayList<>();

    public DeltagerService() {
        personer.add(new Deltager("Ola", "Nordmann", "12345678", "passord1", "mann"));
        personer.add(new Deltager("Kari", "Nordmann", "87654321", "passord2", "kvinne"));
    }

    public List<Deltager> hentAlleSortert() {
        return personer.stream()
                       .sorted(Comparator.comparing(Deltager::getFornavn)
                                         .thenComparing(Deltager::getEtternavn))
                       .toList();  
    }


    public boolean finnesMobil(String mobil) {
        return personer.stream().anyMatch(p -> p.getMobilnummer().equals(mobil));
    }

    public boolean leggTil(Deltager p) {
        if (finnesMobil(p.getMobilnummer())) {
            return false;
        }
        personer.add(p);
        return true;
    }
}
