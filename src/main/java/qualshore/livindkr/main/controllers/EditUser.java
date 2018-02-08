package qualshore.livindkr.main.controllers;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.context.Context;
import qualshore.livindkr.main.configSecurity.SecurityConstant;
import qualshore.livindkr.main.email.EmailHtmlSender;
import qualshore.livindkr.main.email.EmailStatus;
import qualshore.livindkr.main.entities.User;
import qualshore.livindkr.main.file.StorageService;
import qualshore.livindkr.main.models.MessageResult;
import qualshore.livindkr.main.repository.UserRepository;
import qualshore.livindkr.main.services.InscriptionService;
import qualshore.livindkr.main.services.ServiceEmail;
import qualshore.livindkr.main.services.ServiceMessage;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static qualshore.livindkr.main.services.InscriptionService.*;

/**
 * Created by User on 01/02/2018.
 */
@RequestMapping("/user")
@RestController
public class EditUser {

  @Autowired
  StorageService storageService;

  @Autowired
  UserRepository userRepository;

  @Autowired
  ServiceMessage message;

  @Autowired
  EmailHtmlSender emailHtmlSender;

  @Autowired
  InscriptionService service;

  @Autowired
  ServiceEmail serviceEmail ;

  @PostMapping("/updateUser")
  public HashMap<String, Object> updateUser(@RequestBody User user){
        User user1;
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

  @PostMapping("/updatephoto")
  public HashMap<String, Object> updatephoto(@RequestPart("file")MultipartFile file, @RequestParam("pseudo") String pseudo, @RequestParam("type") Integer type){

    User user = getUser(pseudo);
    if(user == null){
      message.SetMessage("status", 0);
      return message.getMessage();
    }

    String map = storageService.store(file,user);
    if(!map.equals(user.getPhoto())){
      user.setPhoto(map.equals("") || map.equals("0") ? "avatar_defaut.png" : map);
      userRepository.save(user);
    }
    message.SetMessage("status","1");
    return message.getMessage();
  }

  @PostMapping("/updateemailconfirmation")
  public HashMap<String, Object> updateemailconfirmation(@RequestParam("code") String code, @RequestParam("emailold") String email, @RequestParam("emailnew") String email1){
    try {
      String token1 =  serviceEmail.getToken(code);
      User user = userRepository.findByActivationToken(Integer.parseInt(token1));
      if(user != null && user.getEmail().equals(email1)){
        user.setEmail(email);
        userRepository.save(user);
        message.SetMessage("status", 0);
        return message.getMessage();
      }
      if(user.getEmail().equals(email)){
        message.SetMessage("status",2);
        return message.getMessage();
      }
      message.SetMessage("status",1);
    }catch (Exception e){
      message.SetMessage("status",1);
    }
    return message.getMessage();
  }

  @PostMapping("/updateemail")
  public HashMap<String, Object> UpdateEmail(@RequestParam("pseudo") String pseudo, @RequestParam("emailold") String email, @RequestParam("emailnew") String email1){
      User user = getUser(pseudo);
      if(user == null){
        message.SetMessage("status", 0);
      }else{
        try {
          CompletableFuture<EmailStatus> future = serviceEmail.sendEmail(user.getActivationToken().toString(), email1,TEMPLATEUPDATEEMAIL, 0,email);
          if(future.get().isError()){
            message.SetMessage("status", 1);
          }
        } catch (Exception e) {
          message.SetMessage("status", 1);
        }
        message.SetMessage("status", 2);
      }
      return message.getMessage();
  }

  @PostMapping("/updatePassword")
  public MessageResult updatePassword(@RequestParam("email") String email, @RequestParam("password") String password,
                                      @RequestParam(name="oldpassword", required = false) String oldpassword,
                                      @RequestParam( name = "type", required = false) String type ){
      return serviceEmail.updatepassword(email, oldpassword,password, type);
  }

  public User getUser(String pseudo){
    Optional<User> usersOptional = userRepository.findByPseudo(pseudo);
    return usersOptional == null ? null : usersOptional.get();
  }

}
