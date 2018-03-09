package qualshore.livindkr.main.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "publicite")
@JsonIgnoreProperties(ignoreUnknown = false)
@Proxy(lazy = false)
@XmlRootElement
public class Publicite implements Serializable {
	
	
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_publicite")
    private Integer idPublicite;
    
    //@Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 255)
    @Column(name = "titre_publicite")
    private String titrePublicite;
    
    
	// @JsonFormat(pattern = "YYYY-MM-dd")
    @Column(name = "datepublicite")
    private String datePublicite;

    
   // @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 255)
    @Column(name = "typepublicite")
    private String typePublicite;

    
    //@Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 255)
    @Column(name = "photopublicite")
    private String photoPublicite;
    
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private User idUser;
    
    
	public Integer getIdPublicite() {
		return idPublicite;
	}


	public void setIdPublicite(Integer idPublicite) {
		this.idPublicite = idPublicite;
	}


	public String getTitrePublicite() {
		return titrePublicite;
	}


	public void setTitrePublicite(String titrePublicite) {
		this.titrePublicite = titrePublicite;
	}


	public String getDatePublicite() {
		return datePublicite;
	}


	public void setDatePublicite(String datePublicite) {
		this.datePublicite = datePublicite;
	}


	public String getTypePublicite() {
		return typePublicite;
	}


	public void setTypePublicite(String typePublicite) {
		this.typePublicite = typePublicite;
	}


	public Publicite() {
		super();
	}


	public Publicite(Integer idPublicite, String titrePublicite, String datePublicite, String typePublicite,String photoPublicite, User idUser) {
		super();
		this.idPublicite = idPublicite;
		this.titrePublicite = titrePublicite;
		this.datePublicite = datePublicite;
		this.typePublicite = typePublicite;
		this.idUser=idUser;
		this.photoPublicite=photoPublicite;
	}


	public String getPhotoPublicite() {
		return photoPublicite;
	}


	public void setPhotoPublicite(String photoPublicite) {
		this.photoPublicite = photoPublicite;
	}


	public User getIdUser() {
		return idUser;
	}


	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}
	
    
}
