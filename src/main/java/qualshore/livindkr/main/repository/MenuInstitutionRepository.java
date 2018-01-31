package qualshore.livindkr.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import qualshore.livindkr.main.entities.InstitutionMenu;

public interface MenuInstitutionRepository extends JpaRepository<InstitutionMenu, Integer>{
	
	// @Query("SELECT im FROM InstitutionMenu im, Institution ins , Menu m WHERE im.idInstitution = ins.idInstitution AND im.idIMenu = m.idMenu And ins.idInstitution = ?1")
	// public List<InstitutionMenu> findMenuByInstitution(Integer idInstitution);

}
