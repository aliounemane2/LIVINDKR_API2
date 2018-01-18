package qualshore.livindkr.main.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import qualshore.livindkr.main.entities.Category;
import qualshore.livindkr.main.entities.SousCategory;
import qualshore.livindkr.main.repository.CategoryRepository;
import qualshore.livindkr.main.repository.SousCategoryRepository;

@RequestMapping("/sous_category")
@RestController
public class SousCategoryControllers {
	
	@Autowired
	private SousCategoryRepository souscategoryrepository;
	
	@Autowired
	private CategoryRepository categoryrepository;
	
	@RequestMapping(value="/list_sous_category/{id}", method = RequestMethod.GET)
	public Map<String,Object> category(@PathVariable Category id) {
		HashMap<String, Object> h = new HashMap<String, Object>();

		
		List<SousCategory>  souscategory = souscategoryrepository.findSousCategoryByCategory(id);
		
		if (souscategory.size() == 0) {
			
			h.put("message", "La categorie n'existe pas.");
			return h;
			
		}
		
		// List<SousCategory>  souscategory = souscategoryrepository.findSousCategoryByCategory(id);
			h.put("message", "La liste des categories est :");
			h.put("sous_category", souscategory);
			return h;
		
		
	}
	
	

}
