package qualshore.livindkr.main.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(allowedHeaders="*",allowCredentials="true")
@RestController
public class RedirectRestController {
	/*
	  @RequestMapping("/")
	  void handleFoo(HttpServletResponse response) throws IOException {
	    response.sendRedirect("/swagger-ui.html");
	  }
	 */
}
