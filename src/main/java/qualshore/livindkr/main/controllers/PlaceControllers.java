package qualshore.livindkr.main.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import qualshore.livindkr.main.entities.Place;
import qualshore.livindkr.main.repository.PlaceRepository;

@RequestMapping("/place")
@RestController
public class PlaceControllers {
	
	@Autowired
	private PlaceRepository placerepository;
	
	@RequestMapping(value="/list_place", method=RequestMethod.GET)
	public HashMap<String, Object> getAllPlaces(){
		
		HashMap<String, Object> h = new HashMap<String, Object>();
		
		List<Place> place = placerepository.findAll();
		
		if (place.size() == 0) {
			
			h.put("message", "Il n'y a pas d'evenements.");
			h.put("status", -1);
			return h;
			
		}else {
			
			h.put("message", "La liste des evenements sont :");
			h.put("place", place);
			h.put("status", 0);
			return h;
			
		}	
	}
	

}
