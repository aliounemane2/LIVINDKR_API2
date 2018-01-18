package qualshore.livindkr.main.services;

import org.springframework.stereotype.Service;

/*
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import qualshore.livindkr.main.entities.User;
import qualshore.livindkr.main.models.CustomUserDetails;
import qualshore.livindkr.main.repository.UserRepository;
*/

@Service
public class CustomUserDetailsService {
	/*
	implements UserDetailsService{
}
	
	 @Autowired
	  private UserRepository userRepository;
	 

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        Optional<User> usersOptional = userRepository.findByPseudo(username);

	        usersOptional.orElseThrow(() -> new UsernameNotFoundException("Username not found"));

	        System.out.print(usersOptional.map(CustomUserDetails::new).get().getUsername());
	        return usersOptional.map(CustomUserDetails::new).get();
	    }
*/
}
