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
@Table(name = "interest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Interest.findAll", query = "SELECT i FROM Interest i")
    , @NamedQuery(name = "Interest.findByIdInterest", query = "SELECT i FROM Interest i WHERE i.idInterest = :idInterest")
    , @NamedQuery(name = "Interest.findByNomInterest", query = "SELECT i FROM Interest i WHERE i.nomInterest = :nomInterest")
    , @NamedQuery(name = "Interest.findByPhotoInterest", query = "SELECT i FROM Interest i WHERE i.photoInterest = :photoInterest")})
public class Interest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_interest")
    private Integer idInterest;
    @Size(max = 75)
    @Column(name = "nom_interest")
    private String nomInterest;
    @Size(max = 100)
    @Column(name = "photo_interest")
    private String photoInterest;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "idInterest")
    private List<InterestsEvents> interestsEventsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInterest")
    private List<UsersInterests> usersInterestsList;*/

    public Interest() {
    }

    public Interest(Integer idInterest) {
        this.idInterest = idInterest;
    }

    public Integer getIdInterest() {
        return idInterest;
    }

    public void setIdInterest(Integer idInterest) {
        this.idInterest = idInterest;
    }

    public String getNomInterest() {
        return nomInterest;
    }

    public void setNomInterest(String nomInterest) {
        this.nomInterest = nomInterest;
    }

    public String getPhotoInterest() {
        return photoInterest;
    }

    public void setPhotoInterest(String photoInterest) {
        this.photoInterest = photoInterest;
    }

    /*@XmlTransient
    public List<InterestsEvents> getInterestsEventsList() {
        return interestsEventsList;
    }

    public void setInterestsEventsList(List<InterestsEvents> interestsEventsList) {
        this.interestsEventsList = interestsEventsList;
    }

    @XmlTransient
    public List<UsersInterests> getUsersInterestsList() {
        return usersInterestsList;
    }

    public void setUsersInterestsList(List<UsersInterests> usersInterestsList) {
        this.usersInterestsList = usersInterestsList;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInterest != null ? idInterest.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Interest)) {
            return false;
        }
        Interest other = (Interest) object;
        if ((this.idInterest == null && other.idInterest != null) || (this.idInterest != null && !this.idInterest.equals(other.idInterest))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qualshore.livindakar.mapping.Interest[ idInterest=" + idInterest + " ]";
    }
    
}
