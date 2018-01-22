package qualshore.livindkr.main.configSecurity;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import qualshore.livindkr.main.entities.CustomUserDetails;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	private AuthenticationManager authenticationManager;
	
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager){
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
		//User creds = new ObjectMapper().readValue(req.getInputStream(), User.class);
		String username = req.getParameter("pseudo");
		String password = req.getParameter("password");
		return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>())
        );
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth) throws IOException, ServletException {
		CustomUserDetails details = (CustomUserDetails) auth.getPrincipal();
        if(details.getIsActive() == false){
			res.sendRedirect("/redirect/2");
        }else {
    			res.sendRedirect("/redirect/"+details.getPseudo()+"/"+details.getIdUserProfil().getNom());
        }
	}

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
		response.sendRedirect("/redirect/0");
    }
}
