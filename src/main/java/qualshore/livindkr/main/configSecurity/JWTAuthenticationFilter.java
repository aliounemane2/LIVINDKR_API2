package qualshore.livindkr.main.configSecurity;
/*
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import qualshore.livindkr.main.configSecurity.SecurityConstant;
import qualshore.livindkr.main.entities.User;
import qualshore.livindkr.main.models.CustomUserDetails;
import qualshore.livindkr.main.services.CustomUserDetailsService;


*/
public class JWTAuthenticationFilter {

/*
extends UsernamePasswordAuthenticationFilter {
	
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
	protected void successfulAuthentication(HttpServletRequest req,
			HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		
		String token = Jwts.builder()
				.setSubject(((CustomUserDetails) auth.getPrincipal()).getPseudo())
				.setExpiration(new Date(System.currentTimeMillis() + SecurityConstant.EXPIRATION_TIME ))
				.signWith(SignatureAlgorithm.HS512, SecurityConstant.SECRET.getBytes())
				.compact();
		res.addHeader(SecurityConstant.HEADER_STRING, SecurityConstant.TOKEN_PREFIX + token);
		res.sendRedirect("/welcome");
	}
	
	*/
}
