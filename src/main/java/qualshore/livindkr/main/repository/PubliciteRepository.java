package qualshore.livindkr.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import qualshore.livindkr.main.entities.Publicite;
import qualshore.livindkr.main.entities.User;

public interface PubliciteRepository extends JpaRepository<Publicite, Integer>{
	
	@Query("SELECT pb FROM Publicite pb WHERE pb.idUser = ?1")
	public List<Publicite> findPubliciteByUser(User idUser);
	
	@Query("SELECT pb FROM Publicite pb WHERE pb.idPublicite = ?1")
	public Publicite findByIdPublicite(Integer idPublicite);
	
	@Query("SELECT pb FROM Publicite pb WHERE pb.typePublicite = 'Accueil' ORDER BY datePublicite DESC")
	public List<Publicite> findPubliciteByAccueil();
	
	@Query("SELECT pb FROM Publicite pb WHERE pb.typePublicite = 'Article' ORDER BY datePublicite DESC")
	public List<Publicite> findPubliciteByArticle();
	
	@Query("SELECT pb FROM Publicite pb WHERE pb.typePublicite = 'Carroussel' ORDER BY datePublicite DESC")
	public List<Publicite> findPubliciteByCarroussel();

}
