/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qualshore.livindakar.mapping;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author NIASS
 */
@Entity
@Table(name = "notification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notification.findAll", query = "SELECT n FROM Notification n")
    , @NamedQuery(name = "Notification.findByIdTypeNotification", query = "SELECT n FROM Notification n WHERE n.idTypeNotification = :idTypeNotification")
    , @NamedQuery(name = "Notification.findByTexte", query = "SELECT n FROM Notification n WHERE n.texte = :texte")
    , @NamedQuery(name = "Notification.findByTypeNotification", query = "SELECT n FROM Notification n WHERE n.typeNotification = :typeNotification")
    , @NamedQuery(name = "Notification.findByVue", query = "SELECT n FROM Notification n WHERE n.vue = :vue")})
public class Notification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_type_notification")
    private Integer idTypeNotification;
    @Size(max = 100)
    @Column(name = "texte")
    private String texte;
    @Size(max = 75)
    @Column(name = "type_notification")
    private String typeNotification;
    @Column(name = "vue")
    private Boolean vue;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private User idUser;
    @JoinColumn(name = "id_event", referencedColumnName = "id_event")
    @ManyToOne(optional = false)
    private Event idEvent;
    @JoinColumn(name = "id_institution", referencedColumnName = "id_institution")
    @ManyToOne(optional = false)
    private Institution idInstitution;

    public Notification() {
    }

    public Notification(Integer idTypeNotification) {
        this.idTypeNotification = idTypeNotification;
    }

    public Integer getIdTypeNotification() {
        return idTypeNotification;
    }

    public void setIdTypeNotification(Integer idTypeNotification) {
        this.idTypeNotification = idTypeNotification;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public String getTypeNotification() {
        return typeNotification;
    }

    public void setTypeNotification(String typeNotification) {
        this.typeNotification = typeNotification;
    }

    public Boolean getVue() {
        return vue;
    }

    public void setVue(Boolean vue) {
        this.vue = vue;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public Event getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Event idEvent) {
        this.idEvent = idEvent;
    }

    public Institution getIdInstitution() {
        return idInstitution;
    }

    public void setIdInstitution(Institution idInstitution) {
        this.idInstitution = idInstitution;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTypeNotification != null ? idTypeNotification.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notification)) {
            return false;
        }
        Notification other = (Notification) object;
        if ((this.idTypeNotification == null && other.idTypeNotification != null) || (this.idTypeNotification != null && !this.idTypeNotification.equals(other.idTypeNotification))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qualshore.livindakar.mapping.Notification[ idTypeNotification=" + idTypeNotification + " ]";
    }
    
}
