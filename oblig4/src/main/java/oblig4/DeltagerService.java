package oblig4;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeltagerService {
	
	@Autowired
	private DeltagerRepository deltagerRepository; 

	public  List<Deltagerskjema> finnAlleDeltagereSortert() {
		List<Deltager> deltagere = deltagerRepository.findAll(); 
		
		return deltagere.stream()
				.map(this::konverterTilDeltagerskjema)
				.sorted(Comparator.comparing(Deltagerskjema::getFornavn)
								  .thenComparing(Deltagerskjema::getEtternavn))
				.collect(Collectors.toList()); 
		
	}

    private Deltagerskjema konverterTilDeltagerskjema(Deltager deltager) {
    	return new Deltagerskjema(
    			deltager.getFornavn(),
    			deltager.getEtternavn(),
    			deltager.getMobilnummer(),
    			deltager.getKjonn()
    			); 
 
    	}
    
    public Optional<Deltager> finnDeltagerViaMobilnummer(String mobilnummer){
        return deltagerRepository.findByMobilnummer(mobilnummer); 
    	
    }


	}

