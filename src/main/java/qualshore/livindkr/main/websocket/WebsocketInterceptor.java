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
import qualshore.livindkr.main.repository.UserRepository;
import qualshore.livindkr.main.services.ServiceUser;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
  UserRepository user;


  @MessageMapping("/chat.sendMessage")
  public void onReceiveMessage(@Payload Message message){

    User user1 = getUser(message.getIdEnvoyeur().getIdUser(), message.getIdReceveur().getIdUser());
    String urlUser = "/livindkr/"+user1.getPseudo();

    message.setDateMessage(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
    discussionRepository.save(message);

    this.template.convertAndSend(urlUser,message);
  }

  public User getUser (int idenvoyeur, int idreceveur){
    User us = user.findByIdUser(idenvoyeur);
    return us.getIdUserProfil().getNom().equals("ADMIN") ? us : user.findByIdUser(idreceveur);
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
