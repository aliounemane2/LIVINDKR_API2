package qualshore.livindkr.main.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

/**
 * Created by User on 10/01/2018.
 */

@Service
public class EmailHtmlSender {

    private EmailSender emailSender;

    private TemplateEngine templateEngine ;

    @Autowired
    public EmailHtmlSender(EmailSender sender, TemplateEngine engine){
        this.emailSender = sender;
        this.templateEngine = engine;
    }

    public EmailStatus send(String to, String subject, String templateName, Context context)
    {
        String body = templateEngine.process(templateName, context);
        return emailSender.sendHtml(to, subject, body);
    }

    public EmailStatus send(String to, String subject, String text)
    {
        return emailSender.sendPlainText(to, subject, text);
    }
}
