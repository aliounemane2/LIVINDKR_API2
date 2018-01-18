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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author NIASS
 */
@Entity
@Table(name = "interests_events")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InterestsEvents.findAll", query = "SELECT i FROM InterestsEvents i")
    , @NamedQuery(name = "InterestsEvents.findByIdInterestsEvents", query = "SELECT i FROM InterestsEvents i WHERE i.idInterestsEvents = :idInterestsEvents")
    , @NamedQuery(name = "InterestsEvents.findByHeureDebut", query = "SELECT i FROM InterestsEvents i WHERE i.heureDebut = :heureDebut")
    , @NamedQuery(name = "InterestsEvents.findByHeureFin", query = "SELECT i FROM InterestsEvents i WHERE i.heureFin = :heureFin")})
public class InterestsEvents implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_interests_events")
    private Integer idInterestsEvents;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "heure_debut")
    private String heureDebut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "heure_fin")
    private String heureFin;
    @JoinColumn(name = "id_interest", referencedColumnName = "id_interest")
    @ManyToOne(optional = false)
    private Interest idInterest;
    @JoinColumn(name = "id_event", referencedColumnName = "id_event")
    @ManyToOne(optional = false)
    private Event idEvent;

    public InterestsEvents() {
    }

    public InterestsEvents(Integer idInterestsEvents) {
        this.idInterestsEvents = idInterestsEvents;
    }

    public InterestsEvents(Integer idInterestsEvents, String heureDebut, String heureFin) {
        this.idInterestsEvents = idInterestsEvents;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
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

    public Event getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Event idEvent) {
        this.idEvent = idEvent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInterestsEvents != null ? idInterestsEvents.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InterestsEvents)) {
            return false;
        }
        InterestsEvents other = (InterestsEvents) object;
        if ((this.idInterestsEvents == null && other.idInterestsEvents != null) || (this.idInterestsEvents != null && !this.idInterestsEvents.equals(other.idInterestsEvents))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qualshore.livindakar.mapping.InterestsEvents[ idInterestsEvents=" + idInterestsEvents + " ]";
    }
    
}
