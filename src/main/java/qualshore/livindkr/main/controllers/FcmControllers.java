package qualshore.livindkr.main.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.minidev.json.JSONObject;
import qualshore.livindkr.main.entities.Note;
import qualshore.livindkr.main.services.AndroidPushNotificationsService;

@RequestMapping("/send")
@RestController
public class FcmControllers {
	
	
	@Autowired
	AndroidPushNotificationsService androidPushNotificationsService;
	
	// private final String TOPIC = "JavaSampleApproach";

	
	@RequestMapping(value="/send2", method = RequestMethod.GET)
	public Map<String,Object> notes() {
		
		HashMap<String, Object> h = new HashMap<String, Object>();
		
		JSONObject body = new JSONObject();
		body.put("to", "fUp5uRQ-81k:APA91bHP32XH2YeE1iUJQ2xUyeseiQ3h0xc6YBHjOcctSYw6K5R5EaLJKcEinQAv0o7oufByy3JZf7m2CxtIzVNq64fqwi8DDAL-JmoKdI1UVpsjpevw6rfvN09PuD8gQ5DmMiHWtplTKWFKGuKFxrqmtsr_nZIrtg");
		body.put("priority", "high");
 
		JSONObject notification = new JSONObject();
		notification.put("title", "Notification");
		notification.put("body", "Happy Message!");
		
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
		h.put("status", 1); 
		
		return h;
		
	}
		
		
		
	@RequestMapping(value = "/send", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> send() throws JSONException, IOException {
		 
		JSONObject body = new JSONObject();
		body.put("to", "fUp5uRQ-81k:APA91bHP32XH2YeE1iUJQ2xUyeseiQ3h0xc6YBHjOcctSYw6K5R5EaLJKcEinQAv0o7oufByy3JZf7m2CxtIzVNq64fqwi8DDAL-JmoKdI1UVpsjpevw6rfvN09PuD8gQ5DmMiHWtplTKWFKGuKFxrqmtsr_nZIrtg");
		body.put("priority", "high");
 
		JSONObject notification = new JSONObject();
		notification.put("title", "Notification");
		notification.put("body", "Happy Message!");
		
		JSONObject data = new JSONObject();
		data.put("Key-1", "JSA Data 1");
		data.put("Key-2", "JSA Data 2");
 
		body.put("notification", notification);
		body.put("data", data);
 
/**
		{
		   "notification": {
		      "title": "JSA Notification",
		      "body": "Happy Message!"
		   },
		   "data": {
		      "Key-1": "JSA Data 1",
		      "Key-2": "JSA Data 2"
		   },
		   "to": "/topics/JavaSampleApproach",
		   "priority": "high"
		}
*/
 
		HttpEntity<String> request = new HttpEntity<>(body.toString());
		// String ss="cQqCurDZIsE:APA91bELL0fiOHDph0MZsFm4Rtdkq9fRshn45KE5UXrSr2wV3A8FO2hVddAdhGwmHhz7zu8BcsUUxdenP7dYiHw98ZDpg7OdOb31alntB46lokNq99NbTG1YQVwcYmUzlkxqeZqyuEpc";
		CompletableFuture<String> pushNotification = androidPushNotificationsService.send(request);
		CompletableFuture.allOf(pushNotification).join();
 
		try {
			String firebaseResponse = pushNotification.get();
			
			return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
 
		return new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);
	}
}
