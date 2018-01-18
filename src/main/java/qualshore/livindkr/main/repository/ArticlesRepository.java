package qualshore.livindkr.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import qualshore.livindkr.main.entities.Article;
import qualshore.livindkr.main.entities.Event;

public interface ArticlesRepository extends JpaRepository<Article, Integer> {
	public List<Article> findAll();


}
