package qualshore.livindkr.main.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.minidev.json.JSONObject;
import qualshore.livindkr.main.entities.CustomUserDetails;
import qualshore.livindkr.main.entities.Event;
import qualshore.livindkr.main.entities.Interest;
import qualshore.livindkr.main.entities.InterestsEvents;
import qualshore.livindkr.main.entities.User;
import qualshore.livindkr.main.entities.UsersInterests;
import qualshore.livindkr.main.models.Interests_Events_Model;
import qualshore.livindkr.main.repository.EventsRepository;
import qualshore.livindkr.main.repository.InterestRepository;
import qualshore.livindkr.main.repository.InterestsEventsRepository;
import qualshore.livindkr.main.repository.Users_Interests_Repository;
import qualshore.livindkr.main.services.AndroidPushNotificationsService;
import qualshore.livindkr.main.services.ImageStorageService;

@RequestMapping("/interestsEvents")
@RestController
public class InterestsEventsControllers {
	
	
	@Autowired
	private InterestsEventsRepository intEvenRep;
	
	
	@Autowired
	private EventsRepository evenRep;
	
	@Autowired
	private ImageStorageService imageEvent;
	
	@Autowired
	private Users_Interests_Repository usersIntRep;
	
	
	@Autowired
	AndroidPushNotificationsService androidPushNotificationsService;
	
	
	@Autowired
	private InterestRepository intRep;
	
	
	
	@RequestMapping(value="/saveInterestsEvents", method = RequestMethod.POST)
	public Map<String,Object> list_interests(@RequestBody Interests_Events_Model intEvM) {
		HashMap<String, Object> h = new HashMap<String, Object>();

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) auth.getPrincipal();
		User idUser;
		idUser = customUserDetails;
		
		Event event = new Event();
        InterestsEvents inter = new InterestsEvents();
        event.setNomEvent(intEvM.getNomEvent());
        event.setDescriptionEvent(intEvM.getDescriptionEvent());
        event.setDateEvent(intEvM.getDateEvent());
        event.setPhotoEvent(intEvM.getPhotoEvent());
        event.setIdInstitution(intEvM.getIdInstitution());
        event.setIdPlace(intEvM.getIdPlace());
        event.setIdCategory(intEvM.getIdCategory());
        event.setIdUser(customUserDetails);
        evenRep.save(event);
        
        inter.setIdInterest(intEvM.getIdInterest());
        inter.setIdEvent(event);
        inter.setHeureDebut(intEvM.getHeureDebut());
        inter.setHeureFin(intEvM.getHeureFin());
        intEvenRep.save(inter);
        

        h.put("message", "L'enregistrement des interets Events est effective:");
		h.put("interestsEvents", intEvM);
		h.put("status", 0);
		
		
		
		System.out.println(" LA VALEUR DE RETOUR ");
		System.out.println(" LA VALEUR DE RETOUR ");
		System.out.println(" LA VALEUR DE RETOUR ");
		Integer hhh = inter.getIdInterest().getIdInterest();
		System.out.println(hhh);
		
		List<UsersInterests> usersInterests1 = usersIntRep.findByIdInterestsss(hhh); 
		System.out.println(" ADFDKDA ADLASKDSAD KNASKDASD ");
		System.out.println(" ADFDKDA ADLASKDSAD KNASKDASD ");
		System.out.println(" ADFDKDA ADLASKDSAD KNASKDASD ");
		System.out.println(" ADFDKDA ADLASKDSAD KNASKDASD ");
		System.out.println(usersInterests1);
		
		for (int i = 0; i < usersInterests1.size(); i++) {
			
			System.out.println(" wwwwwwwww 1111");
			System.out.println(usersInterests1.get(i).getUser().getNom()+" - "+usersInterests1.get(i).getUser().getPrenom());
			System.out.println(event.getNomEvent());
			System.out.println(" BAKHNA ");
			
			System.out.println(usersInterests1.get(i).getUser().getFcmToken());

			System.out.println(" wwwwwwwww 2222");
			
			if (usersInterests1.get(i).getUser().getFcmToken() == null) {
				System.out.println(" La valeur null "+i);
				System.out.println(" La valeur null "+i);

			}else {
				System.out.println("Valeur non null "+i);
				System.out.println("Valeur non null "+i);
				
				
				JSONObject body = new JSONObject();
				body.put("to", ""+usersInterests1.get(i).getUser().getFcmToken());
				body.put("priority", "high");
				System.out.println(" body ");
				System.out.println(body);

		 
				JSONObject notification = new JSONObject();
				notification.put("title", "Nouvel evenement");
				notification.put("body", " "+event.getNomEvent()+" ");
				
				JSONObject data = new JSONObject();
				data.put("Key-1", "JSA Data 1");
				data.put("Key-2", "JSA Data 2");
		 
				body.put("notification", notification);
				body.put("data", data);
				
				
				
				HttpEntity<String> request = new HttpEntity<>(body.toString());
				
				System.out.println(" Etape 3");
				System.out.println(" Etape 3");
				System.out.println(request);


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


		

				return h;
				
				
				

			}
			

		}
		

		return h;		
		
	}
	
	
	

}
