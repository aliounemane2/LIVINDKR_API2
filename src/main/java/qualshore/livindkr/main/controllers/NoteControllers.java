package qualshore.livindkr.main.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import qualshore.livindkr.main.entities.CustomUserDetails;
import qualshore.livindkr.main.entities.Event;
import qualshore.livindkr.main.entities.EventPhoto;
import qualshore.livindkr.main.entities.Institution;
import qualshore.livindkr.main.entities.Note;
import qualshore.livindkr.main.entities.SousCategory;
import qualshore.livindkr.main.entities.User;
import qualshore.livindkr.main.repository.NotesRepository;

@RequestMapping("/note")
@RestController
public class NoteControllers {
	
	@Autowired
	private NotesRepository noteRepository;
	
	
	@RequestMapping(value="/list_note_by_institution/{id}", method = RequestMethod.GET)
	public Map<String,Object> list_note_by_institution(@PathVariable Institution id) {
		HashMap<String, Object> h = new HashMap<String, Object>();

		
		List<Note>  note = noteRepository.findNoteByInstitution(id);
		
		if (note.size() == 0) {
			
			h.put("message", "La liste des notes en fonction de l'institution est vide.");
			h.put("status", -1);
			return h;
			
		}else {
			h.put("message", "La liste des notes en fonction de l'institution est :");
			h.put("notes", note);
			h.put("status", 0);
			return h;
			
		}			
	}

	
	@RequestMapping(value="/list_institution_souscategory/{id}", method = RequestMethod.GET)
	public Map<String,Object> sous_category(@PathVariable SousCategory id) {
		
		HashMap<String, Object> h = new HashMap<String, Object>();
		
		List<Note>  institution = noteRepository.findInstitutionBySousCategory(id);
		
		if (institution.size() == 0) {
			
			h.put("message", "La categorie n'existe pas.");
			return h;
			
		}
		
			h.put("message", "La liste des categories est :");
			h.put("sous_category", institution);
			return h;
		
	}
	
	
	@RequestMapping(value="/note", method = RequestMethod.POST)
	public Map<String,Object> notes(@RequestBody Note note) {
		
		HashMap<String, Object> h = new HashMap<String, Object>();
		User idUser;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) auth.getPrincipal();
        // return "Hello livInDakr "+customUserDetails.getNom();
        idUser = customUserDetails;
        note.setIdUser(idUser);
		
		Note ss = noteRepository.findInstitutionUser(note.getIdUser(), note.getIdInstitution());
		
		if (ss != null) {
			
			h.put("message", "L'utilisateur a deja donne une note a cette institution.");
			h.put("note", ss);
			return h;
		}
		
		Note s = noteRepository.save(note);
		
		h.put("message", "L'insertion est bon :");
		h.put("note", s);
		return h;

		
		
					
	}
	
	
	@RequestMapping(value="/note_by_user/", method = RequestMethod.GET)
	public Map<String,Object> notebyUser(User idUser) {
		
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) auth.getPrincipal();
        // return "Hello livInDakr "+customUserDetails.getNom();
        idUser = customUserDetails;
        
		HashMap<String, Object> h = new HashMap<String, Object>();
		List<Note> s = noteRepository.findNoteByUser(idUser);
		
		if (s.size() == 0) {
			h.put("status", -1);
			h.put("message", "L'utilisateur n'a pas de note.");
			return h;	
		}
			h.put("message", "La note de l'utilisateur est :");
			h.put("note", s);
			h.put("status",0);
			return h;
		
	}
	
	
	@RequestMapping(value="/update_note/{idnote}/{note}/{texte}/", method = RequestMethod.PUT)
	public Map<String,Object> notes(@PathVariable Integer idnote, @PathVariable Integer note, @PathVariable String texte) {
		
		HashMap<String, Object> h = new HashMap<String, Object>();
		User idUser;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) auth.getPrincipal();
        // return "Hello livInDakr "+customUserDetails.getNom();
        idUser = customUserDetails;
        
        
        Note notesss = noteRepository.findByIdNote(idnote);
        notesss.setAvis(texte);
        notesss.setNote(note);
        noteRepository.saveAndFlush(notesss);
		
		if (notesss != null) {
			
			h.put("message", "L'utilisateur n'a pas de note pour cette institution.");
			h.put("note", notesss);
			h.put("status", -1);
		}
		
		
		
		h.put("message", "La mise a jour est effective :");
		h.put("note", notesss);
		h.put("status", 0);

		return h;	
					
	}
	
	
}
