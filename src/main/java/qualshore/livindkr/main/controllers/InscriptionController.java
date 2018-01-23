package qualshore.livindkr.main.controllers;

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

        Context context = service.sendMailConfirmation(user);
        EmailStatus emailStatus = emailHtmlSender.send(user.getEmail(),TITLE,TEMPLATE,context);

        if(emailStatus.isError()){
            return new MessageResult("1", SecurityConstant.EREREUR_EMAIL);
        }

        return new MessageResult("2",SecurityConstant.INSCRIPTIONMSM);
    }


    @GetMapping("/ConfirmationEmail")
    public MessageResult ConfirmationEmail(@RequestParam("code") String code){
        String code1 = "";
        passwordEncoder.matches(code1, code);
        User user = userRepository.findByActivationToken(Integer.parseInt(code1));
        if(user.equals(null)){
            return new MessageResult("erreur","Code n'existe pas");
        }
        user.setIsActive(true);
        userRepository.save(user);
        return new MessageResult("update", "Compte activé");
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

    @GetMapping("/verifierEmail/{email}")
    public MessageResult verifierEmail(@PathVariable("email") String email){
        try {
            User getUserByEmail = userRepository.findByEmail(email);
                if(getUserByEmail == null){
                    return new MessageResult("status","1");
                }
            return new MessageResult("status","0");
        }catch (Exception e){
            return new MessageResult("status","1");
        }
    }
}
