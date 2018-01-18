package qualshore.livindkr.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import qualshore.livindkr.main.entities.User;
import qualshore.livindkr.main.entities.CustomUserDetails;
import qualshore.livindkr.main.repository.UserRepository;

import java.util.Optional;

/**
 * Created by User on 04/01/2018.
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> usersOptional = userRepository.findByPseudo(username);

        usersOptional.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return usersOptional.map(CustomUserDetails::new).get();
    }
}
