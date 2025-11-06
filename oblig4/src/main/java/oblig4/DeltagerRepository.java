package oblig4;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeltagerRepository extends JpaRepository<Deltager, String>{
	boolean existsByMobilnummer(String mobilnummer);
	
	Optional<Deltager> findByMobilnummer(String mobilnummer);
	
}

