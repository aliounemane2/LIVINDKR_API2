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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author NIASS
 */
@Entity
@Table(name = "institution_menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InstitutionMenu.findAll", query = "SELECT i FROM InstitutionMenu i")
    , @NamedQuery(name = "InstitutionMenu.findByIdInstitutionMenu", query = "SELECT i FROM InstitutionMenu i WHERE i.idInstitutionMenu = :idInstitutionMenu")
    , @NamedQuery(name = "InstitutionMenu.findByPrixMenu", query = "SELECT i FROM InstitutionMenu i WHERE i.prixMenu = :prixMenu")})
public class InstitutionMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_institution_menu")
    private Integer idInstitutionMenu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prix_menu")
    private int prixMenu;
    @JoinColumn(name = "id_institution", referencedColumnName = "id_institution")
    @ManyToOne(optional = false)
    private Institution idInstitution;
    @JoinColumn(name = "id_menu", referencedColumnName = "id_Menu")
    @ManyToOne(optional = false)
    private Menu idMenu;

    public InstitutionMenu() {
    }

    public InstitutionMenu(Integer idInstitutionMenu) {
        this.idInstitutionMenu = idInstitutionMenu;
    }

    public InstitutionMenu(Integer idInstitutionMenu, int prixMenu) {
        this.idInstitutionMenu = idInstitutionMenu;
        this.prixMenu = prixMenu;
    }

    public Integer getIdInstitutionMenu() {
        return idInstitutionMenu;
    }

    public void setIdInstitutionMenu(Integer idInstitutionMenu) {
        this.idInstitutionMenu = idInstitutionMenu;
    }

    public int getPrixMenu() {
        return prixMenu;
    }

    public void setPrixMenu(int prixMenu) {
        this.prixMenu = prixMenu;
    }

    public Institution getIdInstitution() {
        return idInstitution;
    }

    public void setIdInstitution(Institution idInstitution) {
        this.idInstitution = idInstitution;
    }

    public Menu getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Menu idMenu) {
        this.idMenu = idMenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInstitutionMenu != null ? idInstitutionMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstitutionMenu)) {
            return false;
        }
        InstitutionMenu other = (InstitutionMenu) object;
        if ((this.idInstitutionMenu == null && other.idInstitutionMenu != null) || (this.idInstitutionMenu != null && !this.idInstitutionMenu.equals(other.idInstitutionMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qualshore.livindakar.mapping.InstitutionMenu[ idInstitutionMenu=" + idInstitutionMenu + " ]";
    }
    
}
