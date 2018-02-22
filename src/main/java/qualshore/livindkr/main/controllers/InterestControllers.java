package qualshore.livindkr.main.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import qualshore.livindkr.main.entities.Interest;
import qualshore.livindkr.main.repository.InterestRepository;

@RequestMapping("/interests")
@RestController
public class InterestControllers {
	
	@Autowired
	private InterestRepository interestrepository;
	
	
	@Autowired
	Environment env;
	
	
	@RequestMapping(value="/list_interests", method = RequestMethod.GET)
	public Map<String,Object> list_interests() {
		HashMap<String, Object> h = new HashMap<String, Object>();
		String location = env.getProperty("root.location.load");

		
		List<Interest> interest = interestrepository.findAll();
		
		if (interest.size() == 0) {
			
			h.put("message", "La liste des centres d'interets est vide.");
			h.put("status", -1);
			return h;
			
		}else {
			h.put("message", "La liste des centres d'interets est :");
			h.put("interests", interest);
			h.put("status", 0);
			h.put("location", "http://"+location);
			return h;
			
		}		
		
	}
	
	

}
