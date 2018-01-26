package qualshore.livindkr.main.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.thymeleaf.context.Context;
import qualshore.livindkr.main.configSecurity.SecurityConstant;
import qualshore.livindkr.main.email.EmailHtmlSender;
import qualshore.livindkr.main.email.EmailStatus;
import qualshore.livindkr.main.entities.User;
import qualshore.livindkr.main.models.MessageResult;
import qualshore.livindkr.main.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import java.awt.image.renderable.RenderableImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * Created by User on 09/01/2018.
 */

@Service
public class InscriptionService {

    public static final String TITLE  = "Liv'in Dakar";
    public static final String TEMPLATE  = "templatemail";
    public static final String TEMPLATEPASSWORD  = "templatepassword";
    private static List<MessageResult> results = new ArrayList<>();

    private BCryptPasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    @Autowired
    public InscriptionService(UserRepository userRepository , BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = bCryptPasswordEncoder;
    }

    public List<MessageResult> TraitementInscription(User user){
        List<MessageResult> results = new ArrayList<>();

        if(user.getPseudo() == null){
            return addMessage("pseudo","null");
        }

        try {
            User getUserByPseudo = userRepository.findByPseudo(user.getPseudo()).get();
            return addMessage("pseudo","existe pseudo");
        }catch (Exception e){}

        if(user.getEmail().equals(null)){
            return addMessage("pseudo","null");
        }

        User getUserByEmail = userRepository.findByEmail(user.getEmail());
        if(getUserByEmail != null){
            return addMessage("email","existe email");
        }

        if(user.getPassword()==null){
            return addMessage("password","vide");
        }

        return results;
    }

    public static List<MessageResult> addMessage(String message, String corps){
        results.add(new MessageResult(message,corps));
        return results;
    }

    public Context sendMailConfirmation(String token,String email){
        Context context = new Context();
        context.setVariable("title", "Validation compte");
        context.setVariable("description", "Lorem Lorem Lorem");
        context.setVariable("lien", token);
        context.setVariable("email", email);
        return context;
    }

    public static int CodeConfirmation(String id){

        int taille = id.length();
        if (taille < 6){
            return Integer.parseInt(id.concat((System.currentTimeMillis()+"").substring(0,6-taille)));
        }
        return Integer.parseInt(id);
    }

}
