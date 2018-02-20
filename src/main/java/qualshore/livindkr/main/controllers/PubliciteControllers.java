package qualshore.livindkr.main.controllers;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import qualshore.livindkr.main.entities.CustomUserDetails;
import qualshore.livindkr.main.entities.Publicite;
import qualshore.livindkr.main.entities.User;
import qualshore.livindkr.main.repository.PubliciteRepository;

@RequestMapping("/publicite")
@RestController
public class PubliciteControllers {

	@Autowired
	private PubliciteRepository publiciterepository;
	
	@Autowired
	Environment env;
	
	
	@RequestMapping(value="/createPublicite", method = RequestMethod.POST)
	public Map<String,Object> getOneInstitution(@RequestBody Publicite publicite) {
		HashMap<String, Object> h = new HashMap<String, Object>();

		String location = env.getProperty("root.location.load");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) auth.getPrincipal();
        // return "Hello livInDakr "+customUserDetails.getNom();
        User idUser = customUserDetails;

		// Publicite publicite = institutionrepository.findByIdInstitution(idInstitution);
		
		if (publicite == null ) { 
			
			h.put("message", "Cette publicite n'existe pas.");
			h.put("status", -1);
			return h;
			
		}else {
			// Date localDate = localDateTime.toLocalDate();
			publicite.setIdUser(idUser);
			//publicite.setDatePublicite(new Date()); // la date d'aujourd'hui
			publiciterepository.save(publicite);
			h.put("message", "L'institution est :");
			h.put("publicite", publicite);
			h.put("urls", "http://"+location);
			h.put("status", 0);
			return h;
			
		}
	}
	
	
	
	@RequestMapping(value="/listPublicite", method = RequestMethod.GET)
	public Map<String,Object> getListInstitution() {
		HashMap<String, Object> h = new HashMap<String, Object>();

		String location = env.getProperty("root.location.load");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) auth.getPrincipal();
        // return "Hello livInDakr "+customUserDetails.getNom();
        User idUser = customUserDetails;
		
		
		List<Publicite> publicite = publiciterepository.findPubliciteByUser(idUser);
		
		if (publicite == null ) { 
			
			h.put("message", "Cette publicite n'existe pas.");
			h.put("status", -1);
			return h;
			
		}else {
			
			// publiciterepository.save(publicite);
			h.put("message", "L'institution est :");
			h.put("publicite", publicite);
			h.put("urls", "http://"+location);
			h.put("status", 0);
			return h;
			
		}
	}
	
	
	@RequestMapping(value="/updatePublicite", method = RequestMethod.PUT)
	public Map<String,Object> updatePublicite(@RequestBody Publicite publicite) {
		HashMap<String, Object> h = new HashMap<String, Object>();

		String location = env.getProperty("root.location.load");
		
		
		Publicite publicites = publiciterepository.findByIdPublicite(publicite.getIdPublicite());
		
		publicites.setTypePublicite(publicite.getTypePublicite());
		publicites.setTitrePublicite(publicite.getTitrePublicite());
		publicites.setPhotoPublicite(publicite.getPhotoPublicite());
		publiciterepository.saveAndFlush(publicites);
		
		h.put("message", "La publicite est :");
		h.put("publicite", publicite);
		h.put("urls", "http://"+location);
		h.put("status", 0);
		return h;
		
	}
	
	
	@RequestMapping(value="/deletePublicite", method = RequestMethod.DELETE)
	public Map<String,Object> deletePublicite(@PathVariable Integer idPublicite) {
		HashMap<String, Object> h = new HashMap<String, Object>();

		String location = env.getProperty("root.location.load");
		
		Publicite publicites = publiciterepository.findByIdPublicite(idPublicite);
		
		if (publicites == null ) { 
			
			h.put("message", "Cette publicite n'existe pas.");
			h.put("status", -1);
			return h;
			
		}else {
			
			publiciterepository.delete(idPublicite);
			h.put("message", "La suppression de cette publicite est effective.");
			h.put("publicite", publicites);
			h.put("urls", "http://"+location);
			h.put("status", 0);
			return h;
			
		}
				
	}
	

	
	
}
