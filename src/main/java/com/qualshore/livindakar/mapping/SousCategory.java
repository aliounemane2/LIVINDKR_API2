/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qualshore.livindakar.mapping;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author NIASS
 */
@Entity
@Table(name = "sous_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SousCategory.findAll", query = "SELECT s FROM SousCategory s")
    , @NamedQuery(name = "SousCategory.findByIdSousCategory", query = "SELECT s FROM SousCategory s WHERE s.idSousCategory = :idSousCategory")
    , @NamedQuery(name = "SousCategory.findByNomSousCategory", query = "SELECT s FROM SousCategory s WHERE s.nomSousCategory = :nomSousCategory")
    , @NamedQuery(name = "SousCategory.findByImageSousCategory", query = "SELECT s FROM SousCategory s WHERE s.imageSousCategory = :imageSousCategory")})
public class SousCategory implements Serializable {

    @OneToMany(mappedBy = "idSousCategory")
    private List<Institution> institutionList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Sous_Category")
    private Integer idSousCategory;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom_sous_category")
    private String nomSousCategory;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "image_sous_category")
    private String imageSousCategory;
    @JoinColumn(name = "id_category", referencedColumnName = "id_category")
    @ManyToOne(optional = false)
    private Category idCategory;

    public SousCategory() {
    }

    public SousCategory(Integer idSousCategory) {
        this.idSousCategory = idSousCategory;
    }

    public SousCategory(Integer idSousCategory, String nomSousCategory, String imageSousCategory) {
        this.idSousCategory = idSousCategory;
        this.nomSousCategory = nomSousCategory;
        this.imageSousCategory = imageSousCategory;
    }

    public Integer getIdSousCategory() {
        return idSousCategory;
    }

    public void setIdSousCategory(Integer idSousCategory) {
        this.idSousCategory = idSousCategory;
    }

    public String getNomSousCategory() {
        return nomSousCategory;
    }

    public void setNomSousCategory(String nomSousCategory) {
        this.nomSousCategory = nomSousCategory;
    }

    public String getImageSousCategory() {
        return imageSousCategory;
    }

    public void setImageSousCategory(String imageSousCategory) {
        this.imageSousCategory = imageSousCategory;
    }

    public Category getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Category idCategory) {
        this.idCategory = idCategory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSousCategory != null ? idSousCategory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SousCategory)) {
            return false;
        }
        SousCategory other = (SousCategory) object;
        if ((this.idSousCategory == null && other.idSousCategory != null) || (this.idSousCategory != null && !this.idSousCategory.equals(other.idSousCategory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qualshore.livindakar.mapping.SousCategory[ idSousCategory=" + idSousCategory + " ]";
    }
}
