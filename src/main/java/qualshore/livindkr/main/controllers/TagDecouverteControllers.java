package qualshore.livindkr.main.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import qualshore.livindkr.main.entities.TagDecouverte;
import qualshore.livindkr.main.repository.TagDecouverteRepository;


@RequestMapping("/tagDecouverte")
@RestController
public class TagDecouverteControllers {
	
	@Autowired
	private TagDecouverteRepository tagDecouverteRepository;
	
	@Autowired
	Environment env;
	
	
	@RequestMapping(value="/list_tag_decouverte", method = RequestMethod.GET)
	public Map<String,Object> list_tag_decouverte() {
		HashMap<String, Object> h = new HashMap<String, Object>();

		String location = env.getProperty("root.location.load");

		List<TagDecouverte>  tag_decouverte = tagDecouverteRepository.findAll();
		
		if (tag_decouverte.size() == 0) {
			
			h.put("message", "La liste des Tag Decouverte est vide.");
			h.put("status", -1);
			return h;
			
		}else {
			
			h.put("message", "La liste des Tag Decouverte est :");
			h.put("notes", tag_decouverte);
			h.put("urls", "http://"+location);
			h.put("status", 0);
			return h;
			
		}			
	}
}
