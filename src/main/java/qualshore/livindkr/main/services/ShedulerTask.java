package qualshore.livindkr.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by User on 20/02/2018.
 */
@Service
public class ShedulerTask {
  @Autowired
  private SimpMessagingTemplate template;

  // this will send a message to an endpoint on which a client can subscribe
  @Scheduled(fixedRate = 5000)
  public void trigger() {
    // sends the message to /topic/message
    this.template.convertAndSend("/linindkr/public", "Date: " + new Date());
  }

}
