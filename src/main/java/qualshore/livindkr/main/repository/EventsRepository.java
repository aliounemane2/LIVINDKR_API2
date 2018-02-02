package qualshore.livindkr.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import qualshore.livindkr.main.entities.Event;
import qualshore.livindkr.main.entities.Institution;
import qualshore.livindkr.main.entities.User;

public interface EventsRepository extends JpaRepository<Event, Integer>{
	
	public List<Event> findAll();
	
	@Query("SELECT ev , ie FROM Event ev, InterestsEvents ie  WHERE ie.idEvent = ev.idEvent")
	public List<Event> findEventss();
	
	@Query("SELECT ev FROM Event ev WHERE ev.idUser = ?1") //   AND ins.idUser = ?1    
	public List<Event> findEventByUser(User idUser);
	
	public Event findByIdEvent(Integer idEvent);


}
