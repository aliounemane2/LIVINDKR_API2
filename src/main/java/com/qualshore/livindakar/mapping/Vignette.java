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
@Table(name = "vignette")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vignette.findAll", query = "SELECT v FROM Vignette v")
    , @NamedQuery(name = "Vignette.findByIdVignette", query = "SELECT v FROM Vignette v WHERE v.idVignette = :idVignette")
    , @NamedQuery(name = "Vignette.findByNomVignette", query = "SELECT v FROM Vignette v WHERE v.nomVignette = :nomVignette")
    , @NamedQuery(name = "Vignette.findByCheminVignette", query = "SELECT v FROM Vignette v WHERE v.cheminVignette = :cheminVignette")})
public class Vignette implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vignette")
    private Integer idVignette;
    @Size(max = 100)
    @Column(name = "nom_vignette")
    private String nomVignette;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "chemin_vignette")
    private String cheminVignette;
    @JoinColumn(name = "id_Institution", referencedColumnName = "id_institution")
    @ManyToOne(optional = false)
    private Institution idInstitution;

    public Vignette() {
    }

    public Vignette(Integer idVignette) {
        this.idVignette = idVignette;
    }

    public Vignette(Integer idVignette, String cheminVignette) {
        this.idVignette = idVignette;
        this.cheminVignette = cheminVignette;
    }

    public Integer getIdVignette() {
        return idVignette;
    }

    public void setIdVignette(Integer idVignette) {
        this.idVignette = idVignette;
    }

    public String getNomVignette() {
        return nomVignette;
    }

    public void setNomVignette(String nomVignette) {
        this.nomVignette = nomVignette;
    }

    public String getCheminVignette() {
        return cheminVignette;
    }

    public void setCheminVignette(String cheminVignette) {
        this.cheminVignette = cheminVignette;
    }

    public Institution getIdInstitution() {
        return idInstitution;
    }

    public void setIdInstitution(Institution idInstitution) {
        this.idInstitution = idInstitution;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVignette != null ? idVignette.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vignette)) {
            return false;
        }
        Vignette other = (Vignette) object;
        if ((this.idVignette == null && other.idVignette != null) || (this.idVignette != null && !this.idVignette.equals(other.idVignette))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.qualshore.livindakar.mapping.Vignette[ idVignette=" + idVignette + " ]";
    }
    
}
