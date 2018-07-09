package qualshore.livindkr.main.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import net.minidev.json.JSONObject;
import qualshore.livindkr.main.entities.CustomUserDetails;
import qualshore.livindkr.main.entities.Event;
import qualshore.livindkr.main.entities.EventPhoto;
import qualshore.livindkr.main.entities.Institution;
import qualshore.livindkr.main.entities.Note;
import qualshore.livindkr.main.entities.SousCategory;
import qualshore.livindkr.main.entities.User;
import qualshore.livindkr.main.repository.InstitutionRepository;
import qualshore.livindkr.main.repository.NotesRepository;
import qualshore.livindkr.main.services.AndroidPushNotificationsService;

@RequestMapping("/note")
@RestController
public class NoteControllers {
	
	@Autowired
	private NotesRepository noteRepository;
	
	
	@Autowired
	private InstitutionRepository insRep;
	
	
	@Autowired
	AndroidPushNotificationsService androidPushNotificationsService;
	
	private final String TOPIC = "JavaSampleApproach";

	
	@RequestMapping(value="/list_note_by_institution/{id}", method = RequestMethod.GET)
	public Map<String,Object> list_note_by_institution(@PathVariable Institution id) {
		HashMap<String, Object> h = new HashMap<String, Object>();

		
		List<Note>  note = noteRepository.findNoteByInstitution(id);
		
		if (note.size() == 0) {
			
			h.put("message", "La liste des notes en fonction de l'institution est vide.");
			h.put("status", -1);
			return h;
			
		}else {
			h.put("message", "La liste des notes en fonction de l'institution est :");
			h.put("notes", note);
			h.put("status", 0);
			System.out.println(" LA VALEUR DE LA NOTE ");
			System.out.println(" LA VALEUR DE LA NOTE ");
			System.out.println(" LA VALEUR DE LA NOTE ");
			System.out.println(note.get(0).getIdUser());


			return h;
			
		}			
	}

	
	@RequestMapping(value="/list_institution_souscategory/{id}", method = RequestMethod.GET)
	public Map<String,Object> sous_category(@PathVariable SousCategory id) {
		
		HashMap<String, Object> h = new HashMap<String, Object>();
		
		List<Note>  institution = noteRepository.findInstitutionBySousCategory(id);
		
		if (institution.size() == 0) {
			
			h.put("message", "La categorie n'existe pas.");
			return h;
			
		}
		
			h.put("message", "La liste des categories est :");
			h.put("sous_category", institution);
			return h;
		
	}
	
/*	
	@RequestMapping(value="/note", method = RequestMethod.POST)
	public Map<String,Object> notes(@RequestBody Note note) {
		
		HashMap<String, Object> h = new HashMap<String, Object>();
		User idUser;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) auth.getPrincipal();
        // return "Hello livInDakr "+customUserDetails.getNom();
        idUser = customUserDetails;
        note.setIdUser(idUser);
		
		Note ss = noteRepository.findInstitutionUser(note.getIdUser(), note.getIdInstitution());
		
		if (ss != null) {
			
			h.put("message", "L'utilisateur a deja donne une note a cette institution.");
			h.put("note", ss);
			return h;
		}
		
		Note s = noteRepository.save(note);
		
		h.put("message", "L'insertion est bon :");
		h.put("note", s);
		
		
		JSONObject body = new JSONObject();
		body.put("to", "cQqCurDZIsE:APA91bELL0fiOHDph0MZsFm4Rtdkq9fRshn45KE5UXrSr2wV3A8FO2hVddAdhGwmHhz7zu8BcsUUxdenP7dYiHw98ZDpg7OdOb31alntB46lokNq99NbTG1YQVwcYmUzlkxqeZqyuEpc");
		//body.put("to", ""+s.getIdUser().getFcmToken());
		body.put("priority", "high");
 
		JSONObject notification = new JSONObject();
		notification.put("title", "Notification");
		notification.put("body", ""+s.getIdUser().getPrenom()+" "+s.getIdUser().getNom()+"  a une note de "+s.getNote()+" "+s.getAvis());
		
		JSONObject data = new JSONObject();
		data.put("Key-1", "JSA Data 1");
		data.put("Key-2", "JSA Data 2");
 
		body.put("notification", notification);
		body.put("data", data);
		
		
		System.out.println(" LA VALEUR DE LA NOTE ");

		
		System.out.println(" ++++++ PUSH NOTIFICATION ++++++ ");
		System.out.println(" ++++++ PUSH NOTIFICATION ++++++ ");

		HttpEntity<String> request = new HttpEntity<>(body.toString());
		// String ss="cQqCurDZIsE:APA91bELL0fiOHDph0MZsFm4Rtdkq9fRshn45KE5UXrSr2wV3A8FO2hVddAdhGwmHhz7zu8BcsUUxdenP7dYiHw98ZDpg7OdOb31alntB46lokNq99NbTG1YQVwcYmUzlkxqeZqyuEpc";
		CompletableFuture<String> pushNotification = androidPushNotificationsService.send(request);
		CompletableFuture.allOf(pushNotification).join();
 
		try {
			System.out.println(" CEST BON CEST BON CEST BON CEST BON");
			String firebaseResponse = pushNotification.get();
			//new ResponseEntity<>(firebaseResponse, HttpStatus.OK);

			//h.put("ok", new ResponseEntity<>(firebaseResponse, HttpStatus.OK));
			//h.put("success", "cool");
			//System.out.println(h);
			return h;

			//return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
 
		//return new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);

		return h;				
	}
*/	
	
	
	
	@RequestMapping(value="/note", method = RequestMethod.POST)
	public Map<String,Object> notes(@RequestBody Note note) {
		
		HashMap<String, Object> h = new HashMap<String, Object>();
		User idUser;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) auth.getPrincipal();
        // return "Hello livInDakr "+customUserDetails.getNom();
        idUser = customUserDetails;
        note.setIdUser(idUser);
		
		Note ss = noteRepository.findInstitutionUser(note.getIdUser(), note.getIdInstitution());
		
		if (ss != null) {
			
			h.put("message", "L'utilisateur a deja donne une note a cette institution.");
			h.put("note", ss);
			return h;
		}
		
		Note s = noteRepository.save(note);
		
		h.put("message", "L'insertion est bon :");
		h.put("note", s);
		
		System.out.println(" Etape 1 ");
		System.out.println(" Etape 1 ");
		System.out.println(" Etape 1 ");		
		System.out.println(s.getIdUser());
		
		
		Institution insttttt = insRep.findUserByInstitutionsss(note.getIdInstitution().getIdInstitution());
		System.out.println("OK OK OK OK OK OK OK ");
		System.out.println("OK OK OK OK OK OK OK ");
		System.out.println(insttttt.getIdUser().getFcmToken());
		System.out.println(insttttt.getIdUser().getFcmToken());



		
		
		
		
		JSONObject body = new JSONObject();
		// body.put("to", "fUp5uRQ-81k:APA91bHP32XH2YeE1iUJQ2xUyeseiQ3h0xc6YBHjOcctSYw6K5R5EaLJKcEinQAv0o7oufByy3JZf7m2CxtIzVNq64fqwi8DDAL-JmoKdI1UVpsjpevw6rfvN09PuD8gQ5DmMiHWtplTKWFKGuKFxrqmtsr_nZIrtg");

		body.put("to", ""+insttttt.getIdUser().getFcmToken()+"");
		body.put("priority", "high");
 
		JSONObject notification = new JSONObject();
		notification.put("title", "Note");
		notification.put("body", s.getIdUser().getPrenom()+" "+s.getIdUser().getNom()+" vous a donne la note de "+s.getNote()+" "+s.getAvis());
		
		JSONObject data = new JSONObject();
		data.put("Key-1", "JSA Data 1");
		data.put("Key-2", "JSA Data 2");
 
		body.put("notification", notification);
		body.put("data", data);
		
		System.out.println(" Etape 2 ");
		System.out.println(data);
		System.out.println(data);




 
/*		try {
			 String androidFcmKey="AIzaSyDrKmcEtAHQrml921d0ji4-KBSMvCejIb4";
			   String androidFcmUrl="https://fcm.googleapis.com/fcm/send";
			   
				System.out.println(" Etape 2 ");
				System.out.println(" Etape 2 ");
				System.out.println(" Etape 2 ");


			   
			   RestTemplate restTemplate = new RestTemplate();
			   HttpHeaders httpHeaders = new HttpHeaders();
			   httpHeaders.set("Authorization", "key=" + androidFcmKey);
			   httpHeaders.set("Content-Type", "application/json");
			   JSONObject msg = new JSONObject();
			   JSONObject json = new JSONObject();
			   
				System.out.println(" Etape 3 ");
				System.out.println(" Etape 3 ");
				System.out.println(" Etape 3 ");


			   
			   msg.put("title", "Title");
			   msg.put("body", "Message");
			   msg.put("notificationType", "Test");
			   
			   
			   System.out.println(" Etape 4 ");
			   System.out.println(" Etape 4 ");
			   System.out.println(" Etape 4 ");


			   json.put("data", msg);
			   json.put("to", "fUp5uRQ-81k:APA91bHP32XH2YeE1iUJQ2xUyeseiQ3h0xc6YBHjOcctSYw6K5R5EaLJKcEinQAv0o7oufByy3JZf7m2CxtIzVNq64fqwi8DDAL-JmoKdI1UVpsjpevw6rfvN09PuD8gQ5DmMiHWtplTKWFKGuKFxrqmtsr_nZIrtg");
			   
			   System.out.println(" Etape 5 ");
			   System.out.println(" Etape 5 ");
			   System.out.println(" Etape 5 ");


			   HttpEntity<String> httpEntity = new HttpEntity<String>(json.toString(),httpHeaders);
			   String response = restTemplate.postForObject(androidFcmUrl,httpEntity,String.class);
			   System.out.println(" Etape 6 ");
			   System.out.println(" Etape 6 ");
			   System.out.println(" Etape 6 ");


			   System.out.println(response);
				
			   h.put("bon ", "cooolll ");
			   
			   System.out.println(" Etape 7 ");
			   System.out.println(" Etape 7 ");
			   System.out.println(" Etape 7 ");


			   return h;
			//return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
 */
		
			
		HttpEntity<String> request = new HttpEntity<>(body.toString());
		
		System.out.println(" Etape 3");
		System.out.println(" Etape 3");
		System.out.println(request);


		// String ss="cQqCurDZIsE:APA91bELL0fiOHDph0MZsFm4Rtdkq9fRshn45KE5UXrSr2wV3A8FO2hVddAdhGwmHhz7zu8BcsUUxdenP7dYiHw98ZDpg7OdOb31alntB46lokNq99NbTG1YQVwcYmUzlkxqeZqyuEpc";
		CompletableFuture<String> pushNotification = androidPushNotificationsService.send(request);
		CompletableFuture.allOf(pushNotification).join();
		
		System.out.println(" Etape 4");
		System.out.println(pushNotification);


 
		try {
			String firebaseResponse = pushNotification.get();
			h.put("fcm", firebaseResponse);

			
			System.out.println(" Etape 5");
			System.out.println(" Etape 5");
			System.out.println(firebaseResponse);


			
			//new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
			System.out.println(new ResponseEntity<>(firebaseResponse, HttpStatus.OK));
			System.out.println(" Etape 6");
			System.out.println(" Etape 6");
			return h;




		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		System.out.println(" Etape 7");
		System.out.println(" Etape 7");


		//new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);
		System.out.println(" Etape 8");
		System.out.println(" Etape 8");
		System.out.println();


	//}

		return h;				
	}
	
	
	
	@RequestMapping(value="/note_by_user/", method = RequestMethod.GET)
	public Map<String,Object> notebyUser(User idUser) {
		
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) auth.getPrincipal();
        // return "Hello livInDakr "+customUserDetails.getNom();
        idUser = customUserDetails;
        
		HashMap<String, Object> h = new HashMap<String, Object>();
		List<Note> s = noteRepository.findNoteByUser(idUser);
		
		if (s.size() == 0) {
			h.put("status", -1);
			h.put("message", "L'utilisateur n'a pas de note.");
			return h;	
		}
			h.put("message", "La note de l'utilisateur est :");
			h.put("note", s);
			h.put("status",0);
			return h;
		
	}
	
	
	@RequestMapping(value="/update_note/{idnote}/{note}/{texte}/", method = RequestMethod.PUT)
	public Map<String,Object> notes(@PathVariable Integer idnote, @PathVariable Integer note, @PathVariable String texte) {
		
		HashMap<String, Object> h = new HashMap<String, Object>();
		User idUser;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) auth.getPrincipal();
        // return "Hello livInDakr "+customUserDetails.getNom();
        idUser = customUserDetails;
        
        
        Note notesss = noteRepository.findByIdNote(idnote);
        notesss.setAvis(texte);
        notesss.setNote(note);
        noteRepository.saveAndFlush(notesss);
		
		if (notesss != null) {
			
			h.put("message", "L'utilisateur n'a pas de note pour cette institution.");
			h.put("note", notesss);
			h.put("status", -1);
		}
		
		
		
		h.put("message", "La mise a jour est effective :");
		h.put("note", notesss);
		h.put("status", 0);

		return h;	
					
	}
	
	
}
