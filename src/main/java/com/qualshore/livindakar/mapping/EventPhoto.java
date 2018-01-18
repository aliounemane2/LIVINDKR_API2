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
@Table(name = "event_photo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EventPhoto.findAll", query = "SELECT e FROM EventPhoto e")
    , @NamedQuery(name = "EventPhoto.findByIdEventPhoto", query = "SELECT e FROM EventPhoto e WHERE e.idEventPhoto = :idEventPhoto")
    , @NamedQuery(name = "EventPhoto.findByNomEventPhoto", query = "SELECT e FROM EventPhoto e WHERE e.nomEventPhoto = :nomEventPhoto")
    , @NamedQuery(name = "EventPhoto.findByCheminEventPhoto", query = "SELECT e FROM EventPhoto e WHERE e.cheminEventPhoto = :cheminEventPhoto")})
public class EventPhoto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_event_photo")
    private Integer idEventPhoto;
    @Size(max = 100)
    @Column(name = "nom_event_photo")
    private String nomEventPhoto;
    @Size(max = 100)
    @Column(name = "chemin_event_photo")
    private String cheminEventPhoto;
    @JoinColumn(name = "id_event", referencedColumnName = "id_event")
    @ManyToOne(optional = false)
    private Event idEvent;

    public EventPhoto() {
    }

    public EventPhoto(Integer idEventPhoto) {
        this.idEventPhoto = idEventPhoto;
    }

    public Integer getIdEventPhoto() {
        return idEventPhoto;
    }

    public void setIdEventPhoto(Integer idEventPhoto) {
        this.idEventPhoto = idEventPhoto;
    }

    public String getNomEventPhoto() {
        return nomEventPhoto;
    }

    public void setNomEventPhoto(String nomEventPhoto) {
        this.nomEventPhoto = nomEventPhoto;
    }

    public String getCheminEventPhoto() {
        return cheminEventPhoto;
    }

    public void setCheminEventPhoto(String cheminEventPhoto) {
        this.cheminEventPhoto = cheminEventPhoto;
    }

    public Event getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Event idEvent) {
        this.idEvent = idEvent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEventPhoto != null ? idEventPhoto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventPhoto)) {
            return false;
        }
        EventPhoto other = (EventPhoto) object;
        if ((this.idEventPhoto == null && other.idEventPhoto != null) || (this.idEventPhoto != null && !this.idEventPhoto.equals(other.idEventPhoto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qualshore.livindakar.mapping.EventPhoto[ idEventPhoto=" + idEventPhoto + " ]";
    }
    
}
