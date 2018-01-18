package qualshore.livindkr.main.email;

import org.slf4j.Logger;;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

/**
 * Created by User on 10/01/2018.
 */

@Service
public class EmailSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailSender.class);

    private JavaMailSender javaMailSender;

    @Autowired
    public EmailSender (JavaMailSender javaMailSender)
    {
        this.javaMailSender = javaMailSender;
    }

    public EmailStatus sendPlainText(String to, String subject, String text)
    {
        return sendM(to, subject, text, false);
    }

    public EmailStatus sendHtml(String to, String subject, String htmlBody) {
        return sendM(to, subject, htmlBody, true);
    }

    private EmailStatus sendM(String to, String subject, String text, Boolean isHtml) {
        try {
            System.setProperty("https.protocols", "TLS");
            //SimpleMailMessage mail = new SimpleMailMessage();
            MimeMessage helper = javaMailSender.createMimeMessage();
            MimeMessageHelper mail = new MimeMessageHelper(helper, true);
            mail.setTo(to);
            mail.setSubject(subject);
            mail.setText(text);
            javaMailSender.send(helper);
            LOGGER.info("Send email '{}' to: {}", subject, to);
            return new EmailStatus(to, subject, text).success();
        } catch (Exception e) {
            LOGGER.error(String.format("Problem with sending email to: {}, error message: {}", to, e.getMessage()));
            return new EmailStatus(to, subject, text).error(e.getMessage());
        }
    }
}

