package qualshore.livindkr.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import qualshore.livindkr.main.entities.Article;
import qualshore.livindkr.main.entities.Event;

public interface ArticlesRepository extends JpaRepository<Article, Integer> {
	public List<Article> findAll();
	
	@Query("SELECT art FROM Article art WHERE art.idArticle = ?1")
	public Article findByIdArticle(Integer idNote);



}
