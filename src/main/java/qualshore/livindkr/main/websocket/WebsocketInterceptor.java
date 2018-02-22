package qualshore.livindkr.main.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import qualshore.livindkr.main.entities.Message;
import qualshore.livindkr.main.entities.User;
import qualshore.livindkr.main.models.CustomUserDetails;
import qualshore.livindkr.main.repository.DiscussionRepository;
import qualshore.livindkr.main.services.ServiceUser;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by User on 14/02/2018.
 */

@Controller
public class WebsocketInterceptor {

  @Autowired
  SimpMessagingTemplate template;

  @Autowired
  DiscussionRepository discussionRepository;

  @Autowired
  ServiceUser user;

  @MessageMapping("/chat.sendMessage")
  @SendTo("/livindkr/public")
  public void onReceiveMessage(@Payload Message message){
    CustomUserDetails user1 = user.getUserConnecter();
    String urlUser = "/livindkr/basdia";
    this.template.convertAndSend(urlUser,message);
    //return message;
  }

  @MessageMapping("/initialize")
  @SendTo("/livindkr/public")
  public List<Message> onRegister(@Payload String message){

    CompletableFuture<List<Message>> messages = discussionRepository.findByIdEnvoyeur(50);
    try {
      return messages.get();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }

    return null;
  }

}
