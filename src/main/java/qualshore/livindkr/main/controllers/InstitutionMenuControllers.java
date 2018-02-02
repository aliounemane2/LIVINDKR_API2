package qualshore.livindkr.main.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import qualshore.livindkr.main.entities.InstitutionMenu;
import qualshore.livindkr.main.repository.MenuInstitutionRepository;

@RequestMapping("/institutionMenu")
@RestController
public class InstitutionMenuControllers {
	
	
	@Autowired
	private MenuInstitutionRepository mninsrepository;
	
	
	@RequestMapping(value="/menuInst/{IdInteger}", method=RequestMethod.GET)
	public HashMap<String, Object> getAllArticles(@PathVariable Integer IdInteger){
		
		HashMap<String, Object> h= new HashMap<String, Object>();
		
		List<InstitutionMenu> institutionMenu = mninsrepository.findMenuByInstitution(IdInteger);
		
		if (institutionMenu.size() == 0) {
			
			h.put("message", "Il n'y a pas de menu.");
			h.put("status", -1);
			return h;
			
		}else {
			
			h.put("message", "La liste des articles sont :");
			h.put("institutionMenu", institutionMenu);
			h.put("status", 0);
			return h;
			
		}
	}
	

}
