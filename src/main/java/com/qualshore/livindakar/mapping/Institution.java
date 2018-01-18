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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "institution")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Institution.findAll", query = "SELECT i FROM Institution i")
    , @NamedQuery(name = "Institution.findByIdInstitution", query = "SELECT i FROM Institution i WHERE i.idInstitution = :idInstitution")
    , @NamedQuery(name = "Institution.findByAdresseIns", query = "SELECT i FROM Institution i WHERE i.adresseIns = :adresseIns")
    , @NamedQuery(name = "Institution.findByLatitudeIns", query = "SELECT i FROM Institution i WHERE i.latitudeIns = :latitudeIns")
    , @NamedQuery(name = "Institution.findByLongitudeIns", query = "SELECT i FROM Institution i WHERE i.longitudeIns = :longitudeIns")
    , @NamedQuery(name = "Institution.findByNomIns", query = "SELECT i FROM Institution i WHERE i.nomIns = :nomIns")
    , @NamedQuery(name = "Institution.findByPhotoIns", query = "SELECT i FROM Institution i WHERE i.photoIns = :photoIns")
    , @NamedQuery(name = "Institution.findByTelephoneIns", query = "SELECT i FROM Institution i WHERE i.telephoneIns = :telephoneIns")
    , @NamedQuery(name = "Institution.findBySolde", query = "SELECT i FROM Institution i WHERE i.solde = :solde")
    , @NamedQuery(name = "Institution.findByPrice", query = "SELECT i FROM Institution i WHERE i.price = :price")})
public class Institution implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInstitution")
    private List<Event> eventList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_institution")
    private Integer idInstitution;
    @Size(max = 100)
    @Column(name = "adresse_ins")
    private String adresseIns;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitude_ins")
    private Float latitudeIns;
    @Column(name = "longitude_ins")
    private Float longitudeIns;
    @Size(max = 100)
    @Column(name = "nom_ins")
    private String nomIns;
    @Size(max = 255)
    @Column(name = "photo_ins")
    private String photoIns;
    @Size(max = 50)
    @Column(name = "telephone_ins")
    private String telephoneIns;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "description_ins")
    private String descriptionIns;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "solde")
    private String solde;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "price")
    private String price;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInstitution")
    private List<Note> noteList;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "idInstitution")
    private List<Vignette> vignetteList;*/
    @JoinColumn(name = "id_Type_offre", referencedColumnName = "id_type_offre")
    @ManyToOne(optional = false)
    private TypeOffre idTypeoffre;
    @JoinColumn(name = "id_Category", referencedColumnName = "id_category")
    @ManyToOne
    private Category idCategory;
    @JoinColumn(name = "id_Sous_Category", referencedColumnName = "id_Sous_Category")
    @ManyToOne
    private SousCategory idSousCategory;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private User idUser;
    @JoinColumn(name = "id_interest", referencedColumnName = "id_interest")
    @ManyToOne(optional = false)
    private Interest idInterest;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "idInstitution")
    private List<Notification> notificationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInstitution")
    private List<InstitutionMenu> institutionMenuList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInstitution")
    private List<Event> eventList;*/
    public Institution() {
    }

    public Institution(Integer idInstitution) {
        this.idInstitution = idInstitution;
    }

    public Institution(Integer idInstitution, String descriptionIns, String solde, String price) {
        this.idInstitution = idInstitution;
        this.descriptionIns = descriptionIns;
        this.solde = solde;
        this.price = price;
    }

    public Integer getIdInstitution() {
        return idInstitution;
    }

    public void setIdInstitution(Integer idInstitution) {
        this.idInstitution = idInstitution;
    }

    public String getAdresseIns() {
        return adresseIns;
    }

    public void setAdresseIns(String adresseIns) {
        this.adresseIns = adresseIns;
    }

    public Float getLatitudeIns() {
        return latitudeIns;
    }

    public void setLatitudeIns(Float latitudeIns) {
        this.latitudeIns = latitudeIns;
    }

    public Float getLongitudeIns() {
        return longitudeIns;
    }

    public void setLongitudeIns(Float longitudeIns) {
        this.longitudeIns = longitudeIns;
    }

    public String getNomIns() {
        return nomIns;
    }

    public void setNomIns(String nomIns) {
        this.nomIns = nomIns;
    }

    public String getPhotoIns() {
        return photoIns;
    }

    public void setPhotoIns(String photoIns) {
        this.photoIns = photoIns;
    }

    public String getTelephoneIns() {
        return telephoneIns;
    }

    public void setTelephoneIns(String telephoneIns) {
        this.telephoneIns = telephoneIns;
    }

    public String getDescriptionIns() {
        return descriptionIns;
    }

    public void setDescriptionIns(String descriptionIns) {
        this.descriptionIns = descriptionIns;
    }

    public String getSolde() {
        return solde;
    }

    public void setSolde(String solde) {
        this.solde = solde;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @XmlTransient
    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }

    /*@XmlTransient
    public List<Vignette> getVignetteList() {
        return vignetteList;
    }

    public void setVignetteList(List<Vignette> vignetteList) {
        this.vignetteList = vignetteList;
    }*/

    public TypeOffre getIdTypeoffre() {
        return idTypeoffre;
    }

    public void setIdTypeoffre(TypeOffre idTypeoffre) {
        this.idTypeoffre = idTypeoffre;
    }

    public Category getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Category idCategory) {
        this.idCategory = idCategory;
    }

    public SousCategory getIdSousCategory() {
        return idSousCategory;
    }

    public void setIdSousCategory(SousCategory idSousCategory) {
        this.idSousCategory = idSousCategory;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }
    
    public Interest getIdInterest() {
        return idInterest;
    }

    public void setIdInterest(Interest idInterest) {
        this.idInterest = idInterest;
    }

    /*@XmlTransient
    public List<Notification> getNotificationList() {
        return notificationList;
    }

    public void setNotificationList(List<Notification> notificationList) {
        this.notificationList = notificationList;
    }

    @XmlTransient
    public List<InstitutionMenu> getInstitutionMenuList() {
        return institutionMenuList;
    }

    public void setInstitutionMenuList(List<InstitutionMenu> institutionMenuList) {
        this.institutionMenuList = institutionMenuList;
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
        hash += (idInstitution != null ? idInstitution.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Institution)) {
            return false;
        }
        Institution other = (Institution) object;
        if ((this.idInstitution == null && other.idInstitution != null) || (this.idInstitution != null && !this.idInstitution.equals(other.idInstitution))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qualshore.livindakar.mapping.Institution[ idInstitution=" + idInstitution + " ]";
    }
    
}
