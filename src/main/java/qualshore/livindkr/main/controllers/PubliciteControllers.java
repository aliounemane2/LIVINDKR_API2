package qualshore.livindkr.main.controllers;

import java.io.IOException;
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
import org.springframework.web.multipart.MultipartHttpServletRequest;

import qualshore.livindkr.main.entities.CustomUserDetails;
import qualshore.livindkr.main.entities.Publicite;
import qualshore.livindkr.main.entities.User;
import qualshore.livindkr.main.repository.PubliciteRepository;
import qualshore.livindkr.main.services.ImageStorageService;

@RequestMapping("/publicite")
@RestController
public class PubliciteControllers {

	@Autowired
	private PubliciteRepository publiciterepository;
	
	@Autowired
	Environment env;
	

	@Autowired
	private ImageStorageService imagePublicite;
	
	
	@RequestMapping(value="/listPubliciteByCarroussel", method = RequestMethod.GET)
	public Map<String,Object> listPubliciteByCarroussel() {
		HashMap<String, Object> h = new HashMap<String, Object>();

		String location = env.getProperty("root.location.load");
		
		List<Publicite> publicite = publiciterepository.findPubliciteByCarroussel();
		
		if (publicite.size() == 0) {
			h.put("message", "Cette publicite n'existe pas.");
			h.put("status", -1);
		}else {
			
			h.put("message", "La publicite est :");
			h.put("publicite", publicite.get(0));
			h.put("urls", "http://"+location);
			h.put("status", 0);
			
		}

		return h;
	}
	
	
	
	@RequestMapping(value="/listPubliciteByArticle", method = RequestMethod.GET)
	public Map<String,Object> listPubliciteByArticles() {
		HashMap<String, Object> h = new HashMap<String, Object>();

		String location = env.getProperty("root.location.load");
		
		List<Publicite> publicite = publiciterepository.findPubliciteByArticle();
		
		if (publicite.size() == 0) {
			h.put("message", "Cette publicite n'existe pas.");
			h.put("status", -1);
		}else {
			
			h.put("message", "La publicite est :");
			h.put("publicite", publicite.get(0));
			h.put("urls", "http://"+location);
			h.put("status", 0);
			
		}

		return h;
	}
	
	
	
	@RequestMapping(value="/listPubliciteByAccueil", method = RequestMethod.GET)
	public Map<String,Object> listPubliciteByAccueils() {
		HashMap<String, Object> h = new HashMap<String, Object>();

		String location = env.getProperty("root.location.load");
		
		List<Publicite> publicite = publiciterepository.findPubliciteByAccueil();
		
		if (publicite.size() == 0) {
			h.put("message", "Cette publicite n'existe pas.");
			h.put("status", -1);
		}else {
			
			h.put("message", "La publicite est :");
			h.put("publicite", publicite.get(0));
			h.put("urls", "http://"+location);
			h.put("status", 0);
			
		}

		return h;
	}
	
	
	
	
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
	
	
	
	@RequestMapping(value="/getIdPublicite/{idPublicite}", method = RequestMethod.GET)
	public Map<String,Object> getIdInstitution(@PathVariable Integer idPublicite) {
		HashMap<String, Object> h = new HashMap<String, Object>();

		String location = env.getProperty("root.location.load");
		
		// Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        // CustomUserDetails customUserDetails = (CustomUserDetails) auth.getPrincipal();
        // return "Hello livInDakr "+customUserDetails.getNom();
        // User idUser = customUserDetails;

		// Publicite publicite = institutionrepository.findByIdInstitution(idInstitution);
		Publicite publicite = publiciterepository.findByIdPublicite(idPublicite);
		if (publicite == null ) { 
			
			h.put("message", "Cette publicite n'existe pas.");
			h.put("status", -1);
			return h;
			
		}else {
			h.put("message", "La publicite est :");
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
			// nom du plat, ingredient, tarif
		}else {
			
			// publiciterepository.save(publicite);
			h.put("message", "L'institution est :");
			h.put("publicite", publicite);
			h.put("urls", "http://"+location);
			h.put("status", 0);
			return h;
			
		}
	}
	
	
	@RequestMapping(value="/updatePublicite/{idPublicite}", method = RequestMethod.PUT)
	public Map<String,Object> updatePublicite(@PathVariable Integer idPublicite, @RequestBody Publicite publicite) {
		HashMap<String, Object> h = new HashMap<String, Object>();

		String location = env.getProperty("root.location.load");
		
		
		Publicite publicites = publiciterepository.findByIdPublicite(idPublicite);
		
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
	
	
	@RequestMapping(value="/deletePublicite/{idPublicite}", method = RequestMethod.DELETE)
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
	
	
	@RequestMapping(value="/upload/", method = RequestMethod.POST)
	public HashMap<String, Object> uploadEvent(MultipartHttpServletRequest requests) throws IOException {
		HashMap<String, Object> h = new HashMap<String, Object>();
		
		// JSONObject item = new JSONObject();
       
		HashMap<String, Object> img = imagePublicite.store(requests);
		/*
		h.put("message", "L'enregistrement de l'image est effective.");
		h.put("image_events", img);
		h.put("status", 0);
		return h;
		*/
        return img;
		
	}
	

	
	
}
