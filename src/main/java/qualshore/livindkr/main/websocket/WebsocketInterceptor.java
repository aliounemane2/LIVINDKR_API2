package qualshore.livindkr.main.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by User on 14/02/2018.
 */

@Controller
public class WebsocketInterceptor {

  @MessageMapping("/chat.sendMessage")
  @SendTo("/livindkr/public")
  public String onReceiveMessage(@Payload String message){
    //this.template.convertAndSend("/chat",new SimpleDateFormat("hh:mm:ss").format(new Date()+" -"+message));
    return message+"-"+new SimpleDateFormat("hh:mm:ss").format(new Date());
  }

}
