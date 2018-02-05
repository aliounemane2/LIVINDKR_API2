package qualshore.livindkr.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import qualshore.livindkr.main.entities.User;
import qualshore.livindkr.main.models.MessageResult;
import qualshore.livindkr.main.repository.UserRepository;
import qualshore.livindkr.main.services.ServiceMessage;

import java.util.HashMap;

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

    try {
          userRepository.save(user);
          message.SetMessage("status",0);
          message.SetMessage("user",user);

    }catch (Exception e){
          message.SetMessage("status",1);
    }
    return message.getMessage();
  }
}
