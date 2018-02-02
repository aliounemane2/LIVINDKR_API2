package qualshore.livindkr.main.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import qualshore.livindkr.main.entities.Institution;
import qualshore.livindkr.main.entities.Vignette;
import qualshore.livindkr.main.repository.VignetteRepository;

@RequestMapping("/vignette")
@RestController
public class VignetteControllers {

	@Autowired
	private VignetteRepository vignetterepository;
	
	@RequestMapping(value="/list_vignette/{IdInstitution}", method = RequestMethod.GET)
	public Map<String,Object> vignette_institution(@PathVariable Institution IdInstitution) {
		
		List<Vignette> vignette = vignetterepository.findVignetteByInstitution(IdInstitution);
		HashMap<String, Object> h = new HashMap<String, Object>();
		
		if (vignette.size() == 0) {
			
			h.put("message", "La liste des vignettes en fonction des institutions est vide.");
			return h;
			
		}else {
			
			h.put("message", "La liste des vignettes en fonction des institutions est :");
			h.put("category", vignette);
			return h;
		
		}
	}
	
}
