package qualshore.livindkr.main.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import qualshore.livindkr.main.entities.User;


//@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	List<User> findByNom(String n);


	List<User> findByTelephone(String telephone);
	User findByEmail(String email);
	User findByIsActive(boolean is_active);

	@Query("SELECT u FROM User u WHERE u.pseudo = ?1 ")
	User findByPseudos(String pseudo);

	Optional<User> findByPseudo(String pseudo);
	User findByActivationToken(int activation_token);
	User findByIdUser(Integer idUser);
	User findByPassword(String password);

  User findByIdUserProfil_Nom(String nom);


}
