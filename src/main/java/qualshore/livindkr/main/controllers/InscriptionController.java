package qualshore.livindkr.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.context.Context;
import qualshore.livindkr.main.email.EmailHtmlSender;
import qualshore.livindkr.main.email.EmailStatus;
import qualshore.livindkr.main.entities.User;
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

    private InscriptionService service = new InscriptionService(userRepository, passwordEncoder);

    @PostMapping( name= "/inscription", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<User> handleFileUpload(@RequestPart("user") User user, @RequestPart("file") MultipartFile file) {

        HashMap<Integer, String> map = storageService.store(file,user);

        if(!map.isEmpty()){
            System.out.print(map);
        }

        if(user.equals(null)){
            return ResponseEntity.status(0).eTag("objet vide").build();
        }

        List<MessageResult> results = service.TraitementInscription(user);

        if(results.size() == 0 ){
            user.setActivationToken(CodeConfirmation(user.getIdUser().toString()));
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        }

        Context context = service.sendMailConfirmation(user);
        EmailStatus emailStatus = emailHtmlSender.send(user.getEmail(),TITLE,TEMPLATE,context);

        if(emailStatus.isError()){
            return ResponseEntity.status(1).eTag("Erreur d'envoi").build();
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping("/ConfirmationEmail/{code}")
    public MessageResult ConfirmationEmail(@PathVariable int code){
        User user = userRepository.findByActivationToken(code);
        if(user.equals(null)){
            return new MessageResult("erreur","Code n'existe pas");
        }
        user.setIsActive(true);
        userRepository.save(user);
        return new MessageResult("update", "Compte activé");
    }
}
