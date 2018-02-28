package qualshore.livindkr.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import qualshore.livindkr.main.entities.Message;
import qualshore.livindkr.main.entities.User;
import qualshore.livindkr.main.entities.UserProfil;
import qualshore.livindkr.main.repository.DiscussionRepository;
import qualshore.livindkr.main.repository.ProfilRepository;
import qualshore.livindkr.main.repository.UserRepository;
import qualshore.livindkr.main.services.ServiceUser;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by User on 14/02/2018.
 */

@RestController
@RequestMapping("/discussion")
public class DiscussionController {

  @Autowired
  DiscussionRepository dr;

  @Autowired
  ServiceUser userConnecter;

  @Autowired
  ProfilRepository profilRepository;

  @Autowired
  UserRepository userRepository;

  @Description("L'obtention des messages envoyes et recus par un administrateur")
  @GetMapping("/mesMessage")
  public List<Message> MesMessages(@RequestParam("id") int id) throws ExecutionException, InterruptedException {

    CompletableFuture<List<Message>> mesMessages = dr.findTopByIdEnvoyeur(id);
    return mesMessages.get();
  }

  @Description("La liste des administrateurs de l'application")
  @GetMapping("/lesAdmins")
  public List<User> getLesAdministrateurs(){
     UserProfil profil = profilRepository.findByNom("ADMIN");
     return profil != null ? profil.getUserList() : null;
  }

  @GetMapping("/superadmin")
  public int getSuperAdmin(){
    User user = userRepository.findByIdUserProfil_Nom("SUPERADMIN");
    return user == null ? 0 : user.getIdUser();
  }
}
