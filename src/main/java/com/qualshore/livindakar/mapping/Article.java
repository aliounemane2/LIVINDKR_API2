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
import javax.persistence.Lob;
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
@Table(name = "article")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Article.findAll", query = "SELECT a FROM Article a")
    , @NamedQuery(name = "Article.findByIdArticle", query = "SELECT a FROM Article a WHERE a.idArticle = :idArticle")
    , @NamedQuery(name = "Article.findByTitreArticle", query = "SELECT a FROM Article a WHERE a.titreArticle = :titreArticle")
    , @NamedQuery(name = "Article.findByNbLecteur", query = "SELECT a FROM Article a WHERE a.nbLecteur = :nbLecteur")
    , @NamedQuery(name = "Article.findByDateArticle", query = "SELECT a FROM Article a WHERE a.dateArticle = :dateArticle")})
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_article")
    private Integer idArticle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "titre_article")
    private String titreArticle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "image_article")
    private String imageArticle;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "contenu_article")
    private String contenuArticle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nb_lecteur")
    private int nbLecteur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "date_article")
    private String dateArticle;
    @JoinColumn(name = "id_Category", referencedColumnName = "id_category")
    @ManyToOne(optional = false)
    private Category idCategory;
    @JoinColumn(name = "id_tag_decouverte", referencedColumnName = "id_tag_decouverte")
    @ManyToOne(optional = false)
    private TagDecouverte idTagDecouverte;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private User idUser;

    public Article() {
    }

    public Article(Integer idArticle) {
        this.idArticle = idArticle;
    }

    public Article(Integer idArticle, String titreArticle, String contenuArticle, int nbLecteur, String dateArticle,String imageArticle) {
        this.idArticle = idArticle;
        this.titreArticle = titreArticle;
        this.contenuArticle = contenuArticle;
        this.nbLecteur = nbLecteur;
        this.dateArticle = dateArticle;
        this.imageArticle = imageArticle;
    }

    public Integer getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Integer idArticle) {
        this.idArticle = idArticle;
    }

    public String getTitreArticle() {
        return titreArticle;
    }

    public void setTitreArticle(String titreArticle) {
        this.titreArticle = titreArticle;
    }
    
    public String getImageArticle() {
        return imageArticle;
    }

    public void setImageArticle(String imageArticle) {
        this.imageArticle = imageArticle;
    }

    public String getContenuArticle() {
        return contenuArticle;
    }

    public void setContenuArticle(String contenuArticle) {
        this.contenuArticle = contenuArticle;
    }

    public int getNbLecteur() {
        return nbLecteur;
    }

    public void setNbLecteur(int nbLecteur) {
        this.nbLecteur = nbLecteur;
    }

    public String getDateArticle() {
        return dateArticle;
    }

    public void setDateArticle(String dateArticle) {
        this.dateArticle = dateArticle;
    }

    public Category getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Category idCategory) {
        this.idCategory = idCategory;
    }

    public TagDecouverte getIdTagDecouverte() {
        return idTagDecouverte;
    }

    public void setIdTagDecouverte(TagDecouverte idTagDecouverte) {
        this.idTagDecouverte = idTagDecouverte;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArticle != null ? idArticle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.idArticle == null && other.idArticle != null) || (this.idArticle != null && !this.idArticle.equals(other.idArticle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qualshore.livindakar.mapping.Article[ idArticle=" + idArticle + " ]";
    }
    
}
