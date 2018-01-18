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
@Table(name = "type_offre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeOffre.findAll", query = "SELECT t FROM TypeOffre t")
    , @NamedQuery(name = "TypeOffre.findByIdTypeOffre", query = "SELECT t FROM TypeOffre t WHERE t.idTypeOffre = :idTypeOffre")
    , @NamedQuery(name = "TypeOffre.findByNomTypeOffre", query = "SELECT t FROM TypeOffre t WHERE t.nomTypeOffre = :nomTypeOffre")})
public class TypeOffre implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTypeoffre")
    private List<Institution> institutionList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_type_offre")
    private Integer idTypeOffre;
    @Size(max = 100)
    @Column(name = "nom_type_offre")
    private String nomTypeOffre;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "idTypeoffre")
    private List<Institution> institutionList;*/

    public TypeOffre() {
    }

    public TypeOffre(Integer idTypeOffre) {
        this.idTypeOffre = idTypeOffre;
    }

    public Integer getIdTypeOffre() {
        return idTypeOffre;
    }

    public void setIdTypeOffre(Integer idTypeOffre) {
        this.idTypeOffre = idTypeOffre;
    }

    public String getNomTypeOffre() {
        return nomTypeOffre;
    }

    public void setNomTypeOffre(String nomTypeOffre) {
        this.nomTypeOffre = nomTypeOffre;
    }

    /*@XmlTransient
    public List<Institution> getInstitutionList() {
        return institutionList;
    }

    public void setInstitutionList(List<Institution> institutionList) {
        this.institutionList = institutionList;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTypeOffre != null ? idTypeOffre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeOffre)) {
            return false;
        }
        TypeOffre other = (TypeOffre) object;
        if ((this.idTypeOffre == null && other.idTypeOffre != null) || (this.idTypeOffre != null && !this.idTypeOffre.equals(other.idTypeOffre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qualshore.livindakar.mapping.TypeOffre[ idTypeOffre=" + idTypeOffre + " ]";
    }

    
}
