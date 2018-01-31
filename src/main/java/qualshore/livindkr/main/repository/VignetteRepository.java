package qualshore.livindkr.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import qualshore.livindkr.main.entities.Institution;
import qualshore.livindkr.main.entities.Vignette;

public interface VignetteRepository extends JpaRepository<Vignette, Integer>{
	
	@Query("SELECT vig FROM Vignette vig WHERE vig.idInstitution = ?1")
	public List<Vignette> findVignetteByInstitution(Institution idInstitution);

}
