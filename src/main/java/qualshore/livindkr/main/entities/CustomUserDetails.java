package qualshore.livindkr.main.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import qualshore.livindkr.main.entities.User;
import qualshore.livindkr.main.entities.UserProfil;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by User on 04/01/2018.
 */
public class CustomUserDetails extends User implements UserDetails {

    public CustomUserDetails(final User user){
        super(user);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<UserProfil> list = new HashSet<>();
        list.add(getIdUserProfil());

        return list
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_"+getIdUserProfil().getNom()))
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return super.getPseudo();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
