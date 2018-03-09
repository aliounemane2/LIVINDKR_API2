package qualshore.livindkr.main.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import qualshore.livindkr.main.entities.CustomUserDetails;
import qualshore.livindkr.main.entities.Event;
import qualshore.livindkr.main.entities.Institution;
import qualshore.livindkr.main.entities.InterestsEvents;
import qualshore.livindkr.main.entities.User;
import qualshore.livindkr.main.repository.EventsRepository;
import qualshore.livindkr.main.repository.InterestsEventsRepository;
import qualshore.livindkr.main.services.ImageStorageService;

@RequestMapping("/event")
@RestController
public class EventControllers {
	
	@Autowired
	private EventsRepository eventsrepository;
	
	
	
	@Autowired
	private ImageStorageService imageEvent;
	
	@Autowired
	private InterestsEventsRepository intEventsRepository;
	
	@Autowired
	Environment env;
	
	
	@RequestMapping(value="/events_by_user/", method=RequestMethod.GET)
	public HashMap<String, Object> getAllEventsByUser( ){
		
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) auth.getPrincipal();
        // return "Hello livInDakr "+customUserDetails.getNom();
        
        // User idUser
		
		HashMap<String, Object> h= new HashMap<String, Object>();
		String location = env.getProperty("root.location.load");

		List<Event> event = eventsrepository.findEventByUser(customUserDetails);
		
		if (event==null) {
			h.put("message", " Cet utilisateur n'a pas d'evenement.");
			h.put("status", -1);
			return h;

		}
			
			h.put("message", "Les evenements de l'utilisateur sont : ");
			h.put("events", event);
			h.put("status", 0);
			h.put("urls", "http://"+location);
			return h;	
	
	}
	
	
	
	
	@RequestMapping(value="/events_by_user_after/", method=RequestMethod.GET)
	public HashMap<String, Object> getAllEventsByUserOrder( ){
		
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) auth.getPrincipal();
        // return "Hello livInDakr "+customUserDetails.getNom();
        
        // User idUser
		
		HashMap<String, Object> h= new HashMap<String, Object>();
		String location = env.getProperty("root.location.load");

		List<Event> event = eventsrepository.findEventByUserAfter(customUserDetails);
		
		if (event==null) {
			h.put("message", " Cet utilisateur n'a pas d'evenement.");
			h.put("status", -1);
			return h;

		}
			
			h.put("message", "Les evenements de l'utilisateur sont : ");
			h.put("events", event);
			h.put("status", 0);
			h.put("urls", "http://"+location);
			return h;	
	
	}
	
	
	
	@RequestMapping(value="/getEvent/{idEvent}", method = RequestMethod.GET)
	public Map<String,Object> getOneEvent(@PathVariable Integer idEvent) {
		HashMap<String, Object> h = new HashMap<String, Object>();

		String location = env.getProperty("root.location.load");
		
		Event event = eventsrepository.findOne(idEvent);
		
		if (event == null ) { 
			
			h.put("message", "Cette evenement n'existe pas.");
			return h;
			
		}else {
		
			h.put("message", "L'evenement est :");
			h.put("event", event);
			h.put("urls", "http://"+location);
			return h;
			
		}
	}
	
	
	
	@RequestMapping(value="/update_events_by_user/{idEvent}", method=RequestMethod.PUT)
	public HashMap<String, Object> UpdateEventsByUser(@RequestBody Event event, @PathVariable Integer idEvent){
		
		HashMap<String, Object> h= new HashMap<String, Object>();
		String location = env.getProperty("root.location.load");
		
		if (event == null || idEvent==null) {
			h.put("message", " un ou plusieurs parametres sont manquants.");
			h.put("status", -1);
			return h;
		}
		Event event_user = eventsrepository.findByIdEvent(idEvent);
		
		event_user.setDateEvent(event.getDateEvent());
		event_user.setDescriptionEvent(event.getDescriptionEvent());
		event_user.setNomEvent(event.getNomEvent());
		event_user.setPhotoEvent(event.getPhotoEvent());
		event_user.setIdCategory(event.getIdCategory());
		event_user.setIdInstitution(event.getIdInstitution());
		event_user.setIdPlace(event.getIdPlace());
		
		eventsrepository.saveAndFlush(event_user);		
			
		h.put("message", "L'evenement de l'utilisateur a ete modifie avec succes");
		h.put("events", event_user);
		h.put("status", 0);
		h.put("urls", "http://"+location);
		return h;

	}
	
	
	@RequestMapping(value="/delete_event/{idEvent}", method = RequestMethod.DELETE)
	public Map<String,Object> delete_Event(@PathVariable Integer idEvent) {
		HashMap<String, Object> h = new HashMap<String, Object>();

			Event event = eventsrepository.findByIdEvent(idEvent);
			
			if (event==null) {
				h.put("message", "Cette evenement n'existe pas.");
				h.put("status", 0);
			}else {
				
				eventsrepository.delete(idEvent);
				h.put("message", "La Suppression de l'evenement est effective.");
				h.put("status", 0);
			}
			
			return h;
	}
	
	
	
	
	
	
	
	
	@RequestMapping(value="/list_events", method=RequestMethod.GET)
	public HashMap<String, Object> getAllEvents(){
		
		HashMap<String, Object> h= new HashMap<String, Object>();
		String location = env.getProperty("root.location.load");
		
		List<Event> events = eventsrepository.findAll();
		
		if (events.size() == 0) {
			
			h.put("message", "Il n'y a pas d'evenements.");
			h.put("status", -1);
			return h;
			
		}else {
			
			h.put("message", "La liste des evenements sont :");
			h.put("article", events);
			h.put("urls", "http://"+location);
			h.put("status", 0);
			return h;
			
		}	
	}
	
	
	// findEventByUser
	
	@RequestMapping(value="/liste_events", method=RequestMethod.GET)
	public HashMap<String, Object> getAllEventss(){
		
		HashMap<String, Object> h= new HashMap<String, Object>();
		String location = env.getProperty("root.location.load");

		
		List<InterestsEvents> eventss = intEventsRepository.findEventsss();
		
		if (eventss.size() == 0) {
			
			h.put("message", "Il n'y a pas d'evenements.");
			h.put("status", -1);
			return h;
			
		}else {
			
			h.put("message", "La liste des evenements sont :");
			h.put("article", eventss);
			h.put("urls", "http://"+location);
			h.put("status", 0);
			return h;
			
		}	
	}
	
	
	
	@RequestMapping(value="/saveEvent/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public Map<String,Object> saveEvent(@RequestBody Event evenements) {
		//  @RequestBody InterestsEvents interestsEvents
		HashMap<String, Object> h = new HashMap<String, Object>();
		InterestsEvents intEvent = new InterestsEvents();

		
		User idUser;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) auth.getPrincipal();
        // return "Hello livInDakr "+customUserDetails.getNom();
        idUser = customUserDetails;
        
        
		
		if(evenements == null){
			
			h.put("message", "paramètres vides.");
			h.put("status", -1);
			return h;
			
		}else {
			evenements.setIdUser(idUser);
			evenements = eventsrepository.save(evenements);
			// intEventsRepository.save(interestsEvents);
			
			// intEvent.setHeureDebut(evenements);
			// intEvent.setIdEvent(evenements);
			// intEvent.setIdInterest(evenements.geti);

			
			
			
			h.put("message", "L'enregistrement des evenements est effective.");
			h.put("evenements", evenements);
			// h.put("EventsInterests", interestsEvents);
			h.put("status", 0);
			return h;
			
		}
	}
	

	@RequestMapping(value="/upload/", method = RequestMethod.POST)
	public HashMap<String, Object> uploadEvent(MultipartHttpServletRequest requests) throws IOException {
		HashMap<String, Object> h = new HashMap<String, Object>();
		
		// JSONObject item = new JSONObject();
        


		HashMap<String, Object> img = imageEvent.store(requests);
		/*h.put("message", "L'enregistrement de l'image est effective.");
		h.put("image_events", img);
		h.put("status", 0);
		return h;
		*/
		
		
        return img;
		
	}
	

}
