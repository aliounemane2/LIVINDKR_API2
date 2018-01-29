/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qualshore.livindkr.main.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "user")
@JsonIgnoreProperties(ignoreUnknown = false)
@Proxy(lazy = false)
@XmlRootElement
public class User implements Serializable {



	private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user")
    private Integer idUser;
    
    
    /// @Size(max = 6)
    @Column(name = "activationToken")
    private Integer activationToken;
    
    
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 75)
    @Column(name = "email")
    private String email;
    
    
    @Column(name = "is_active")
    private Boolean isActive;
    
    

    
    @Size(max = 255)
    @Column(name = "lastconnexion")
    private String lastconnexion;
    
    @Size(max = 130)
    @Column(name = "nom")
    private String nom;
    
    @Size(max = 100)
    @Column(name = "password")
    private String password;
    
    @Size(max = 80)
    @Column(name = "photo")
    private String photo;
    
    @Size(max = 130)
    @Column(name = "prenom")
    private String prenom;
    
    @Size(max = 45)
    @Column(name = "status")
    private String status;
    
    @Size(max = 75)
    @Column(name = "telephone")
    private String telephone;
    
    @Size(max = 255)
    @Column(name = "date_naissance")
    private String dateNaissance;
    
    @Column(name = "is_dakar")
    private Boolean isDakar;
    
    
    @Size(max = 255)
    @Column(name = "pseudo")
    private String pseudo;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    @JsonIgnore
    private List<Note> noteList;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    @JsonIgnore
    private List<UserEvent> userEventList;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    @JsonIgnore
    private List<Institution> institutionList;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    @JsonIgnore
    private List<Notification> notificationList;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    @JsonIgnore
    private List<UsersInterests> usersInterestsList;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    @JsonIgnore
    private List<Event> eventList;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    @JsonIgnore
    private List<Commentaire> commentaireList;
    
    
   
    
    @JoinColumn(name = "id_user_profil", referencedColumnName = "id_user_profil")
    @ManyToOne(optional = false)
    private UserProfil idUserProfil;

    public User (User user){
        this.idUser = user.idUser;
        this.activationToken = user.activationToken;
        this.email = user.email;
        this.isActive = user.isActive;
        this.lastconnexion = user.lastconnexion;
        this.nom = user.nom;
        this.password = user.password;
        this.photo = user.photo;
        this.prenom = user.prenom;
        this.status = user.status;
        this.telephone = user.telephone;
        this.dateNaissance = user.dateNaissance;
        this.isDakar = user.isDakar;
        this.pseudo = user.pseudo;
        this.idUserProfil = user.getIdUserProfil();
    }

    public User(Integer idUser, Integer activationToken, String email, Boolean isActive, String lastconnexion,
			String nom, String password, String photo, String prenom, String status, String telephone,
			String dateNaissance, Boolean isDakar, String pseudo, List<Note> noteList, List<UserEvent> userEventList,
			List<Institution> institutionList, List<Notification> notificationList,
			List<UsersInterests> usersInterestsList, List<Event> eventList, List<Commentaire> commentaireList
			// ,UserProfil idUserProfil
			
    		) {
		super();
		this.idUser = idUser;
		this.activationToken = activationToken;
		this.email = email;
		this.isActive = isActive;
		this.lastconnexion = lastconnexion;
		this.nom = nom;
		this.password = password;
		this.photo = photo;
		this.prenom = prenom;
		this.status = status;
		this.telephone = telephone;
		this.dateNaissance = dateNaissance;
		this.isDakar = isDakar;
		this.pseudo = pseudo;
		this.noteList = noteList;
		this.userEventList = userEventList;
		this.institutionList = institutionList;
		this.notificationList = notificationList;
		this.usersInterestsList = usersInterestsList;
		this.eventList = eventList;
		this.commentaireList = commentaireList;
		// this.idUserProfil = idUserProfil;
	}

    public User() {
    }

    public User(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getActivationToken() {
        return activationToken;
    }

    public void setActivationToken(Integer activationToken) {
        this.activationToken = activationToken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getLastconnexion() {
        return lastconnexion;
    }

    public void setLastconnexion(String lastconnexion) {
        this.lastconnexion = lastconnexion;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Boolean getIsDakar() {
        return isDakar;
    }

    public void setIsDakar(Boolean isDakar) {
        this.isDakar = isDakar;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    @XmlTransient
    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }

    @XmlTransient
    public List<UserEvent> getUserEventList() {
        return userEventList;
    }

    public void setUserEventList(List<UserEvent> userEventList) {
        this.userEventList = userEventList;
    }

    @XmlTransient
    public List<Institution> getInstitutionList() {
        return institutionList;
    }

    public void setInstitutionList(List<Institution> institutionList) {
        this.institutionList = institutionList;
    }

    @XmlTransient
    public List<Notification> getNotificationList() {
        return notificationList;
    }

    public void setNotificationList(List<Notification> notificationList) {
        this.notificationList = notificationList;
    }

    @XmlTransient
    public List<UsersInterests> getUsersInterestsList() {
        return usersInterestsList;
    }

    public void setUsersInterestsList(List<UsersInterests> usersInterestsList) {
        this.usersInterestsList = usersInterestsList;
    }

    @XmlTransient
    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    @XmlTransient
    public List<Commentaire> getCommentaireList() {
        return commentaireList;
    }

    public void setCommentaireList(List<Commentaire> commentaireList) {
        this.commentaireList = commentaireList;
    }


    public UserProfil getIdUserProfil() {
        return idUserProfil;
    }

    public void setIdUserProfil(UserProfil idUserProfil) {
        this.idUserProfil = idUserProfil;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "qualshore.livindkr.main.entities.User[ idUser=" + idUser + " ]";
    }
    
	public UsersInterests addUsersInterests(Interest interest){
		
		UsersInterests uInterests = new UsersInterests();
		uInterests.setInterest(interest);
		uInterests.setIdInterests(interest.getIdInterest());
		uInterests.setUser(this);
		uInterests.setIdUser(this.getIdUser());
		this.getUsersInterestsList().add(uInterests);
		interest.getUsersInterestsList().add(uInterests);
		
		return uInterests;
	}
	
    
}
