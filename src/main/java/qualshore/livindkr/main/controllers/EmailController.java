package qualshore.livindkr.main.controllers;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.thymeleaf.context.Context;
import qualshore.livindkr.main.configSecurity.SecurityConstant;
import qualshore.livindkr.main.email.EmailHtmlSender;
import qualshore.livindkr.main.email.EmailStatus;
import qualshore.livindkr.main.entities.User;
import qualshore.livindkr.main.services.InscriptionService;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import static qualshore.livindkr.main.services.InscriptionService.TEMPLATE;
import static qualshore.livindkr.main.services.InscriptionService.TITLE;

/**
 * Created by User on 10/01/2018.
 */

@RestController
public class EmailController {

    @PostMapping("/sendEmailf")
    public HashMap<String, Object> sendEmail(MultipartHttpServletRequest request) throws IOException {
        /*User user =new User();
        user.setEmail("roussibadiakhate@hotmail.fr");
        user.setIdUser(8888);
        Context context = sendMailConfirmation(user);
        EmailStatus emailStatus = emailHtmlSender.send(user.getEmail(),TITLE, "templates/email/templateEmail.html");
        return emailStatus;*/

        return null;
    }

}
