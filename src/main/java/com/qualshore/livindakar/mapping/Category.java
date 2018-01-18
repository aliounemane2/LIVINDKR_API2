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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author NIASS
 */
@Entity
@Table(name = "category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
    , @NamedQuery(name = "Category.findByIdCategory", query = "SELECT c FROM Category c WHERE c.idCategory = :idCategory")
    , @NamedQuery(name = "Category.findByNom", query = "SELECT c FROM Category c WHERE c.nom = :nom")
    , @NamedQuery(name = "Category.findByImageCategorie", query = "SELECT c FROM Category c WHERE c.imageCategorie = :imageCategorie")})
public class Category implements Serializable {
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategory")
    //private List<SousCategory> sousCategoryList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_category")
    private Integer idCategory;
    @Size(max = 100)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "image_categorie")
    private String imageCategorie;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategory")
    private List<SousCategory> sousCategoryList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategory")
    private List<Article> articleList;
    @OneToMany(mappedBy = "idCategory")
    private List<Institution> institutionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategory")
    private List<Event> eventList;*/

    public Category() {
    }

    public Category(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public Category(Integer idCategory, String imageCategorie) {
        this.idCategory = idCategory;
        this.imageCategorie = imageCategorie;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImageCategorie() {
        return imageCategorie;
    }

    public void setImageCategorie(String imageCategorie) {
        this.imageCategorie = imageCategorie;
    }

    /*@XmlTransient
    public List<SousCategory> getSousCategoryList() {
        return sousCategoryList;
    }

    public void setSousCategoryList(List<SousCategory> sousCategoryList) {
        this.sousCategoryList = sousCategoryList;
    }

    @XmlTransient
    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    @XmlTransient
    public List<Institution> getInstitutionList() {
        return institutionList;
    }

    public void setInstitutionList(List<Institution> institutionList) {
        this.institutionList = institutionList;
    }

    @XmlTransient
    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategory != null ? idCategory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.idCategory == null && other.idCategory != null) || (this.idCategory != null && !this.idCategory.equals(other.idCategory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qualshore.livindakar.mapping.Category[ idCategory=" + idCategory + " ]";
    }

}
