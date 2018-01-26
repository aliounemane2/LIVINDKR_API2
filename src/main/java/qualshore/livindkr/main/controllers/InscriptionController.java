package qualshore.livindkr.main.controllers;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.dom4j.Text;
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

        if(sendEmail(user.getActivationToken().toString(), user.getEmail(),TEMPLATE).isError()){
            return new MessageResult("1", SecurityConstant.EREREUR_EMAIL);
        }
        return new MessageResult("2",SecurityConstant.INSCRIPTIONMSM);
    }

    private EmailStatus sendEmail(String code,String email, String template){
        String token = setToken(code);
        Context context = service.sendMailConfirmation(token,email);
        EmailStatus emailStatus = emailHtmlSender.send(email,TITLE,template,context);

        return emailStatus;
    }

    @PostMapping("/ConfirmationEmail")
    public MessageResult ConfirmationEmail(@RequestParam("code") String token){
        try {
            String token1 = getToken(token);
            User user = userRepository.findByActivationToken(Integer.parseInt(token1));
            if(user != null){
                user.setIsActive(true);
                userRepository.save(user);
                return new MessageResult("0", "Compte activé");
            }
            return new MessageResult("2","Code est incorrecte");
        }catch (Exception e){
            return new MessageResult("1","Code est incorrecte");
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

    @GetMapping("/verifierEmail/{email}/{status}")
    public MessageResult verifierEmail(@PathVariable("email") String email, @PathVariable(name="status", required = false) Integer status){
        try {
            User getUserByEmail = userRepository.findByEmail(email);
                if(getUserByEmail == null){
                    return new MessageResult("status","1");
                }
                if(status.equals(1)){
                    if(getUserByEmail.getIsActive() == true){
                        return new MessageResult("status", "4");
                    }
                    EmailStatus emailStatus = sendEmail(getUserByEmail.getActivationToken().toString(),getUserByEmail.getEmail(),TEMPLATE);
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

    @PostMapping("/updatePassword")
    public MessageResult updatePassword(@RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("id") int id){
        if(id == 0){
            EmailStatus emailStatus = sendEmail(password,email,TEMPLATEPASSWORD);
            if(emailStatus.isError()){
                return new MessageResult("status", "2");
            }
            return new MessageResult("status", "1");
        }
        try {
            User user = userRepository.findByEmail(email);
            if(user == null){
                return new MessageResult("status", "0");
            }
            String passwordUpdate = getToken(password);
            user.setPassword(passwordEncoder.encode(passwordUpdate));
            userRepository.save(user);
            return new MessageResult("status", "1");
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
        return new MessageResult("status", "0");
    }

    private String setToken(String token){
        return Jwts.builder().setSubject(token).signWith(SignatureAlgorithm.HS512, SecurityConstant.SECRETE.getBytes()).compact();
    }

    private String getToken(String token){
        //return Jwts.parser().parsePlaintextJws(token.endsWith(".") ? token : token.concat(".")).toString();
        return Jwts.parser().setSigningKey(SecurityConstant.SECRETE.getBytes())
                .parseClaimsJws(token)
                .getBody().getSubject();
    }
}
