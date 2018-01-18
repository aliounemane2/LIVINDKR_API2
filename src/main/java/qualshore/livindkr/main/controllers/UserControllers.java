 package qualshore.livindkr.main.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.util.StreamUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import qualshore.livindkr.main.entities.Category;
import qualshore.livindkr.main.entities.Interest;
import qualshore.livindkr.main.entities.User;
import qualshore.livindkr.main.entities.UsersInterests;
import qualshore.livindkr.main.repository.InterestRepository;
import qualshore.livindkr.main.repository.UserRepository;
import qualshore.livindkr.main.repository.Users_Interests_Repository;
import qualshore.livindkr.main.models.*;



import java.util.Random;


// @Controller("/users")
@RequestMapping("/users")
@RestController
public class UserControllers {

	@Autowired
	private UserRepository userrepository;
	
	
	@Autowired
	private InterestRepository interestrepository;
	
	@Autowired
	private Users_Interests_Repository userIntRepository;
	
	
	@Value("${dir.images}")
	private String imageDir;
	
	
	@RequestMapping(value="/home")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/insert_user", method = RequestMethod.POST)
	
	/*
	 public ResponseEntity<String> saveUser(User user) {
		// User user =  new User ();
		userrepository.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	*/
	
	public User saveUser(@RequestBody User user) {
		// User u;
		return userrepository.save(user);
		
		 // user;
		// return u;
		// return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	
	
	@RequestMapping(value = "/inscription_user", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public Map<String,Object> inscription_user(@RequestBody User user) {
		HashMap<String, Object> h = new HashMap<String, Object>();
		
		if(user == null){
			
			h.put("message", "paramètres vides.");
			h.put("status", -1);
			return h;
			
		}else if (userrepository.findByTelephone(user.getTelephone()).size() != 0) {
			
			h.put("message", "Ce numéro de téléphone existe déjà en base.");
			h.put("status", -2);	
			return h;
			
		}else if (userrepository.findByEmail(user.getEmail()) != null){
			
			h.put("message", "Cet Email existe déjà en base.");
			h.put("status", -3);	
			return h;
		}else if (userrepository.findByPseudos(user.getPseudo()) != null) {			
			
			h.put("message", "Ce Pseudo existe déjà en base.");
			h.put("status", -4);	
			return h;
		}else {
		
			try{
				// commission.setTauxJourIdTauxJour(rateDay);
				
				Random rand = new Random();
				int  n = rand.nextInt(10000) + 1;
				
				System.out.println(" CODE DE VALIDATION "+n);
				user = userrepository.save(user);
				
				
			}catch (Exception e) {
				e.printStackTrace();
				h.put("message", "Oups, une erreur a été détectée \""+e.getMessage()+"\" ... veuillez enregistrer à nouveau contacter le support.");
				h.put("status", 1);
				return h;
			}
			h.put("user", user);
			h.put("message", "Utilisateur a été enregistre avec succès");
			h.put("status", 0);
			return h;
			}
	}
	
	
	


	
	
	@RequestMapping(value = "/inscription_interest/{idUser}", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public Map<String,Object> inscription_interest(@RequestBody Users_Interests_Model user, @PathVariable Integer idUser) {

		HashMap<String, Object> h = new HashMap<String, Object>();
		
		List<Integer> idInterests = user.getInterests();
		Integer id_users = user.getIdUsers();
		User userss = userrepository.findByIdUser(idUser);
		
		if(userss == null){
			
			h.put("message", "paramètres vides.");
			h.put("status", -1);
			return h;
			
		}else {
			
			List<UsersInterests> users_interests = new ArrayList<>();
			idInterests.forEach(id->{
				
				Interest interest = interestrepository.findByIdInterest(id);
				if(interest != null) {
					UsersInterests userInt = new UsersInterests();
					userInt = userss.addUsersInterests(interest);
					try {
						userIntRepository.saveAndFlush(userInt);
						users_interests.add(userInt);
					} catch (Exception e) {
						e.printStackTrace();
						h.put("message", "Oups, une erreur a été détectée \""+e.getMessage()+"\" ... veuillez réessayer ou contacter le support.");
						h.put("status", -1);
					}

				}
		});
	}
		h.put("status", 0);
		h.put("message", "L'enregistrement en base est effective.");
		return h;

	}
	
	

	@RequestMapping(value="/list_interest/{id}", method=RequestMethod.GET)
	public HashMap<String, Object> getUserByInterests(@PathVariable Integer id){
		
		HashMap<String, Object> h= new HashMap<String, Object>();
		
		// Interest interests = interestrepository.findOne(id);
		User user = userrepository.findByIdUser(id);
		if (user == null) {
			h.put("message", "Les centres d'interets n'existe pas.");
			h.put("status", -1);
			return h;
		}
		
		List<UsersInterests> userInterest = userIntRepository.findByInterestByUser(user.getIdUser());
		h.put("message", "success");
		h.put("Interests", userInterest);
		h.put("status", 0);
		return h;
	}
	
	
	
	@RequestMapping(value = "/tests/{id}", method = RequestMethod.GET)
    public HashMap<String, Object> testsInterests(@PathVariable Integer id) {
		
		HashMap<String, Object> h= new HashMap<String, Object>();
		
        User user = userrepository.findByIdUser(id);

        if (user == null) {
	        
        	h.put("message", "innexistant");
	    		h.put("status", 0);
	    		return h; 
	    		
        }else {
	        
	    		List<UsersInterests> u = userIntRepository.findByInterestByUser(id); 
	    		h.put("message", "coool");
	    		h.put("status", 0);
	    		h.put("cc", u);
        	
        }
		return h; 
    }
	
	
	
	
	@RequestMapping(value = "/validation_code/{idUser}/{activation_token}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public Map<String,Object> validation_code(@PathVariable("idUser") Integer idUser,@PathVariable("activation_token") int activation_token, @RequestBody User user) {
		HashMap<String, Object> h = new HashMap<String, Object>();

		System.out.println("Updating User " + idUser);
		
		user = userrepository.findByIdUser(idUser);
		if (user == null) {
			h.put("message", "Cet utilisateur n'existe pas en base de donnée.");
			h.put("status", -1);
			return h;
			
		}else if(user.getActivationToken()==activation_token){
			
			
			System.out.println(" BON CODE DE VALIDATION "+user);
			user.setActivationToken(0);
			user.setIsActive(true);
			userrepository.save(user);
			
			h.put("message", "Utilisateur bon");
			h.put("status", 0);
			h.put("user", user);
			
			return h;
				
			// TODO: handle exception
			/*
			h.put("message", "Echec de l'activation du compte, veuillez saisir le code envoyé par SMS.");
			h.put("status", 1);
			return h;
			*/
				
		}
		return h;

		
	}
	
	
	
	@RequestMapping(value = "/complements_info/{idUser}/{nom}/{prenom}/{password}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public Map<String,Object> validation_code(@PathVariable("idUser") Integer idUser, @PathVariable("nom") String nom, @PathVariable("prenom") String prenom, @PathVariable("password") String password, @RequestBody User user) {
		
		HashMap<String, Object> h = new HashMap<String, Object>();
		
		System.out.println("Updating User " + idUser);
		
		user = userrepository.findByIdUser(idUser);
		if (user == null) {
			h.put("message", "Cet utilisateur n'existe pas en base de donnée.");
			h.put("status", -1);
			return h;
		}else{
			
			try {
				user.setNom(nom);
				user.setPrenom(prenom);
				user.setPassword(password);
				userrepository.save(user);
				
				h.put("message", "Votre profil a été bien pris en compte.");
				h.put("status", 0);
				h.put("user", user);
				
				return h;
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				h.put("message", "Echec de l’enregistrement. Veuillez réessayer.");
				h.put("status", 1);
				return h;
				
			}
			
		}
				
	}
	
	
	
	
	@RequestMapping(value = "/authentification/{pseudo}/{password}", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public Map<String,Object> authentification(@PathVariable("pseudo") String pseudo, @PathVariable("password") String password, @RequestBody User user) {
		
		HashMap<String, Object> h = new HashMap<String, Object>();
		
		System.out.println("Updating User " + pseudo);
		System.out.println("Updating User " + password);
		
		
		// user = userrepository.findByPseudo(pseudo);
		//  @RequestBody User user
		if(user == null){
			
			h.put("message", "paramètres vides.");
			h.put("status", -1);
			return h;
			
		}else if (userrepository.findByTelephone(user.getTelephone()).size() != 0) {
			
		}
		return h;		
	}
	
	
	
	@RequestMapping(value = "/forget_password/{email}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public Map<String,Object> forget_password(@PathVariable("email") String email, @RequestBody User user) {
		
		HashMap<String, Object> h = new HashMap<String, Object>();
		
		user = userrepository.findByEmail(email);
		//  @RequestBody User user
		if(user == null){
			
			h.put("message", "Cet utilisateur n'existe pas en base.");
			h.put("status", -1);
			return h;
			
		}else {
			
			Random rand = new Random();
			int  n = rand.nextInt(10000000) + 1;
			
			user.setPassword(""+n);
			userrepository.save(user);
			return h;		

		}
	}
	
	
	
	@RequestMapping(value="/list_users", method = RequestMethod.GET)
	public Map<String,Object> users() {
		
		List<User> user = userrepository.findAll();
		HashMap<String, Object> h = new HashMap<String, Object>();
		
		
		if (user.size() == 0) {
			
			h.put("message", "La liste des utilisateurs est vide.");
			return h;
			
		}else {
			
			h.put("user", user);
			h.put("message", "La liste des utilisateurs est :");
			return h;
		
		}
	}
	
	
	@RequestMapping(value = "/modify_image/{idUser}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public Map<String,Object> modify_image(@RequestParam(name="photo") MultipartFile file,@PathVariable("idUser") Integer idUser, User user) throws Exception {
		
		HashMap<String, Object> h = new HashMap<String, Object>();
		
		user = userrepository.findByIdUser(idUser);
		
		if (user == null) {
			h.put("message", "Utilisateur inexistant.");

			
		}else {
			
			if (!(file.isEmpty())) {
				user.setPhoto(file.getOriginalFilename());
				// file.transferTo(new File("/users/"));
				// file.transferTo(new File(System.getProperty("user.home")));
				// file.transferTo(new File(imageDir));
				// file.transferTo(new File(System.getProperty("user.home")+file.getOriginalFilename()));
				// file.transferTo(new File(System.getProperty(imageDir)+file.getOriginalFilename()));
				file.transferTo(new File(imageDir+file.getOriginalFilename()));




			}
			userrepository.save(user);
			
			h.put("message", "L'enregistrement de la photo est effective.");
			h.put("user", user);
			
		}
		
		

		
		return h;
	}
	
	/*
	
	@RequestMapping(value = "/getPhoto_image/", produces = MediaType.IMAGE_JPEG_VALUE, method = RequestMethod.GET)
	@ResponseBody
	public byte[] getPhoto (Long id) throws Exception{
		File f = new File(imageDir+id) ;
		// return IOUtils.toByteArray(new FileInputStream(f));
		//  return IOUtils.
		
	}
	
	*/
	
	/*
	 * Bon aussi 
	@RequestMapping(value = "/sid", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    public void getImage(HttpServletResponse response) throws IOException {

        ClassPathResource imgFile = new ClassPathResource("image/sid.jpg");

        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
    }
	
	*/
	
	@RequestMapping(value = "/sid", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage() throws IOException {

        ClassPathResource imgFile = new ClassPathResource("image/sid.jpg");
        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(bytes);
    }
	
}
