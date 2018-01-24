package qualshore.livindkr.main.controllers;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.context.Context;
import qualshore.livindkr.main.configSecurity.SecurityConstant;
import qualshore.livindkr.main.email.EmailHtmlSender;
import qualshore.livindkr.main.email.EmailStatus;
import qualshore.livindkr.main.entities.User;
import qualshore.livindkr.main.entities.UserProfil;
import qualshore.livindkr.main.file.StorageService;
import qualshore.livindkr.main.models.MessageResult;
import qualshore.livindkr.main.repository.UserRepository;
import qualshore.livindkr.main.services.InscriptionService;

import javax.servlet.annotation.MultipartConfig;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static qualshore.livindkr.main.services.InscriptionService.*;

/**
 * Created by User on 09/01/2018.
 */

@RestController
public class InscriptionController {

    @Autowired
    private EmailHtmlSender emailHtmlSender;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    StorageService storageService;

    @Autowired
    private InscriptionService service;

    @PostMapping( name= "/inscription", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public MessageResult handleFileUpload(@RequestPart("user") User user, @RequestPart(name="file",required=false) MultipartFile file) {

        if(user.equals(null)){
            return new MessageResult("0",SecurityConstant.VIDE_USER);
        }

        List<MessageResult> results = service.TraitementInscription(user);

        if(results.size() != 0 ){
            return results.get(0);
        }
        String map = storageService.store(file,user);
        if(map.equals("") || map.equals("0")){
            user.setPhoto("avatar_defaut.png");
        }else{
            user.setPhoto(map);
        }

        user.setIsActive(false);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setIdUserProfil(new UserProfil(1));
        user.setActivationToken(0);
        userRepository.save(user);

        if(user.getIdUser() != null){
            user.setActivationToken(CodeConfirmation(user.getIdUser().toString()));
            userRepository.save(user);
        }

        if(sendEmail(user.getActivationToken().toString(), user.getEmail()).isError()){
            return new MessageResult("1", SecurityConstant.EREREUR_EMAIL);
        }
        return new MessageResult("2",SecurityConstant.INSCRIPTIONMSM);
    }

    private EmailStatus sendEmail(String code,String email){
        String token = Jwts.builder()
                .setSubject(code)
                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstant.EXPIRATION_TIME ))
                .signWith(SignatureAlgorithm.HS512, SecurityConstant.SECRET.getBytes())
                .compact();

        Context context = service.sendMailConfirmation(token);
        EmailStatus emailStatus = emailHtmlSender.send(email,TITLE,TEMPLATE,context);

        return emailStatus;
    }

    @GetMapping("/ConfirmationEmail")
    public MessageResult ConfirmationEmail(@RequestParam("token") String token){
        String code = Jwts.parser()
                .setSigningKey(SecurityConstant.SECRET.getBytes())
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        User user = userRepository.findByActivationToken(Integer.parseInt(code));
        try {
            user.setIsActive(true);
            userRepository.save(user);
            return new MessageResult("update", "Compte activé");
        }catch (Exception e){
            return new MessageResult("erreur","Code n'existe pas");
        }
    }

    @GetMapping("/verifierPseudo/{pseudo}")
    public MessageResult verifierPseudo(@PathVariable("pseudo") String pseudo){
        try {
            User getUserByPseudo = userRepository.findByPseudo(pseudo).get();
            return new MessageResult("status","0");
        }catch (Exception e){
            return new MessageResult("status","1");
        }
    }

    @GetMapping("/verifierEmail/{email}/{staus")
    public MessageResult verifierEmail(@PathVariable("email") String email, @PathVariable(name="status", required = false) Integer status){
        try {
            User getUserByEmail = userRepository.findByEmail(email);
                if(getUserByEmail == null){
                    return new MessageResult("status","1");
                }
                if(status.equals(1)){
                    EmailStatus emailStatus = sendEmail(getUserByEmail.getActivationToken().toString(),getUserByEmail.getEmail());
                    if(emailStatus.isError()){
                        return new MessageResult("status", "2");
                    }
                    return new MessageResult("status", "3");
                }
            return new MessageResult("status","0");
        }catch (Exception e){
            return new MessageResult("status","1");
        }
    }
}
