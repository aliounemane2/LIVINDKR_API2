/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qualshore.livindkr.main.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




@Entity
@Table(name = "interest")
@JsonIgnoreProperties(ignoreUnknown = false)
@Proxy(lazy = false)
@XmlRootElement
public class Interest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_interest")
    private Integer idInterest;
    
    
    @Size(max = 75)
    @Column(name = "nom_interest")
    private String nomInterest;
    
    
    @Size(max = 100)
    @Column(name = "photo_interest")
    private String photoInterest;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInterest")
    @JsonIgnore
    private List<InterestsEvents> interestsEventsList;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "interest")
    @JsonIgnore
    private List<UsersInterests> usersInterestsList;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "interestIdInterest", fetch=FetchType.LAZY)
    @JsonIgnore
    private List<Institution> institutionList;




	public List<Institution> getInstitutionList() {
		return institutionList;
	}

	public void setInstitutionList(List<Institution> institutionList) {
		this.institutionList = institutionList;
	}

	public Interest() {
    }

    public Interest(Integer idInterest) {
        this.idInterest = idInterest;
    }

    public Integer getIdInterest() {
        return idInterest;
    }

    public void setIdInterest(Integer idInterest) {
        this.idInterest = idInterest;
    }

    public String getNomInterest() {
        return nomInterest;
    }

    public void setNomInterest(String nomInterest) {
        this.nomInterest = nomInterest;
    }

    public String getPhotoInterest() {
        return photoInterest;
    }

    public void setPhotoInterest(String photoInterest) {
        this.photoInterest = photoInterest;
    }

    @XmlTransient
    public List<InterestsEvents> getInterestsEventsList() {
        return interestsEventsList;
    }

    public void setInterestsEventsList(List<InterestsEvents> interestsEventsList) {
        this.interestsEventsList = interestsEventsList;
    }

    @XmlTransient
    public List<UsersInterests> getUsersInterestsList() {
        return usersInterestsList;
    }

    public void setUsersInterestsList(List<UsersInterests> usersInterestsList) {
        this.usersInterestsList = usersInterestsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInterest != null ? idInterest.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Interest)) {
            return false;
        }
        Interest other = (Interest) object;
        if ((this.idInterest == null && other.idInterest != null) || (this.idInterest != null && !this.idInterest.equals(other.idInterest))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "qualshore.livindkr.main.entities.Interest[ idInterest=" + idInterest + " ]";
    }
    
}
