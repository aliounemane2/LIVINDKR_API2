/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qualshore.livindkr.main.entities;

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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "article")
@JsonIgnoreProperties(ignoreUnknown = false)
@Proxy(lazy = false)
@XmlRootElement
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
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "contenu_article")
    private String contenuArticle;
    
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "nb_lecteur")
    private int nbLecteur;
    
    
    //@Basic(optional = false)
    //@NotNull
    //@Column(name = "id_user")
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private User idUser;
    
    
    public User getIdUser() {
		return idUser;
	}

	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}

	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "date_article")
    private String dateArticle;
    
    @Size(max = 80)
    @Column(name = "image")
    private String image;
    
    
    public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@JoinColumn(name = "id_Category", referencedColumnName = "id_category")
    @ManyToOne(optional = false)
    private Category idCategory;
    
    
    @JoinColumn(name = "id_tag_decouverte", referencedColumnName = "id_tag_decouverte")
    @ManyToOne(optional = false)
    private TagDecouverte idTagDecouverte;

    public Article() {
    }

    public Article(Integer idArticle) {
        this.idArticle = idArticle;
    }
// int idUser,
    public Article(Integer idArticle, String titreArticle, String contenuArticle, User idUser, int nbLecteur, String dateArticle, String image) {
        this.idArticle = idArticle;
        this.titreArticle = titreArticle;
        this.contenuArticle = contenuArticle;
        this.nbLecteur = nbLecteur;
        this.idUser = idUser;
        this.dateArticle = dateArticle;
        this.image = image;
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
/*
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
*/
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
        return "qualshore.livindkr.main.entities.Article[ idArticle=" + idArticle + " ]";
    }
    
}
