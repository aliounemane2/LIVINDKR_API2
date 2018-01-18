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
@Table(name = "tag_decouverte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TagDecouverte.findAll", query = "SELECT t FROM TagDecouverte t")
    , @NamedQuery(name = "TagDecouverte.findByIdTagDecouverte", query = "SELECT t FROM TagDecouverte t WHERE t.idTagDecouverte = :idTagDecouverte")
    , @NamedQuery(name = "TagDecouverte.findByNomTagDecouverte", query = "SELECT t FROM TagDecouverte t WHERE t.nomTagDecouverte = :nomTagDecouverte")
    , @NamedQuery(name = "TagDecouverte.findByPhotoTagDecouverte", query = "SELECT t FROM TagDecouverte t WHERE t.photoTagDecouverte = :photoTagDecouverte")})
public class TagDecouverte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tag_decouverte")
    private Integer idTagDecouverte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nom_tag_decouverte")
    private String nomTagDecouverte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "photo_tag_decouverte")
    private String photoTagDecouverte;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "idTagDecouverte")
    //private List<Article> articleList;

    public TagDecouverte() {
    }

    public TagDecouverte(Integer idTagDecouverte) {
        this.idTagDecouverte = idTagDecouverte;
    }

    public TagDecouverte(Integer idTagDecouverte, String nomTagDecouverte, String photoTagDecouverte) {
        this.idTagDecouverte = idTagDecouverte;
        this.nomTagDecouverte = nomTagDecouverte;
        this.photoTagDecouverte = photoTagDecouverte;
    }

    public Integer getIdTagDecouverte() {
        return idTagDecouverte;
    }

    public void setIdTagDecouverte(Integer idTagDecouverte) {
        this.idTagDecouverte = idTagDecouverte;
    }

    public String getNomTagDecouverte() {
        return nomTagDecouverte;
    }

    public void setNomTagDecouverte(String nomTagDecouverte) {
        this.nomTagDecouverte = nomTagDecouverte;
    }

    public String getPhotoTagDecouverte() {
        return photoTagDecouverte;
    }

    public void setPhotoTagDecouverte(String photoTagDecouverte) {
        this.photoTagDecouverte = photoTagDecouverte;
    }

    /*@XmlTransient
    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTagDecouverte != null ? idTagDecouverte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TagDecouverte)) {
            return false;
        }
        TagDecouverte other = (TagDecouverte) object;
        if ((this.idTagDecouverte == null && other.idTagDecouverte != null) || (this.idTagDecouverte != null && !this.idTagDecouverte.equals(other.idTagDecouverte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qualshore.livindakar.mapping.TagDecouverte[ idTagDecouverte=" + idTagDecouverte + " ]";
    }
    
}
