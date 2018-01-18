package qualshore.livindkr.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import qualshore.livindkr.main.entities.Category;
import qualshore.livindkr.main.entities.Institution;
import qualshore.livindkr.main.entities.Interest;
import qualshore.livindkr.main.entities.SousCategory;
import qualshore.livindkr.main.entities.User;

public interface InstitutionRepository extends JpaRepository<Institution, Integer>{
	
	@Query("SELECT ins FROM Institution ins WHERE ins.idCategory = ?1 ")
	public List<Institution> findInstitutionByCategory(Category idCategory);
	
	@Query("SELECT ins FROM Institution ins WHERE ins.idSousCategory = ?1 ") // AND note.idInstitution = ins.idInstitution
	public List<Institution> findInstitutionBySousCategory(SousCategory idSousCategory);
		
	@Query("SELECT ins FROM Institution ins, User u, Interest i , UsersInterests ui WHERE u.idUser = ?1 AND ui.idUser =u.idUser AND ui.idInterests = i.idInterest AND i.idInterest = ins.interestIdInterest") //   AND ins.idUser = ?1    
	public List<Institution> findRecommandations(User idUser);
	
	@Query("SELECT ins FROM Institution ins WHERE ins.idUser = ?1") //   AND ins.idUser = ?1    
	public List<Institution> findInstitutionByUser(User idUser);
	
	public Institution findByIdInstitution(Integer IdInstitution);
	
	@Query("SELECT ins, note FROM Institution ins, SousCategory sousCat, Category cat, Note note WHERE ins.idSousCategory=sousCat.idSousCategory AND ins.idCategory=?1 AND ins.idInstitution = note.idInstitution AND sousCat.idCategory=cat.idCategory")
	public List<Institution> findInstitutionByUserNoteCategory(Category idCategory);

	
}
