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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author NIASS
 */
@Entity
@Table(name = "users_interests")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsersInterests.findAll", query = "SELECT u FROM UsersInterests u")
    , @NamedQuery(name = "UsersInterests.findByIdUsersInterests", query = "SELECT u FROM UsersInterests u WHERE u.idUsersInterests = :idUsersInterests")})
public class UsersInterests implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Users_Interests")
    private Integer idUsersInterests;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private User idUser;
    @JoinColumn(name = "id_interest", referencedColumnName = "id_interest")
    @ManyToOne(optional = false)
    private Interest idInterest;

    public UsersInterests() {
    }

    public UsersInterests(Integer idUsersInterests) {
        this.idUsersInterests = idUsersInterests;
    }

    public Integer getIdUsersInterests() {
        return idUsersInterests;
    }

    public void setIdUsersInterests(Integer idUsersInterests) {
        this.idUsersInterests = idUsersInterests;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public Interest getIdInterest() {
        return idInterest;
    }

    public void setIdInterest(Interest idInterest) {
        this.idInterest = idInterest;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsersInterests != null ? idUsersInterests.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersInterests)) {
            return false;
        }
        UsersInterests other = (UsersInterests) object;
        if ((this.idUsersInterests == null && other.idUsersInterests != null) || (this.idUsersInterests != null && !this.idUsersInterests.equals(other.idUsersInterests))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qualshore.livindakar.mapping.UsersInterests[ idUsersInterests=" + idUsersInterests + " ]";
    }
    
}
