package qualshore.livindkr.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import qualshore.livindkr.main.entities.Interest;

public interface InterestRepository extends JpaRepository<Interest, Integer>{

	public Interest findByIdInterest(Integer id);
	public List<Interest> findAll();
}
