package qualshore.livindkr.main.controllers;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import qualshore.livindkr.main.configSecurity.SecurityConstant;
import qualshore.livindkr.main.entities.User;
import qualshore.livindkr.main.entities.CustomUserDetails;
import qualshore.livindkr.main.models.MessageResult;
import qualshore.livindkr.main.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by Users on 03/01/2018.
 */
@RestController
public class HelloController {

    @Autowired
    private UserRepository userRepository;
    private UserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    

    public HelloController(UserRepository applicationUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder){

        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public CustomUserDetails signUp(@RequestBody CustomUserDetails user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user = applicationUserRepository.save(user);
        return user;
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/welcome")
    public String welcome(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return "welcome ";
    }

    @GetMapping("/all")
    public String Hello(){
        return bCryptPasswordEncoder.encode("passer");
    }

    @GetMapping("/secured/all")
    public String secureHello(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) auth.getPrincipal();
        return "Hello livInDakr "+customUserDetails.getNom();
    }

    @GetMapping("/error/403")
    public String accessDenied(){
        return "access-denied";
    }

    @GetMapping("/redirect/{username}/{role}")
    public Map<String, String> redirect(@PathVariable String username, @PathVariable String role, HttpServletResponse res, HttpServletRequest req){

        User user = userRepository.findByPseudo(username).get();
        HashMap<String, String> map = new HashMap<>();
        Claims claims = Jwts.claims().setSubject(user.getPseudo());
        CustomUserDetails details = new CustomUserDetails(user);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));

        claims.put("roles", details.getAuthorities());
        String token = Jwts.builder()
                .setClaims(claims)
                //.setSubject(((CustomUserDetails) auth.getPrincipal()).getPseudo())
                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstant.EXPIRATION_TIME ))
                .signWith(SignatureAlgorithm.HS512, SecurityConstant.SECRET.getBytes())
                .compact();
        res.addHeader(SecurityConstant.HEADER_STRING, SecurityConstant.TOKEN_PREFIX + token);
        res.setHeader(SecurityConstant.HEADER_STRING,SecurityConstant.TOKEN_PREFIX + token);
        map.put("key",SecurityConstant.TOKEN_PREFIX + token);
        map.put("status","0");
        return map;
    }

    @GetMapping("/redirect/{id}")
    public MessageResult redirectTo(@PathVariable("id") int id){
        switch (id){
            case 0: return new MessageResult("0",SecurityConstant.LOGININCORRECT);
            case 1: return new MessageResult("1",SecurityConstant.TOKEN);
            case 2: return new MessageResult("2",SecurityConstant.COMPTE_DESACTIVE);
        }
        return new MessageResult();
    }
}
