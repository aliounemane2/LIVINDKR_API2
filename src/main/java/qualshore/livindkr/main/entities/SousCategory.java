/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qualshore.livindkr.main.entities;

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

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "sous_category")
@JsonIgnoreProperties(ignoreUnknown = false)
@Proxy(lazy = false)
@XmlRootElement
public class SousCategory implements Serializable {

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
    
    
    @JoinColumn(name = "idCategory", referencedColumnName = "id_category")
    @ManyToOne(optional = false)
    private Category idCategory;
    
    
    @OneToMany(mappedBy = "idSousCategory")
    @JsonIgnore
    private List<Institution> institutionList;

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

    @XmlTransient
    public List<Institution> getInstitutionList() {
        return institutionList;
    }

    public void setInstitutionList(List<Institution> institutionList) {
        this.institutionList = institutionList;
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
        return "qualshore.livindkr.main.entities.SousCategory[ idSousCategory=" + idSousCategory + " ]";
    }
    
}
