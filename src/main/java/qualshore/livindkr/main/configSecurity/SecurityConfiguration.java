package qualshore.livindkr.main.configSecurity;

/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import qualshore.livindkr.main.handler.SecurityHandler;
import qualshore.livindkr.main.repository.UserRepository;
import qualshore.livindkr.main.services.CustomUserDetailsService;

*/

/**
 * Created by User on 04/01/2018.
 */

//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableWebSecurity
//@EnableJpaRepositories(basePackageClasses = UserRepository.class)
//@Configuration
public class SecurityConfiguration {
/*extends WebSecurityConfigurerAdapter{


    public SecurityConfiguration(CustomUserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    public SecurityConfiguration() {}


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    SecurityHandler securityHandler;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
         auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST, SecurityConstant.SIGN_UP_URL).permitAll()
                .antMatchers(HttpMethod.DELETE, "/**").permitAll() // enleve
                .antMatchers(HttpMethod.PUT, "/**").permitAll() // enleve
                .antMatchers("/login").permitAll()
                .antMatchers("/users/**").permitAll()
                .antMatchers("/interests/**").permitAll() 
                .antMatchers("/institution/**").permitAll() 
                .antMatchers("/category/**").permitAll() 
                .antMatchers("/typeOffre/**").permitAll() 
                .antMatchers("/fonts/**").permitAll() 
                .antMatchers("/**").permitAll()
                .antMatchers("/secured/**").hasRole("ADMIN")
                .antMatchers("/all").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true")
                .usernameParameter("pseudo")
                .passwordParameter("password")
                .defaultSuccessUrl("/welcome")
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
    */
}
