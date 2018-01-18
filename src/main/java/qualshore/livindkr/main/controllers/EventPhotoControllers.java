package qualshore.livindkr.main.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import qualshore.livindkr.main.entities.Event;
import qualshore.livindkr.main.entities.EventPhoto;
import qualshore.livindkr.main.repository.EventsPhotosRepository;

@RequestMapping("/eventPhoto")
@RestController
public class EventPhotoControllers {
// findEventsPhotoByEvents
	
	@Autowired
	private EventsPhotosRepository eventsphotorepository;
	
	@RequestMapping(value="/list_event_photo_by_events/{id}", method = RequestMethod.GET)
	public Map<String,Object> list_event_photo_by_events(@PathVariable Event id) {
		HashMap<String, Object> h = new HashMap<String, Object>();

		
		List<EventPhoto>  eventsPhoto = eventsphotorepository.findEventsPhotoByEvents(id);
		
		if (eventsPhoto.size() == 0) {
			
			h.put("message", "La liste des events Photos est vide.");
			h.put("status", -1);
			return h;
			
		}else {
			h.put("message", "La liste des events Photos est :");
			h.put("events_photos", eventsPhoto);
			h.put("status", 0);
			return h;
			
		}		
		
	}
}
