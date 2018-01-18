package qualshore.livindkr.main.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import qualshore.livindkr.main.entities.Category;
import qualshore.livindkr.main.repository.CategoryRepository;


@RequestMapping("/category")
@RestController
public class CategoryControllers {
	
	@Autowired
	private CategoryRepository categoryrepository;
	
	@RequestMapping(value="/list_category", method = RequestMethod.GET)
	public Map<String,Object> category() {
		
		List<Category> category = categoryrepository.findAll();
		HashMap<String, Object> h = new HashMap<String, Object>();
		
		if (category.size() == 0) {
			
			h.put("message", "La liste des categories est vide.");
			return h;
			
		}else {
			
			h.put("message", "La liste des categories est :");
			h.put("category", category);
			return h;
		
		}
	}

	
}
