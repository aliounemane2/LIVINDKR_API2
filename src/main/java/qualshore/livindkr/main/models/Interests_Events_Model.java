package qualshore.livindkr.main.models;

import java.util.List;

import qualshore.livindkr.main.entities.Category;
import qualshore.livindkr.main.entities.Institution;
import qualshore.livindkr.main.entities.Interest;
import qualshore.livindkr.main.entities.Place;
import qualshore.livindkr.main.entities.User;

public class Interests_Events_Model {
	
	private Integer idEvent;
	   
    private String dateEvent;
   
    private String descriptionEvent;
   
    private String nomEvent;
   
    private String photoEvent;
   
    private Place idPlace;
   
    private Category idCategory;
   
    private Institution idInstitution;
   
    private User idUser;
   
    
    private Integer idInterestsEvents;
   
    private String heureDebut;
   
    
    private String heureFin;
   
    private Interest idInterest;

	public Integer getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(Integer idEvent) {
		this.idEvent = idEvent;
	}

	public String getDateEvent() {
		return dateEvent;
	}

	public void setDateEvent(String dateEvent) {
		this.dateEvent = dateEvent;
	}

	public String getDescriptionEvent() {
		return descriptionEvent;
	}

	public void setDescriptionEvent(String descriptionEvent) {
		this.descriptionEvent = descriptionEvent;
	}

	public String getNomEvent() {
		return nomEvent;
	}

	public void setNomEvent(String nomEvent) {
		this.nomEvent = nomEvent;
	}

	public String getPhotoEvent() {
		return photoEvent;
	}

	public void setPhotoEvent(String photoEvent) {
		this.photoEvent = photoEvent;
	}

	public Place getIdPlace() {
		return idPlace;
	}

	public void setIdPlace(Place idPlace) {
		this.idPlace = idPlace;
	}

	public Category getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Category idCategory) {
		this.idCategory = idCategory;
	}

	public Institution getIdInstitution() {
		return idInstitution;
	}

	public void setIdInstitution(Institution idInstitution) {
		this.idInstitution = idInstitution;
	}

	public User getIdUser() {
		return idUser;
	}

	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}

	public Integer getIdInterestsEvents() {
		return idInterestsEvents;
	}

	public void setIdInterestsEvents(Integer idInterestsEvents) {
		this.idInterestsEvents = idInterestsEvents;
	}

	public String getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(String heureDebut) {
		this.heureDebut = heureDebut;
	}

	public String getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(String heureFin) {
		this.heureFin = heureFin;
	}

	public Interest getIdInterest() {
		return idInterest;
	}

	public void setIdInterest(Interest idInterest) {
		this.idInterest = idInterest;
	}
    
    
    

}
