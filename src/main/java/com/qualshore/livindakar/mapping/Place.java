/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qualshore.livindakar.mapping;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author NIASS
 */
@Entity
@Table(name = "place")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Place.findAll", query = "SELECT p FROM Place p")
    , @NamedQuery(name = "Place.findByIdPlace", query = "SELECT p FROM Place p WHERE p.idPlace = :idPlace")
    , @NamedQuery(name = "Place.findByAdressePlace", query = "SELECT p FROM Place p WHERE p.adressePlace = :adressePlace")
    , @NamedQuery(name = "Place.findByLatitudePlace", query = "SELECT p FROM Place p WHERE p.latitudePlace = :latitudePlace")
    , @NamedQuery(name = "Place.findByLongitudePlace", query = "SELECT p FROM Place p WHERE p.longitudePlace = :longitudePlace")
    , @NamedQuery(name = "Place.findByNomPlace", query = "SELECT p FROM Place p WHERE p.nomPlace = :nomPlace")})
public class Place implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlace")
    private List<Event> eventList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_place")
    private Integer idPlace;
    @Size(max = 100)
    @Column(name = "adresse_place")
    private String adressePlace;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitude_place")
    private Float latitudePlace;
    @Column(name = "longitude_place")
    private Float longitudePlace;
    @Size(max = 100)
    @Column(name = "nom_place")
    private String nomPlace;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlace")
    private List<Event> eventList;*/

    public Place() {
    }

    public Place(Integer idPlace) {
        this.idPlace = idPlace;
    }

    public Integer getIdPlace() {
        return idPlace;
    }

    public void setIdPlace(Integer idPlace) {
        this.idPlace = idPlace;
    }

    public String getAdressePlace() {
        return adressePlace;
    }

    public void setAdressePlace(String adressePlace) {
        this.adressePlace = adressePlace;
    }

    public Float getLatitudePlace() {
        return latitudePlace;
    }

    public void setLatitudePlace(Float latitudePlace) {
        this.latitudePlace = latitudePlace;
    }

    public Float getLongitudePlace() {
        return longitudePlace;
    }

    public void setLongitudePlace(Float longitudePlace) {
        this.longitudePlace = longitudePlace;
    }

    public String getNomPlace() {
        return nomPlace;
    }

    public void setNomPlace(String nomPlace) {
        this.nomPlace = nomPlace;
    }

    /*@XmlTransient
    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlace != null ? idPlace.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Place)) {
            return false;
        }
        Place other = (Place) object;
        if ((this.idPlace == null && other.idPlace != null) || (this.idPlace != null && !this.idPlace.equals(other.idPlace))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qualshore.livindakar.mapping.Place[ idPlace=" + idPlace + " ]";
    }
    
}
