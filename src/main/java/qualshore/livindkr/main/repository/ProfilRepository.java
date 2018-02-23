package qualshore.livindkr.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import qualshore.livindkr.main.entities.UserProfil;

/**
 * Created by User on 23/02/2018.
 */
public interface ProfilRepository extends JpaRepository<UserProfil, Integer> {
  public UserProfil findByNom(String nom);
}
