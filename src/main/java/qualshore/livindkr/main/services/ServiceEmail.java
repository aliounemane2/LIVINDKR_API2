package qualshore.livindkr.main.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import qualshore.livindkr.main.configSecurity.SecurityConstant;
import qualshore.livindkr.main.email.EmailHtmlSender;
import qualshore.livindkr.main.email.EmailStatus;
import qualshore.livindkr.main.entities.User;
import qualshore.livindkr.main.models.MessageResult;
import qualshore.livindkr.main.repository.UserRepository;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static qualshore.livindkr.main.services.InscriptionService.TEMPLATEPASSWORD;
import static qualshore.livindkr.main.services.InscriptionService.TITLE;

/**
 * Created by User on 07/02/2018.
 */
@Service
public class ServiceEmail {

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  @Autowired
  EmailHtmlSender emailHtmlSender;

  @Autowired
  InscriptionService service;

  @Autowired
  UserRepository userRepository;

  @Autowired
  public ServiceEmail(InscriptionService service, EmailHtmlSender emailHtmlSender){
    this.service = service;
    this.emailHtmlSender = emailHtmlSender;
  }

  public MessageResult updatepassword(String email, String oldpassword, String password, String type)
  {
    User user = userRepository.findByEmail(email);
    if(user == null){
      return new MessageResult("status", "0");
    }

    if(!passwordEncoder.matches(oldpassword,user.getPassword())){
      return new MessageResult("Old password incorrecte", "4");
    }

    if(type != null && type.equals("mobile")){
      user.setPassword(passwordEncoder.encode(password));
      userRepository.save(user);
      return new MessageResult("status", "1");
    }
  CompletableFuture<EmailStatus> future = sendEmail(password,email,TEMPLATEPASSWORD,0,"");
      try {
          if(future.get().isError()){
            return new MessageResult(SecurityConstant.EREREUR_EMAIL1, "2");
          }
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
          return new MessageResult(SecurityConstant.SEND_EMAIL, "1");
  }

  public CompletableFuture<EmailStatus> sendEmail(String code, String email, String template, Integer type, String email1){
    String token = type == 1 ? code : setToken(code);
    Context context = service.sendMailConfirmation(token,email,email1);
    CompletableFuture<EmailStatus> emailStatus = null;
    try {
      emailStatus = emailHtmlSender.send(email,TITLE,template,context);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return emailStatus;
  }

  public String setToken(String token){
    return Jwts.builder().setSubject(token).signWith(SignatureAlgorithm.HS512, SecurityConstant.SECRETE.getBytes()).compact();
  }

  public String getToken(String token){
    //return Jwts.parser().parsePlaintextJws(token.endsWith(".") ? token : token.concat(".")).toString();
    return Jwts.parser().setSigningKey(SecurityConstant.SECRETE.getBytes())
      .parseClaimsJws(token)
      .getBody().getSubject();
  }
}
