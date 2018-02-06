package qualshore.livindkr.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import qualshore.livindkr.main.entities.User;
import qualshore.livindkr.main.models.MessageResult;
import qualshore.livindkr.main.repository.UserRepository;
import qualshore.livindkr.main.services.ServiceMessage;

import java.util.HashMap;
import java.util.Optional;

/**
 * Created by User on 01/02/2018.
 */
@RestController
public class EditUser {

  @Autowired
  UserRepository userRepository;

  @Autowired
  ServiceMessage message;

  @PostMapping("/updateUser")
  public HashMap<String, Object> updateUser(@RequestBody User user){
        User user1 = new User();
    try {
          if(user.getIdUser() == null){
            user1 = getUser(user.getPseudo());
              if(user1 != null){
                user1.setNom(user.getNom());
                user1.setPrenom(user.getPrenom());
                user1.setTelephone(user.getTelephone());
                user1.setDateNaissance(user.getDateNaissance());
              }
          }else { user1 = user; }
          userRepository.save(user1);
          message.SetMessage("status",0);
          message.SetMessage("user",user);

    }catch (Exception e){
          message.SetMessage("status",1);
    }
    return message.getMessage();
  }

  @GetMapping("/userConnect/{pseudo}")
  public HashMap<String, Object> getUserConnect(@PathVariable("pseudo") String pseudo){
    message.SetMessage("user", getUser(pseudo));
    return message.getMessage();
  }

  public User getUser(String pseudo){
    Optional<User> usersOptional = userRepository.findByPseudo(pseudo);
    return usersOptional == null ? null : usersOptional.get();
  }

}
