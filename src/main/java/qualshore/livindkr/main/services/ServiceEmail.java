package qualshore.livindkr.main.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import qualshore.livindkr.main.configSecurity.SecurityConstant;
import qualshore.livindkr.main.email.EmailHtmlSender;
import qualshore.livindkr.main.email.EmailStatus;

import java.util.concurrent.CompletableFuture;

import static qualshore.livindkr.main.services.InscriptionService.TITLE;

/**
 * Created by User on 07/02/2018.
 */
@Service
public class ServiceEmail {

  @Autowired
  EmailHtmlSender emailHtmlSender;

  @Autowired
  InscriptionService service;

  @Autowired
  public ServiceEmail(InscriptionService service, EmailHtmlSender emailHtmlSender){
    this.service = service;
    this.emailHtmlSender = emailHtmlSender;
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
