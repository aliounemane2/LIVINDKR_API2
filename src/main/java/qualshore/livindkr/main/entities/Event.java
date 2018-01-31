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
@Table(name = "event")
@JsonIgnoreProperties(ignoreUnknown = false)
@Proxy(lazy = false)
@XmlRootElement

public class Event implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_event")
    private Integer idEvent;
    
    
    @Size(max = 255)
    @Column(name = "date_event")
    private String dateEvent;
    
    
    @Size(max = 200)
    @Column(name = "description_event")
    private String descriptionEvent;
    
    
    @Size(max = 100)
    @Column(name = "nom_event")
    private String nomEvent;
    
    
    @Size(max = 100)
    @Column(name = "photo_event")
    private String photoEvent;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEvent")
    @JsonIgnore
    private List<Note> noteList;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEvent")
    @JsonIgnore
    private List<UserEvent> userEventList;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEvent")
    @JsonIgnore
    private List<EventPhoto> eventPhotoList;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEvent")
    @JsonIgnore
    private List<InterestsEvents> interestsEventsList;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEvent")
    @JsonIgnore
    private List<Notification> notificationList;
    
    
    @JoinColumn(name = "id_Place", referencedColumnName = "id_place")
    @ManyToOne(optional = false)
    private Place idPlace;
    
    
    @JoinColumn(name = "id_Category", referencedColumnName = "id_category")
    @ManyToOne(optional = false)
    private Category idCategory;
    
    
    @JoinColumn(name = "id_Institution", referencedColumnName = "id_institution")
    @ManyToOne(optional = false)
    private Institution idInstitution;
    
    
    @JoinColumn(name = "idUser", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private User idUser;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEvent")
    @JsonIgnore
    private List<Commentaire> commentaireList;

    public Event() {
    }

    public Event(Integer idEvent) {
        this.idEvent = idEvent;
    }

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
    public List<EventPhoto> getEventPhotoList() {
        return eventPhotoList;
    }

    public void setEventPhotoList(List<EventPhoto> eventPhotoList) {
        this.eventPhotoList = eventPhotoList;
    }

    @XmlTransient
    public List<InterestsEvents> getInterestsEventsList() {
        return interestsEventsList;
    }

    public void setInterestsEventsList(List<InterestsEvents> interestsEventsList) {
        this.interestsEventsList = interestsEventsList;
    }

    @XmlTransient
    public List<Notification> getNotificationList() {
        return notificationList;
    }

    public void setNotificationList(List<Notification> notificationList) {
        this.notificationList = notificationList;
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

    @XmlTransient
    public List<Commentaire> getCommentaireList() {
        return commentaireList;
    }

    public void setCommentaireList(List<Commentaire> commentaireList) {
        this.commentaireList = commentaireList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvent != null ? idEvent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.idEvent == null && other.idEvent != null) || (this.idEvent != null && !this.idEvent.equals(other.idEvent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "qualshore.livindkr.main.entities.Event[ idEvent=" + idEvent + " ]";
    }
    
}
