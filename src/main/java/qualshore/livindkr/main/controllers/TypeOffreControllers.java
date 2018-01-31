package qualshore.livindkr.main.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import qualshore.livindkr.main.entities.TypeOffre;
import qualshore.livindkr.main.repository.TypeOffreRepository;

@RequestMapping("/typeOffre")
@RestController
public class TypeOffreControllers {
	
	@Autowired
	private TypeOffreRepository typeOffrerepository;

	@RequestMapping(value="/listTypeOffres/", method = RequestMethod.GET)
	public Map<String,Object> list_TypesOffres() {
		HashMap<String, Object> h = new HashMap<String, Object>();

		
		List<TypeOffre> typeOffres = typeOffrerepository.findAll();
		
		if (typeOffres.size() == 0) {
			
			h.put("message", "La liste des types d'offres est vide.");
			h.put("status", -1);
			return h;
			
		}else {
			h.put("message", "La liste des types Offres est :");
			h.put("offres", typeOffres);
			h.put("status", 0);
			return h;
			
		}		
		
	}

	
}
