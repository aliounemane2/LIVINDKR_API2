package qualshore.livindkr.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class UserService {
	
	@Autowired
	JavaMailSender mailSender;
	
	
	public void sendMail(String from, String to, String subject, String body) {
					SimpleMailMessage mail = new SimpleMailMessage();
					mail.setFrom(from);
					mail.setTo(to);
					mail.setSubject(subject);
					mail.setText(body);
					mailSender.send(mail);
				}

	
}
