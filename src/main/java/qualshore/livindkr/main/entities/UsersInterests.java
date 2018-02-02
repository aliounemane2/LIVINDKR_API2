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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "users_interests")
@JsonIgnoreProperties(ignoreUnknown = false)
@Proxy(lazy = false)
@XmlRootElement
public class UsersInterests implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Users_Interests")
    private Integer idUsersInterests;
    
    @Column(name = "id_user")
    private Integer idUser;
    
	@Column(name = "id_interest")
    private Integer idInterests;
    
    public Integer getIdUser() {
		return idUser;
	} 

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public Integer getIdInterests() {
		return idInterests;
	}

	public void setIdInterests(Integer idInterests) {
		this.idInterests = idInterests;
	}


   
    
    
    @JoinColumn(name = "id_user", insertable = false, updatable = false, referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private User user;
    
    
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Interest getInterest() {
		return interest;
	}

	public void setInterest(Interest interest) {
		this.interest = interest;
	}

	@JoinColumn(name = "id_interest", insertable = false, updatable = false, referencedColumnName = "id_interest")
    @ManyToOne(optional = false)
    private Interest interest;

    public UsersInterests() {
    }

    public UsersInterests(Integer idUsersInterests) {
        this.idUsersInterests = idUsersInterests;
    }

    public Integer getIdUsersInterests() {
        return idUsersInterests;
    }

    public void setIdUsersInterests(Integer idUsersInterests) {
        this.idUsersInterests = idUsersInterests;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsersInterests != null ? idUsersInterests.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersInterests)) {
            return false;
        }
        UsersInterests other = (UsersInterests) object;
        if ((this.idUsersInterests == null && other.idUsersInterests != null) || (this.idUsersInterests != null && !this.idUsersInterests.equals(other.idUsersInterests))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "qualshore.livindkr.main.entities.UsersInterests[ idUsersInterests=" + idUsersInterests + " ]";
    }

	


}
