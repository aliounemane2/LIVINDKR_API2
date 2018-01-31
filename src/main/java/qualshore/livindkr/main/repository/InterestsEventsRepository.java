package qualshore.livindkr.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import qualshore.livindkr.main.entities.InterestsEvents;

public interface InterestsEventsRepository extends JpaRepository<InterestsEvents, Integer>{
	
	@Query("SELECT ie FROM InterestsEvents ie, Event ev , Interest i WHERE ie.idEvent = ev.idEvent AND ie.idInterest = i.idInterest ")
	public List<InterestsEvents> findEventsss();
	
	


}
