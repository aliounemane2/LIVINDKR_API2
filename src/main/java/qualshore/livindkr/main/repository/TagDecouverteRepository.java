package qualshore.livindkr.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import qualshore.livindkr.main.entities.TagDecouverte;

public interface TagDecouverteRepository extends JpaRepository<TagDecouverte, Integer>{
	
	 public List<TagDecouverte> findAll();

}
