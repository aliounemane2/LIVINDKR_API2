package qualshore.livindkr.main.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import qualshore.livindkr.main.entities.Institution;
import qualshore.livindkr.main.entities.Note;
import qualshore.livindkr.main.entities.SousCategory;
import qualshore.livindkr.main.entities.User;

public interface NotesRepository extends JpaRepository<Note, Integer>{
	
	@Query("SELECT nt FROM Note nt WHERE nt.idInstitution = ?1")
	public List<Note> findNoteByInstitution(Institution idInstitution);
	
	
	@Query("SELECT note FROM Institution ins , Note note WHERE ins.idSousCategory = ?1 AND note.idInstitution = ins.idInstitution ")
	public List<Note> findInstitutionBySousCategory(SousCategory idSousCategory);

	@Query("SELECT note FROM Note note WHERE note.idUser = ?1 ")
	public List<Note> findNoteByUser(User idUser);
	
	@Query("SELECT note FROM Note note WHERE note.idUser = ?1 AND note.idInstitution= ?2")
	public Note findInstitutionUser(User idUser, Institution idInstitution);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Note WHERE idInstitution = ?1")
	void deleteNoteByInstitution(Institution idInstitution);
	
	
	Note findByIdNote(Integer idnote);

}
