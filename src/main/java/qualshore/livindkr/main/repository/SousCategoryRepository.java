package qualshore.livindkr.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import qualshore.livindkr.main.entities.Category;
import qualshore.livindkr.main.entities.SousCategory;

public interface SousCategoryRepository extends JpaRepository<SousCategory, Integer>{
	
	@Query("SELECT sc FROM SousCategory sc WHERE sc.idCategory = ?1 ")
	public List<SousCategory> findSousCategoryByCategory(Category idCategory);
	
    // public List<SousCategory> findSousCategoryByCategory(Integer idCategory);idCategory
    // public List<SousCategory> findSousCategoryByCategory(@Param("idCategory") Integer idCategory);

	


}
