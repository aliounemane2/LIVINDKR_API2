package qualshore.livindkr.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import qualshore.livindkr.main.entities.Interest;
import qualshore.livindkr.main.entities.User;
import qualshore.livindkr.main.entities.UsersInterests;

public interface Users_Interests_Repository extends JpaRepository<UsersInterests, Integer> {
	
	public UsersInterests findByIdUsersInterests(Integer user_interest);
	public List<UsersInterests> findByIdInterests(Interest interest);
	public List<UsersInterests> findByIdUser(Integer user); 
	
	@Query("SELECT ui FROM UsersInterests ui, User u, Interest i  WHERE ui.idUser = ?1 AND ui.idUser=u.idUser AND ui.idInterests=i.idInterest") 
    public List<UsersInterests> findByInterestByUser(Integer idUser);

	
}
