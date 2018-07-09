package qualshore.livindkr.main.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import net.minidev.json.JSONObject;
import qualshore.livindkr.main.entities.Category;
import qualshore.livindkr.main.entities.CustomUserDetails;
import qualshore.livindkr.main.entities.Institution;
import qualshore.livindkr.main.entities.InstitutionMenu;
import qualshore.livindkr.main.entities.Menu;
import qualshore.livindkr.main.entities.Note;
import qualshore.livindkr.main.entities.SousCategory;
import qualshore.livindkr.main.entities.User;
import qualshore.livindkr.main.repository.EventsRepository;
import qualshore.livindkr.main.repository.InstitutionRepository;
import qualshore.livindkr.main.repository.MenuInstitutionRepository;
import qualshore.livindkr.main.repository.MenuRepository;
import qualshore.livindkr.main.repository.NotesRepository;
import qualshore.livindkr.main.repository.UserRepository;
import qualshore.livindkr.main.services.AndroidPushNotificationsService;
import qualshore.livindkr.main.services.ImageStorageService;

// @CrossOrigin(maxAge=3600)
@RequestMapping("/institution")
@RestController
public class InstitutionControllers {
	
	@Autowired
	private InstitutionRepository institutionrepository;
	
	
	@Autowired
	private 	MenuRepository menuRepository;
	
	
	@Autowired
	private 	MenuInstitutionRepository menuInstitutionRepository;
	
	
	@Autowired
	Environment env;
	
	@Autowired
	private ImageStorageService imageInstitution;
	
	
	@Autowired
	private NotesRepository noteRepository;
	
	@Autowired
	private EventsRepository evRepository;
	
	@Autowired
	private UserRepository usersReposi;
	
	@Autowired
	AndroidPushNotificationsService androidPushNotificationsService;
	
	
	@RequestMapping(value="/getInstitution/{idInstitution}", method = RequestMethod.GET)
	public Map<String,Object> getOneInstitution(@PathVariable Integer idInstitution) {
		HashMap<String, Object> h = new HashMap<String, Object>();

		String location = env.getProperty("root.location.load");

		Institution institution = institutionrepository.findByIdInstitution(idInstitution);
		
		if (institution == null ) { 
			
			h.put("message", "Cette institution n'existe pas.");
			return h;
			
		}else {
		
			h.put("message", "L'institution est :");
			h.put("institution", institution);
			h.put("urls", "http://"+location);
			return h;
			
		}
	}

	
	
	@RequestMapping(value="/list_institution/{id}", method = RequestMethod.GET)
	public Map<String,Object> category(@PathVariable Category id) {
		HashMap<String, Object> h = new HashMap<String, Object>();

		String location = env.getProperty("root.location.load");
		
		List<Institution>  institution = institutionrepository.findInstitutionByCategory(id);
		
		if (institution.size() == 0) {
			
			h.put("message", "La categorie n'existe pas.");
			return h;
			
		}
		
			h.put("message", "La liste des categories est :");
			h.put("sous_category", institution);
			h.put("urls", "http://"+location);
			return h;
		
	}
	
	
	@RequestMapping(value="/update_institution_by_user/{idInstitution}", method=RequestMethod.PUT)
	public HashMap<String, Object> UpdateEventsByUser(@PathVariable Integer idInstitution, @RequestBody Institution institution){
		
		HashMap<String, Object> h= new HashMap<String, Object>();
		String location = env.getProperty("root.location.load");
		

		if (institution==null || idInstitution==null) {
			
			h.put("status", -1);
			h.put("message", "1 ou plusieurs paramètres manquants");
			h.put("institution", institution);
			h.put("idInstitution", institution.getIdInstitution());
			return h;

		}
		Institution institution_user = institutionrepository.findByIdInstitution(idInstitution);
		
		institution_user.setAdresseIns(institution.getAdresseIns());
		institution_user.setDescriptionIns(institution.getDescriptionIns());
		institution_user.setLatitudeIns(institution.getLatitudeIns());
		institution_user.setLongitudeIns(institution.getLongitudeIns());
		institution_user.setNomIns(institution.getNomIns());
		institution_user.setPhotoIns(institution.getPhotoIns());
		institution_user.setPrice(institution.getPrice());
		institution_user.setSolde(institution.getSolde());
		institution_user.setTelephoneIns(institution.getTelephoneIns());
		institution_user.setIdCategory(institution.getIdCategory());
		institution_user.setIdSousCategory(institution.getIdSousCategory());
		institution_user.setIdTypeoffre(institution.getIdTypeoffre());
		institution_user.setInterestIdInterest(institution.getInterestIdInterest());
		
		institutionrepository.saveAndFlush(institution_user);
		
					
		h.put("message", "L'institution de l'utilisateur a ete modifie avec succes");
		h.put("institution", institution_user);
		h.put("status", 0);
		h.put("urls", "http://"+location);
		return h;

	}
	
	
	
	@RequestMapping(value="/institution_proximite/{idInstitution}", method = RequestMethod.POST)
	public Map<String,Object> events_proximite(@PathVariable Integer idInstitution){
		HashMap<String, Object> h = new HashMap<String, Object>();
		
		if (idInstitution == null){
			
			h.put("message", "Push notification Non envoyee");
			h.put("status", -1);
			
		}else {
			

			
			Institution institutio = institutionrepository.findByIdInstitution(idInstitution);
			
			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        CustomUserDetails customUserDetails = (CustomUserDetails) auth.getPrincipal();
			User idUser;
			idUser = customUserDetails;
			
				        
			JSONObject body = new JSONObject();
			body.put("to", ""+idUser.getFcmToken());
			body.put("priority", "high");

	 
			JSONObject notification = new JSONObject();
			notification.put("title", "Institution a proximite");
			notification.put("body", ""+institutio.getNomIns());
			
			JSONObject data = new JSONObject();
			data.put("Key-1", "JSA Data 1");
			data.put("Key-2", "JSA Data 2");
	 
			body.put("notification", notification);
			body.put("data", data);
			
			HttpEntity<String> request = new HttpEntity<>(body.toString());
			// String ss="cQqCurDZIsE:APA91bELL0fiOHDph0MZsFm4Rtdkq9fRshn45KE5UXrSr2wV3A8FO2hVddAdhGwmHhz7zu8BcsUUxdenP7dYiHw98ZDpg7OdOb31alntB46lokNq99NbTG1YQVwcYmUzlkxqeZqyuEpc";
			CompletableFuture<String> pushNotification = androidPushNotificationsService.send(request);
			CompletableFuture.allOf(pushNotification).join();
	 
			try {
				String firebaseResponse = pushNotification.get();
				h.put("message", "CEST BON 1");
				h.put("fcm", firebaseResponse);
				h.put("status", 0);

				return h;

				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
	 
			h.put("message", "CEST BON 2");
			h.put("status", 2); 
			
			return h;

			
			
		}
		return h;
	}
	
	@CrossOrigin
	@RequestMapping(value="/delete_institution/{idInstitution}", method = RequestMethod.DELETE)
	public Map<String,Object> delete_institution(@PathVariable Integer idInstitution) {
		HashMap<String, Object> h = new HashMap<String, Object>();

			Institution institution = institutionrepository.findByIdInstitution(idInstitution);
			
			
			if (institution==null) {
				
				h.put("message", "Cette institution n'existe pas.");
				h.put("status", 0);
				
			}else {
				/*
				if (notess != null ) {
					noteRepository.delete(idInstitution);
					institutionrepository.delete(institution);
					h.put("message", "La Suppression de la note de l'institution est effective.");
					h.put("status", 0);
				*/
				// noteRepository.delete(idInstitution);
				
				
				
					//deleteEventByInstitution
				
					evRepository.deleteEventByInstitution(institution);
					noteRepository.deleteNoteByInstitution(institution);
					institutionrepository.delete(institution);
					h.put("message", "La Suppression de l'institution est effective.");
					h.put("status", 0);
				// }
			}
			
			return h;
	}
	
	
	
	@RequestMapping(value="/list_institution_souscategory/{id}", method = RequestMethod.GET)
	public Map<String,Object> sous_category(@PathVariable SousCategory id) {
		
		HashMap<String, Object> h = new HashMap<String, Object>();
		String location = env.getProperty("root.location.load");


		
		List<Institution>  institution = institutionrepository.findInstitutionBySousCategory(id);
		
		if (institution.size() == 0) {
			
			h.put("message", "La categorie n'existe pas.");
			return h;
			
		}
		
			h.put("message", "La liste des categories est :");
			h.put("sous_category", institution);
			h.put("urls", "http://"+location);
			return h;
		
	}
	
	

	@RequestMapping(value="/recommandation", method = RequestMethod.GET)
	public Map<String,Object> recommandation(User idUser) {
		HashMap<String, Object> h = new HashMap<String, Object>();
		String location = env.getProperty("root.location.load");


		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) auth.getPrincipal();
        // return "Hello livInDakr "+customUserDetails.getNom();
        idUser = customUserDetails;

		
		List<Institution>  institution = institutionrepository.findRecommandations(idUser.getIdUser());
		
		if (institution.size() == 0) {
			
			h.put("message", "Aucun Institution ne correspond a ses centres d'interets. ");
			h.put("status", -1);
			return h;
			
		}
		
			h.put("message", "La liste de la suggestion des institutions est :");
			h.put("sous_category", institution);
			h.put("urls", "http://"+location);
			h.put("status", 0);

			return h;
		
	}
	
	
	
	
	
	
	
	
	
	

	@RequestMapping(value="/saveInstitution/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public Map<String,Object> saveInstitution(@RequestBody Institution institution, @RequestBody Menu menu, @RequestBody InstitutionMenu institutionMenu) {
	// public Map<String,Object> saveInstitution(@RequestBody Institution institution) {
	
		HashMap<String, Object> h = new HashMap<String, Object>();
		String location = env.getProperty("root.location.load");
		
		// Le bon
		User idUser;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) auth.getPrincipal();
        idUser = customUserDetails; 
        
   
        
       /* if (institutionrepository.isIn) {
        	
        }
        */

        if (institution == null){
			
			h.put("message", "paramètres vides.");
			h.put("status", -1);
			return h;
			
		}else {
			
			if (institution!= null ) {
				institution.setIdUser(idUser);
				institution = institutionrepository.save(institution);
				
				h.put("message", "L'enregistrement des institutions est effective:");
				h.put("institution", institution);
				h.put("urls", "http://"+location);
				h.put("status", 0);
				
				List<User> use = usersReposi.findAll();
				for (int i = 0; i < use.size(); i++) {
					
					System.out.println(" Boucle Boucle Boucle Boucle Boucle 11111");
					System.out.println(use.get(i).getNom()+" - "+use.get(i).getPrenom());
					System.out.println(institution.getNomIns());
					System.out.println(" Boucle Boucle Boucle Boucle Boucle 22222");
				
				}
				//return h;
			}
			return h;	
		}
		
	}
	
	
	
	@RequestMapping(value="/InstitutionByUser/", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Map<String,Object> InstitutionByUser( ) {
		//  User idUser 
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) auth.getPrincipal();
        // return "Hello livInDakr "+customUserDetails.getNom();
          
		
		HashMap<String, Object> h = new HashMap<String, Object>();
		String location = env.getProperty("root.location.load");


		List<Institution>  institution = institutionrepository.findInstitutionByUser(customUserDetails);

		
		if(institution == null){
			
			h.put("message", " Cet utilisateur n'a pas d'institutions.");
			h.put("status", -1);
			return h;
			
		}else {
			
			h.put("message", "Les institutions de l'utilisateur sont : ");
			h.put("institution", institution);
			h.put("status", 0);
			h.put("urls", "http://"+location);
			return h;
			
		}
	}
	
	
	
	@RequestMapping(value="/listInstitutions", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Map<String,Object> ListInstitutions() {
		
		HashMap<String, Object> h = new HashMap<String, Object>();
		String location = env.getProperty("root.location.load");

		List<Institution>  institution = institutionrepository.findAll();
		
		if(institution == null){
			
			h.put("message", "Les institutions sont vides.");
			h.put("status", -1);
			return h;
			
		}else {
			
			h.put("message", "Les institutions sont : ");
			h.put("institution", institution);
			h.put("status", 0);
			h.put("urls", "http://"+location);
			return h;
			
		}
	}
	
	
	
	@RequestMapping(value="/listInstitutionsbySouscategoryNote/{idCategory}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Map<String,Object> listInstitutionsbySouscategoryNote(@PathVariable Category idCategory) {
		
		HashMap<String, Object> h = new HashMap<String, Object>();
		String location = env.getProperty("root.location.load");


		List<Institution>  institution = institutionrepository.findInstitutionByUserNoteCategory(idCategory);
		
		if (institution.size() == 0) {
			
			h.put("message", "Pas d'institutions.");
			h.put("status", -1);
			return h;
			
		}
			h.put("message", "Les institutions sont : ");
			h.put("institution", institution);
			h.put("status", 0);
			h.put("urls", "http://"+location);
			return h;	
					
			
		
	}
	
	
	
	/*
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String UploadFile(MultipartHttpServletRequest request) throws IOException {
       
        String message = "";
       
        try {
           
            
            Iterator<String> itr = request.getFileNames();
            String name ="";
           
            MultipartFile file = request.getFile(itr.next());
           
            String fileName = file.getOriginalFilename();
            Path p = Paths.get("upload-dir");
           
            //Files.copy(file.getInputStream(), p.resolve(file.getOriginalFilename()));
            File dir = new File("C:/spring/livindakar/livindakar/src/main/frontend/src/assets/images/evenements/");
            if (dir.isDirectory()) {
                File serverFile = new File(dir, fileName);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(file.getBytes());
                stream.close();
                name= serverFile.getAbsolutePath();
                JSONObject item = new JSONObject();
           
                item.put("message", name);
                message = item.toString();
            }
            else{
                JSONObject item = new JSONObject();
                name = "Ce dossier n'existe pas";
                item.put("message", name);
                message = item.toString();
            }
                //message = "You successfully uploaded " + file.getOriginalFilename() + "!";
                return message;
        } catch (Exception e) {
            JSONObject item = new JSONObject();
            String name = "FAIL to upload";
            try {
                item.put("message", name);
            }
           catch (Exception ex) {
               java.util.logging.Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
           }
            message = item.toString();
            return message;
        }
    }
 
	
	*/
	
	

	@RequestMapping(value="/upload/", method = RequestMethod.POST)
	public HashMap<String, Object> uploadEvent(MultipartHttpServletRequest requests) throws IOException {
		HashMap<String, Object> h = new HashMap<String, Object>();
		
		// JSONObject item = new JSONObject();
       
		HashMap<String, Object> img = imageInstitution.store(requests);
		/*
		h.put("message", "L'enregistrement de l'image est effective.");
		h.put("image_events", img);
		h.put("status", 0);
		return h;
		*/
        return img;
		
	}
	
	
	

}
