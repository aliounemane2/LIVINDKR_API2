package qualshore.livindkr.main;

/*
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
*/

// @Configuration
//@EnableWebSecurity
public class SecurityConfig {

/*extends WebSecurityConfigurerAdapter {
	
	
	 // @Autowired
	 // private AccessDeniedHandler accessDeniedHandler;
	 
	 
   /* @Override
    protected void configure(HttpSecurity http) throws Exception {
      http
        .csrf().disable()
        .authorizeRequests()
        
          .antMatchers(HttpMethod.POST, "/**").authenticated()
          .antMatchers(HttpMethod.PUT, "/**").authenticated()
          .antMatchers(HttpMethod.DELETE, "/**").authenticated()
          .antMatchers(HttpMethod.GET, "/**").authenticated()
          .anyRequest().permitAll()
          .and()
        .httpBasic().and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }*/
	/*
	 @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.inMemoryAuthentication()
	                .withUser("user1").password("secret1").roles("USER")
	                .and()
	                .withUser("user2").password("secret2").roles("USER");
	    }
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests().anyRequest().fullyAuthenticated();
	        http.httpBasic();
	        http.csrf().disable();
	    }
	    */
  }



