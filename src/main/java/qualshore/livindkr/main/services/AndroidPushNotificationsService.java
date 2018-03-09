package qualshore.livindkr.main.services;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AndroidPushNotificationsService {
	
	// private static final String FIREBASE_SERVER_KEY = "AAAAU2Ka6WQ:APA91bHBSFtKweIEke9gJw2zKTiz2qcdSU4GsjoGYASntao3Jk_njQMkRu3A09WHj6Ykz2XwzcrPp1lPM5u4QvawCjByk3OardNWXhsG8oNqBC32hVDKZLwak8DZ7wu1r16LIb0pgwKs";
	// private static final String FIREBASE_SERVER_KEY = "AIzaSyCgQIx5LtwALH3ctsIkqkKo-f8n2PpdVfE";
	
	private static final String FIREBASE_SERVER_KEY = "AIzaSyDrKmcEtAHQrml921d0ji4-KBSMvCejIb4";
	

	private static final String FIREBASE_API_URL = "https://fcm.googleapis.com/fcm/send";

	@Async
	public CompletableFuture<String> send(HttpEntity<String> entity) {
 
		RestTemplate restTemplate = new RestTemplate();
 
		/**
		https://fcm.googleapis.com/fcm/send
		Content-Type:application/json
		Authorization:key=FIREBASE_SERVER_KEY*/
 
		ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors.add(new HeaderRequestInterceptor("Authorization", "key=" + FIREBASE_SERVER_KEY));
		interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json"));
		restTemplate.setInterceptors(interceptors);
 
		String firebaseResponse = restTemplate.postForObject(FIREBASE_API_URL, entity, String.class);
 
		return CompletableFuture.completedFuture(firebaseResponse);
		
	}
	
}
