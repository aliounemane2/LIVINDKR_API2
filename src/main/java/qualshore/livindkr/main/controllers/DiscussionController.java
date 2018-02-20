package qualshore.livindkr.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qualshore.livindkr.main.entities.Message;
import qualshore.livindkr.main.entities.User;
import qualshore.livindkr.main.repository.DiscussionRepository;
import qualshore.livindkr.main.services.ServiceUser;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by User on 14/02/2018.
 */

@RestController
@RequestMapping("/chat")
public class DiscussionController {

  @Autowired
  DiscussionRepository dr;

  @Autowired
  ServiceUser userConnecter;

  @Description("L'obtention des messages envoyes et recus par un administrateur")
  @GetMapping("/mesMessage")
  public List<Message> MesMessages() throws ExecutionException, InterruptedException {

    CompletableFuture<List<Message>> mesMessages = dr.findByIdEnvoyeur(50);
    return mesMessages.get();
  }
}
