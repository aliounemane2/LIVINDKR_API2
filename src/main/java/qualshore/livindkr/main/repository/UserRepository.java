package qualshore.livindkr.main.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import qualshore.livindkr.main.entities.User;


//@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public List<User> findByNom(String n);
	
	
	public List<User> findByTelephone(String telephone);
	public User findByEmail(String email);
	public User findByIsActive(boolean is_active);
	
	@Query("SELECT u FROM User u WHERE u.pseudo = ?1 ")
	public User findByPseudos(String pseudo);
	
	Optional<User> findByPseudo(String pseudo);
	public User findByActivationToken(int activation_token);
	public User findByIdUser(Integer idUser);
	public User findByPassword(String password);
	
	

}
