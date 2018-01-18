package qualshore.livindkr.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import qualshore.livindkr.main.entities.Event;
import qualshore.livindkr.main.entities.EventPhoto;

public interface EventsPhotosRepository extends JpaRepository<EventPhoto, Integer>{
	
	@Query("SELECT ep FROM EventPhoto ep WHERE ep.idEvent = ?1 ")
	public List<EventPhoto> findEventsPhotoByEvents(Event idEvent);

}
