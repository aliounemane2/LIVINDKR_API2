package qualshore.livindkr.main.services;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import qualshore.livindkr.main.models.CustomUserDetails;

/**
 * Created by User on 14/02/2018.
 */
@Service
public class ServiceUser {

  Authentication auth = SecurityContextHolder.getContext().getAuthentication();

  public CustomUserDetails getUserConnecter(){
    return (CustomUserDetails) auth.getPrincipal();
  }
}
