package qualshore.livindkr.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import qualshore.livindkr.main.entities.User;
import qualshore.livindkr.main.models.MessageResult;
import qualshore.livindkr.main.repository.UserRepository;

/**
 * Created by User on 01/02/2018.
 */
@RestController
public class EditUser {

  @Autowired
  UserRepository userRepository;

  @PostMapping("/updateUser")
  public int updateUser(@RequestBody User user){
    try {
      userRepository.save(user);
      return 0;
    }catch (Exception e){
      return 1;
    }
  }
}
