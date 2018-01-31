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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "log")
@JsonIgnoreProperties(ignoreUnknown = false)
@Proxy(lazy = false)
@XmlRootElement

public class Log implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_log")
    private Integer idLog;

    public Log() {
    }

    public Log(Integer idLog) {
        this.idLog = idLog;
    }

    public Integer getIdLog() {
        return idLog;
    }

    public void setIdLog(Integer idLog) {
        this.idLog = idLog;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLog != null ? idLog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Log)) {
            return false;
        }
        Log other = (Log) object;
        if ((this.idLog == null && other.idLog != null) || (this.idLog != null && !this.idLog.equals(other.idLog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "qualshore.livindkr.main.entities.Log[ idLog=" + idLog + " ]";
    }
    
}
