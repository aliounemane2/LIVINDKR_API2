package qualshore.livindkr.main.configSecurity;

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

/**
 * Created by User on 04/01/2018.
 */

@EnableGlobalMethodSecurity
@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{


    public SecurityConfiguration(CustomUserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    SecurityHandler securityHandler;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
         auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

      http.csrf().disable()
        .headers()
        .frameOptions()
        .sameOrigin();

       http.cors().and().csrf().disable()
                .httpBasic().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers(HttpMethod.GET, "/**").permitAll()
                .antMatchers(HttpMethod.PUT, "/**").permitAll()
                .antMatchers(HttpMethod.POST, "/**").permitAll()
                .antMatchers(HttpMethod.POST, "/send/send").permitAll()
                .antMatchers(HttpMethod.POST, "/publicite/upload/").permitAll()
                .antMatchers(HttpMethod.POST, "/institution/upload/").permitAll()
                .antMatchers(HttpMethod.POST, "/articles/upload/").permitAll()
                .antMatchers(HttpMethod.POST, "/event/upload/").permitAll()
                .antMatchers("/interests/list_interests").permitAll()
                .antMatchers("/category/list_category").permitAll()
                .antMatchers("/typeOffre/listTypeOffres/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/fileupload").permitAll()
                .antMatchers("/register/**").permitAll()
                .antMatchers("/secured/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/chat/**").hasAnyRole("ADMIN", "SUPERADMIN")
                .antMatchers("/discussion/**").permitAll()
                .anyRequest().denyAll()
                .and().exceptionHandling().accessDeniedHandler(securityHandler)
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager(),userRepository))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("**/resources/**", "/static/**", "/css/**", "/js/**", "/images/**","/chat/**");
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
}
