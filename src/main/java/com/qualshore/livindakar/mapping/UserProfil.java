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
@Table(name = "user_profil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserProfil.findAll", query = "SELECT u FROM UserProfil u")
    , @NamedQuery(name = "UserProfil.findByIdUserProfil", query = "SELECT u FROM UserProfil u WHERE u.idUserProfil = :idUserProfil")
    , @NamedQuery(name = "UserProfil.findByNom", query = "SELECT u FROM UserProfil u WHERE u.nom = :nom")})
public class UserProfil implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUserProfil")
    private List<User> userList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user_profil")
    private Integer idUserProfil;
    @Size(max = 120)
    @Column(name = "nom")
    private String nom;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "idUserProfil")
    private List<User> userList;*/

    public UserProfil() {
    }

    public UserProfil(Integer idUserProfil) {
        this.idUserProfil = idUserProfil;
    }

    public Integer getIdUserProfil() {
        return idUserProfil;
    }

    public void setIdUserProfil(Integer idUserProfil) {
        this.idUserProfil = idUserProfil;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    /*@XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUserProfil != null ? idUserProfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserProfil)) {
            return false;
        }
        UserProfil other = (UserProfil) object;
        if ((this.idUserProfil == null && other.idUserProfil != null) || (this.idUserProfil != null && !this.idUserProfil.equals(other.idUserProfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qualshore.livindakar.mapping.UserProfil[ idUserProfil=" + idUserProfil + " ]";
    }

    
}
