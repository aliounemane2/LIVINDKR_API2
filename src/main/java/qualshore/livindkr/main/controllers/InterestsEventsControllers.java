package qualshore.livindkr.main.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import qualshore.livindkr.main.entities.Event;
import qualshore.livindkr.main.entities.Interest;
import qualshore.livindkr.main.entities.InterestsEvents;
import qualshore.livindkr.main.models.Interests_Events_Model;
import qualshore.livindkr.main.repository.EventsRepository;
import qualshore.livindkr.main.repository.InterestsEventsRepository;
import qualshore.livindkr.main.services.ImageStorageService;

@RequestMapping("/interestsEvents")
@RestController
public class InterestsEventsControllers {
	
	
	@Autowired
	private InterestsEventsRepository intEvenRep;
	
	
	@Autowired
	private EventsRepository evenRep;
	
	@Autowired
	private ImageStorageService imageEvent;
	
	
	
	
	@RequestMapping(value="/saveInterestsEvents", method = RequestMethod.POST)
	public Map<String,Object> list_interests(@RequestBody Interests_Events_Model intEvM) {
		HashMap<String, Object> h = new HashMap<String, Object>();
		
		
		Event event = new Event();
        InterestsEvents inter = new InterestsEvents();
        event.setNomEvent(intEvM.getNomEvent());
        event.setDescriptionEvent(intEvM.getDescriptionEvent());
        event.setDateEvent(intEvM.getDateEvent());
        event.setPhotoEvent(intEvM.getPhotoEvent());
        event.setIdInstitution(intEvM.getIdInstitution());
        event.setIdPlace(intEvM.getIdPlace());
        event.setIdCategory(intEvM.getIdCategory());
        event.setIdUser(intEvM.getIdUser());
        evenRep.save(event);
        
        inter.setIdInterest(intEvM.getIdInterest());
        inter.setIdEvent(event);
        inter.setHeureDebut(intEvM.getHeureDebut());
        inter.setHeureFin(intEvM.getHeureFin());
        intEvenRep.save(inter);
        

        h.put("message", "L'enregistrement des interets Events est effective:");
		h.put("interestsEvents", intEvM);
		h.put("status", 0);
		return h;
				
		
	}
	
	
	

}
