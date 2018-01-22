package qualshore.livindkr.main.configSecurity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.io.IOException;
import java.util.*;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.jsonwebtoken.SignatureException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import qualshore.livindkr.main.entities.User;
import qualshore.livindkr.main.entities.CustomUserDetails;
import qualshore.livindkr.main.repository.UserRepository;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter{

	private UserRepository userRepository;

	public JWTAuthorizationFilter(AuthenticationManager authManager, UserRepository userRepository) {
		super(authManager);
		this.userRepository = userRepository;
	}



	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
		//super.doFilterInternal(req, res, chain);
		
		String header = req.getHeader(SecurityConstant.HEADER_STRING);
		if (header == null || !header.startsWith(SecurityConstant.TOKEN_PREFIX)) {
			chain.doFilter(req, res);
			return;
		}
		
		UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
        if(authentication == null){
			res.sendRedirect("/redirect/1");
        }else{
            SecurityContextHolder.getContext().setAuthentication(authentication);
            chain.doFilter(req, res);
        }
	}

	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest req) {
		String token = req.getHeader(SecurityConstant.HEADER_STRING);
		if (token != null) {
            try {
                Claims claims = Jwts.parser()
                        .setSigningKey(SecurityConstant.SECRET.getBytes())
                        .parseClaimsJws(token.replace(SecurityConstant.TOKEN_PREFIX, ""))
                        .getBody();


			Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
			List<LinkedHashMap<String,String>> roles1 = (List<LinkedHashMap<String, String>>)claims.get("roles");

			for (int i = 0; i < roles1.size(); i++) {
				for (String key : roles1.get(i).keySet()) {
					authorities.add(new SimpleGrantedAuthority(roles1.get(i).get(key)));
				}
			}
			String user = claims.getSubject();
			if (user != null) {
				Optional<User> usersOptional = userRepository.findByPseudo(user);
				CustomUserDetails userDetails = usersOptional.map(CustomUserDetails::new).get();
				return new UsernamePasswordAuthenticationToken(userDetails, null,authorities);
			}
			return null;
            }catch (SignatureException e){
                return null;
            }
        }
		return null;
	}

}
